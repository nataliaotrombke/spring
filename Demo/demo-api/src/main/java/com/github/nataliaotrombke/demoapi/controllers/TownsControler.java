package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.services.TownsService;
import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
public class TownsControler {
    private TownsService townsService;

    public TownsControler(TownsService townsService) {
        this.townsService = townsService;
    }

    @GetMapping("/towns")
    public List<Towns> getAllTowns() {
        return townsService.getAll();
    }
    @PostMapping("/towns")
    public int createTown(@RequestBody Towns towns) {
        return townsService.create(towns);
    }

    @PatchMapping("/towns/{id}")
    public ResponseEntity<?> updateTowns(
            @PathVariable int id,
            @RequestBody Towns partialUpdate) {
        var optionalTowns = townsService.getSignle(id);

        if (optionalTowns.isPresent()) {
            Towns existingTowns = optionalTowns.get();

            if (partialUpdate.getTownsName() != null) {
                existingTowns.setTownsName(partialUpdate.getTownsName());
            }

            townsService.createOrUpdate(existingTowns);

            return new ResponseEntity<>(existingTowns, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/towns/{id}")
    public ResponseEntity<?> getTowns(@PathVariable int id) {
        var item = townsService.getSignle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/towns/{id}")
    public ResponseEntity<String> deleteTowns(@PathVariable int id) {
        boolean isDeleted = townsService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + id, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }


}