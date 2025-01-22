package com.github.nataliaotrombke.demoupdater.Controller;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class MuseumUpdaterController {

    final MuseumUpdater updater;

    public MuseumUpdaterController(MuseumUpdater updater) {
        this.updater = updater;
    }

    // start?city=miasto%20dcsd
    // start/miasto%20sdjvnsd

    @GetMapping("startMuseum")
    public ResponseEntity<String> start(@RequestParam String city) throws CsvValidationException, IOException, URISyntaxException {
        updater.updateByCity(city);

        return ResponseEntity.ok("Museum data update for city " + city);
    }
}