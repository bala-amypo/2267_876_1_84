@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // 👤 USER
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.createVehicle(vehicle);
    }

    // 👤 USER
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    // 👤 USER
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/vin/{vin}")
    public Vehicle getByVin(@PathVariable String vin) {
        return service.getVehicleByVin(vin);
    }

    // 👤 USER
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }

    // 👤 USER
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVehicle(id);
    }
}
