package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.AzureMapsService;

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