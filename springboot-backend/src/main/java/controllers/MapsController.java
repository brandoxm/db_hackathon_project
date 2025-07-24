@RestController
@RequestMapping("/api/maps")
public class MapsController {

    @Autowired
    private AzureMapsService mapsService;

    @GetMapping("/search")
    public ResponseEntity<String> searchAddress(@RequestParam String query) {
        String response = mapsService.searchAddress(query);
        return ResponseEntity.ok(response);
    }
}