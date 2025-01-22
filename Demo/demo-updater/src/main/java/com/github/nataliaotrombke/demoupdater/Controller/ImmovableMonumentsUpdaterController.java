package com.github.nataliaotrombke.demoupdater.Controller;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class ImmovableMonumentsUpdaterController {

    final ImmovableMonumentsUpdater updater;

    public ImmovableMonumentsUpdaterController(ImmovableMonumentsUpdater updater) {
        this.updater = updater;
    }

    @GetMapping("startImmovableMonuments")
    public ResponseEntity<String> start(@RequestParam String city) throws CsvValidationException, IOException, URISyntaxException {
        updater.updateByCity(city);

        return ResponseEntity.ok("Successfully updated city");
    }
}
