@Service
public class VerificationLogServiceImpl {

    private final VerificationLogRepository repo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository r, ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public VerificationLog createLog(VerificationLog log) {
        entryRepo.findById(log.getServiceEntry().getId()).orElseThrow();
        log.setVerifiedAt(LocalDateTime.now());
        return repo.save(log);
    }
}
