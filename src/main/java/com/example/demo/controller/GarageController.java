@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage")
public class GarageController {

    private final GarageService service;

    public GarageController(GarageService service) {
        this.service = service;
    }

    // 🛠️ ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return service.createGarage(garage);
    }

    // 🛠️ ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        return service.updateGarage(id, garage);
    }

    // 🛠️ ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return service.getGarageById(id);
    }

    // 🛠️ ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Garage> getAll() {
        return service.getAllGarages();
    }

    // 🛠️ ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateGarage(id);
    }
}
