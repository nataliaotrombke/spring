package com.github.nataliaotrombke.demoapi.controllers;



import com.github.nataliaotrombke.demoapi.services.TownsHistoricalMonumentsService;
import com.github.nataliaotrombke.demodata.databaseModel.TownsHistoricalMonuments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TownsHistoricalMonumentsControlers {
    private TownsHistoricalMonumentsService townsHistoricalMonumentsService;

    public TownsHistoricalMonumentsControlers(TownsHistoricalMonumentsService townsHistoricalMonumentsService) {
        this.townsHistoricalMonumentsService = townsHistoricalMonumentsService;
    }

    @GetMapping("/townsHistoricalMonument")
    public List<TownsHistoricalMonuments>listAllTownsHistoricalMonuments() {
        return townsHistoricalMonumentsService.getAll();
    }

    @PostMapping("/townsHistoricalMonument")
    public int createTownsHistoricalMonuments(@RequestBody TownsHistoricalMonuments townsHistoricalMonuments) {
        return townsHistoricalMonumentsService.create(townsHistoricalMonuments);
    }

    @GetMapping("/townsHistoricalMonument/{id}")
    public ResponseEntity<?> getTownsHistoricalMonument(@PathVariable int id) {
        var item = townsHistoricalMonumentsService.getSignle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/townsHistoricalMonument/{key1}/{key2}")
    public ResponseEntity<String> deleteTownsHistoricalMonument(
            @PathVariable int key1,
            @PathVariable int key2) {
        boolean isDeleted = townsHistoricalMonumentsService.delete(key1, key2);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + key1 + key2, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}