@Override
public ServiceEntry createServiceEntry(ServiceEntry entry) {

    Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
            .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

    if (!vehicle.getActive()) {
        throw new IllegalArgumentException("active vehicles");
    }

    Garage garage = garageRepository.findById(entry.getGarage().getId())
            .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

    if (!garage.getActive()) {
        throw new IllegalArgumentException("Garage must be active");
    }

    if (entry.getServiceDate().isAfter(LocalDate.now())) {
        throw new IllegalArgumentException("future");
    }

    serviceEntryRepository
            .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
            .ifPresent(last -> {
                if (entry.getOdometerReading() < last.getOdometerReading()) {
                    throw new IllegalArgumentException(">=");
                }
            });

    entry.setVehicle(vehicle);
    entry.setGarage(garage);

    return serviceEntryRepository.save(entry);
}
