package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.services.HistoricalMonumentsService;
import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HistoricalMonumentsControler {
    private HistoricalMonumentsService historicalMonumentsService;

    public HistoricalMonumentsControler(HistoricalMonumentsService historicalMonumentsService) {
        this.historicalMonumentsService = historicalMonumentsService;
    }

    @GetMapping("/historicalMonuments")
    public  List<HistoricalMonuments> listAllHistoricalMonuments() {
        return historicalMonumentsService.getAll();
    }

    @PostMapping("/historicalMonuments")
    public int createHistoricalMonument(@RequestBody HistoricalMonuments historicalMonuments) {
        return historicalMonumentsService.createOrUpdate(historicalMonuments);
    }
    @PatchMapping("/historicalMonuments/{id}")
    public ResponseEntity<?> updateHistoricalMonument(
            @PathVariable int id,
            @RequestBody HistoricalMonuments partialUpdate) {
        var optionalHistoricalMonuments = historicalMonumentsService.getSignle(id);

        if (optionalHistoricalMonuments.isPresent()) {
            HistoricalMonuments existingMonument = optionalHistoricalMonuments.get();

            if (partialUpdate.getMonumentsName() != null) {
                existingMonument.setMonumentsName(partialUpdate.getMonumentsName());
            }
            if (partialUpdate.getTypeOfHistoricalMonument() != null) {
                existingMonument.setTypeOfHistoricalMonument(partialUpdate.getTypeOfHistoricalMonument());
            }
            if (partialUpdate.getDateOfEntry() != null) {
                existingMonument.setDateOfEntry(partialUpdate.getDateOfEntry());
            }
            if (partialUpdate.getStreetName() != null) {
                existingMonument.setStreetName(partialUpdate.getStreetName());
            }
            if (partialUpdate.getBuildingNumber() != 0) {
                existingMonument.setBuildingNumber(partialUpdate.getBuildingNumber());
            }

            historicalMonumentsService.createOrUpdate(existingMonument);

            return new ResponseEntity<>(existingMonument, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database",HttpStatus.NOT_FOUND);
    }


    @GetMapping("/historicalMonuments/{id}")
    public ResponseEntity<?> gethistoricalMonuments(@PathVariable int id) {
        var item = historicalMonumentsService.getSignle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/historicalMonuments/{id}")
    public ResponseEntity<String> deleteHistoricalMonuments(@PathVariable int id) {
        boolean isDeleted = historicalMonumentsService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + id, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}