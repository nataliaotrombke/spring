package com.github.nataliaotrombke.demoapi.controllers;


import com.github.nataliaotrombke.demoapi.services.TownsImmovableMonumentsService;
import com.github.nataliaotrombke.demodata.databaseModel.TownsImmovableMonuments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TownsImmovableMonumentsControler {
    private TownsImmovableMonumentsService townsImmovableMonumentsService;

    public TownsImmovableMonumentsControler(TownsImmovableMonumentsService townsImmovableMonumentsService) {
        this.townsImmovableMonumentsService = townsImmovableMonumentsService;
    }

    @GetMapping("/townsImmovableMonuments")
    public List<TownsImmovableMonuments>listAllTownsImmovableMonuments() {
        return townsImmovableMonumentsService.getAll();
    }

    @PostMapping("/townsImmovableMonuments")
    public int createTownsImmovableMonuments(@RequestBody TownsImmovableMonuments townsImmovableMonuments) {
        return townsImmovableMonumentsService.create(townsImmovableMonuments);
    }

    @GetMapping("/townsImmovableMonuments/{id}")
    public ResponseEntity<?> getTownsImmovableMonuments(@PathVariable int id) {
        var item = townsImmovableMonumentsService.getSignle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/townsImmovableMonuments/{key1}/{key2}")
    public ResponseEntity<String> deleteTownsImmovableMonuments(
            @PathVariable int key1,
            @PathVariable int key2) {
        boolean isDeleted = townsImmovableMonumentsService.delete(key1, key2);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + key1 + key2, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}