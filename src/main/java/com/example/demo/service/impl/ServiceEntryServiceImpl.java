@Service
public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository repo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository r, VehicleRepository v, GarageRepository g) {
        this.repo = r;
        this.vehicleRepo = v;
        this.garageRepo = g;
    }

    public ServiceEntry createServiceEntry(ServiceEntry e) {
        Vehicle v = vehicleRepo.findById(e.getVehicle().getId()).orElseThrow();
        Garage g = garageRepo.findById(e.getGarage().getId()).orElseThrow();

        if (!v.getActive()) throw new IllegalArgumentException("Only active vehicles allowed");
        if (!g.getActive()) throw new IllegalArgumentException("Inactive garage");

        if (e.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("future date");

        repo.findTopByVehicleOrderByOdometerReadingDesc(v).ifPresent(last -> {
            if (e.getOdometerReading() < last.getOdometerReading())
                throw new IllegalArgumentException(">=");
        });

        return repo.save(e);
    }

    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }
}
