
@Service
public class AzureMapsService {
    private final String AZURE_MAPS_BASE_URL = "https://atlas.microsoft.com/search/address/json";
    private final String API_KEY = "YOUR_AZURE_MAPS_KEY";

    @Autowired
    private RestTemplate restTemplate;

    public String searchAddress(String query) {
        String url = AZURE_MAPS_BASE_URL + "?api-version=1.0&subscription-key=" + API_KEY + "&query=" + URLEncoder.encode(query, StandardCharsets.UTF_8);
        return restTemplate.getForObject(url, String.class);
    }
}