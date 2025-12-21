@Service
public class ServicePartServiceImpl {

    private final ServicePartRepository repo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository r, ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public ServicePart createPart(ServicePart p) {
        entryRepo.findById(p.getServiceEntry().getId()).orElseThrow();
        if (p.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity must be positive");
        return repo.save(p);
    }
}
