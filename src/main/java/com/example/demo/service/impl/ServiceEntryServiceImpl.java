@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(
            ServiceEntryRepository serviceEntryRepository,
            VehicleRepository vehicleRepository,
            GarageRepository garageRepository
    ) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        // 1️⃣ Load managed Vehicle
        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!vehicle.getActive()) {
            throw new IllegalArgumentException("active vehicles");
        }

        // 2️⃣ Load managed Garage
        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (!garage.getActive()) {
            throw new IllegalArgumentException("Garage not active");
        }

        // 3️⃣ Validate service date
        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        // 4️⃣ Validate odometer
        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException(">=");
                    }
                });

        // 5️⃣ Attach managed entities
        entry.setVehicle(vehicle);
        entry.setGarage(garage);
        entry.setRecordedAt(LocalDateTime.now());

        // 6️⃣ SAVE
        return serviceEntryRepository.save(entry);
    }
}
