package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class AzureMapsService {

    @Value("${azure.maps.api.key}")
    private String azureMapsApiKey;

    private final String AZURE_MAPS_BASE_URL = "https://atlas.microsoft.com/search/address/json";
    private final String API_KEY = azureMapsApiKey;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    public String searchAddress(String query) {
        String url = AZURE_MAPS_BASE_URL + "?api-version=1.0&subscription-key=" + API_KEY + "&query=" + URLEncoder.encode(query, StandardCharsets.UTF_8);
        return restTemplate.getForObject(url, String.class);
    }
}