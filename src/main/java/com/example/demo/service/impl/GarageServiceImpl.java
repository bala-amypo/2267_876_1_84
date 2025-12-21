@Service
public class GarageServiceImpl {

    private final GarageRepository repo;

    public GarageServiceImpl(GarageRepository repo) {
        this.repo = repo;
    }

    public Garage createGarage(Garage g) {
        if (repo.findByGarageName(g.getGarageName()).isPresent())
            throw new IllegalArgumentException("Garage already exists");
        return repo.save(g);
    }
}
