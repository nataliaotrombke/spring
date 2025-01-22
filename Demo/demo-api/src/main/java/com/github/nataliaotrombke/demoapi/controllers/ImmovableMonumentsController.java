package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.dto.ImmovableMonumentsDto;
import com.github.nataliaotrombke.demoapi.services.ImmovableMonumentsService;
import com.github.nataliaotrombke.demoapi.services.TownsService;
import com.github.nataliaotrombke.demodata.databaseModel.ImmovableMonuments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImmovableMonumentsController {
    private final TownsService townsService;
    private ImmovableMonumentsService immovableMonumentsService;

    public ImmovableMonumentsController(ImmovableMonumentsService immovableMonumentsService, TownsService townsService) {
        this.immovableMonumentsService = immovableMonumentsService;
        this.townsService = townsService;
    }

    @GetMapping("/immovableMonuments")
    public List<ImmovableMonuments> listAllImmovableMonuments() {
        return immovableMonumentsService.getAll();
    }

    @PostMapping("/immovableMonuments")
    public int createMonument(@RequestBody ImmovableMonuments immovableMonuments) {
        return immovableMonumentsService.create(immovableMonuments);
    }

    @PatchMapping("/immovableMonuments/{id}")
    public ResponseEntity<?> updateImmovableMonuments(
            @PathVariable int id,
            @RequestBody ImmovableMonumentsDto partialUpdate) {
        var optionalImmovableMonuments = immovableMonumentsService.getSingle(id);

        if (optionalImmovableMonuments.isPresent()) {
            ImmovableMonuments existingImmovableMonuments = optionalImmovableMonuments.get();

            if (partialUpdate.getMonumentsName() != null) {
                existingImmovableMonuments.setMonumentsName(partialUpdate.getMonumentsName());
            }
            if (partialUpdate.getArchitecturalStyle() != null) {
                existingImmovableMonuments.setArchitecturalStyle(partialUpdate.getArchitecturalStyle());
            }
            if (partialUpdate.getStreetName() != null) {
                existingImmovableMonuments.setStreetName(partialUpdate.getStreetName());
            }
            if (partialUpdate.getBuildingNumber() != 0) {
                existingImmovableMonuments.setBuildingNumber(partialUpdate.getBuildingNumber());
            }
            if (partialUpdate.getTownsId() != 0) {
                var foundTown = townsService.getSingle(partialUpdate.getTownsId()).get();
                existingImmovableMonuments.setTown(foundTown);
            }

            immovableMonumentsService.createOrUpdate(existingImmovableMonuments);

            return new ResponseEntity<>(existingImmovableMonuments, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/immovableMonuments/{id}")
    public ResponseEntity<?> getImmovableMonument(@PathVariable int id) {
        var item = immovableMonumentsService.getSingle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/immovableMonuments/{id}")
    public ResponseEntity<String> deleteImmovableMonument(@PathVariable int id) {
        boolean isDeleted = immovableMonumentsService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + id, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}