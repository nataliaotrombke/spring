package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.dto.MuseumsDto;
import com.github.nataliaotrombke.demoapi.services.MuseumService;
import com.github.nataliaotrombke.demoapi.services.TownsService;
import com.github.nataliaotrombke.demodata.databaseModel.Museums;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MuseumController {
    private final MuseumService museumService;
    private final TownsService townsService;

    public MuseumController(MuseumService museumService, TownsService townsService) {
        this.museumService = museumService;
        this.townsService = townsService;
    }

    @GetMapping("/museums")
    public List<Museums> listAllMuseums() {
        return museumService.getAll();
    }

    @PostMapping("/museums")
    public ResponseEntity<?> createMuseum(@RequestBody MuseumsDto museumsDto) {
        var museumDb = new Museums();
        museumDb.setMuseumsName(museumsDto.getMuseumsName());
        museumDb.setBuildingNumber(museumsDto.getBuildingNumber());
        museumDb.setStreetName(museumsDto.getStreetName());
        var foundTown = townsService.getSingle(museumsDto.getTownsId());

        if (foundTown.isEmpty()){
            return new ResponseEntity<>("You have provided the city id " + museumsDto.getTownsId() +" and it so happens that in the base there is no such", HttpStatus.NOT_FOUND);
        }

        museumDb.setTown(foundTown.get());

        var created = museumService.create(museumDb);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PatchMapping("/museums/{id}")
    public ResponseEntity<?> updateMuseum(
            @PathVariable int id,
            @RequestBody MuseumsDto partialUpdate) {
        var optionalMuseums = museumService.getSingle(id);

        if (optionalMuseums.isPresent()) {
            Museums existingMuseum = optionalMuseums.get();

            if (partialUpdate.getMuseumsName() != null) {
                existingMuseum.setMuseumsName(partialUpdate.getMuseumsName());
            }
            if (partialUpdate.getStreetName() != null) {
                existingMuseum.setStreetName(partialUpdate.getStreetName());
            }
            if (partialUpdate.getBuildingNumber() != 0) {
                existingMuseum.setBuildingNumber(partialUpdate.getBuildingNumber());
            }
            if (partialUpdate.getTownsId() != 0){
                var foundTown = townsService.getSingle(partialUpdate.getTownsId());
                if (foundTown.isEmpty()){
                    return new ResponseEntity<>("You have provided the city id " + partialUpdate.getTownsId() + ", and it so happens that in the base there is no such.", HttpStatus.NOT_FOUND);
                }
                existingMuseum.setTown(foundTown.get());
            }

            museumService.createOrUpdate(existingMuseum);

            return new ResponseEntity<>(existingMuseum, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/museums/{id}")
    public ResponseEntity<?> getMuseum(@PathVariable int id) {
        var item = museumService.getSingle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/museums/{id}")
    public ResponseEntity<String> deleteMuseum(@PathVariable int id) {
        boolean isDeleted = museumService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + id, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}