package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.services.MuseumService;
import com.github.nataliaotrombke.demodata.databaseModel.Museums;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MuseumControler {
    private MuseumService museumService;

    public MuseumControler(MuseumService museumService) {
        this.museumService = museumService;
    }

    @GetMapping("/museums")
    public List<Museums> listAllMuseums() {
        return museumService.getAll();
    }

    @PostMapping("/museums")
    public int createMuseum(@RequestBody Museums museums) {
        return museumService.create(museums);
    }

    @PatchMapping("/museums/{id}")
    public ResponseEntity<?> updateMuseumst(
            @PathVariable int id,
            @RequestBody Museums partialUpdate) {
        var optionalMuseums = museumService.getSignle(id);

        if (optionalMuseums.isPresent()) {
            Museums existingMonument = optionalMuseums.get();

            if (partialUpdate.getMuseumsName() != null) {
                existingMonument.setMuseumsName(partialUpdate.getMuseumsName());
            }
            if (partialUpdate.getStreetName() != null) {
                existingMonument.setStreetName(partialUpdate.getStreetName());
            }
            if (partialUpdate.getBuildingNumber() != 0){
                existingMonument.setBuildingNumber(partialUpdate.getBuildingNumber());
            }

            museumService.createOrUpdate(existingMonument);

            return new ResponseEntity<>(existingMonument, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/museums/{id}")
    public ResponseEntity<?> getMuseums(@PathVariable int id) {
        var item = museumService.getSignle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/museums/{id}")
    public ResponseEntity<String> deleteMuseums(@PathVariable int id) {
        boolean isDeleted = museumService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + id, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}
