package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.dto.HistoricalMonumentsDto;
import com.github.nataliaotrombke.demoapi.services.HistoricalMonumentsService;
import com.github.nataliaotrombke.demoapi.services.TownsService;
import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoricalMonumentsController {
    private final HistoricalMonumentsService historicalMonumentsService;
    private final TownsService townsService;

    public HistoricalMonumentsController(HistoricalMonumentsService historicalMonumentsService, TownsService townsService) {
        this.historicalMonumentsService = historicalMonumentsService;
        this.townsService = townsService;
    }

    @GetMapping("/historicalMonuments")
    public List<HistoricalMonuments> listAllHistoricalMonuments() {
        return historicalMonumentsService.getAll();
    }

    @PostMapping("/historicalMonuments")
    public ResponseEntity<?> createHistoricalMonument(@RequestBody HistoricalMonumentsDto historicalMonumentsDto) {
        var historicalMonumentsDb = new HistoricalMonuments();
        historicalMonumentsDb.setMonumentsName(historicalMonumentsDto.getMonumentsName());
        historicalMonumentsDb.setStreetName(historicalMonumentsDto.getStreetName());
        historicalMonumentsDb.setBuildingNumber(historicalMonumentsDto.getBuildingNumber());
        historicalMonumentsDb.setTypeOfHistoricalMonument(historicalMonumentsDto.getTypeOfHistoricalMonument());
        historicalMonumentsDb.setDateOfEntry(historicalMonumentsDto.getDateOfEntry());
        var foundTown = townsService.getSingle(historicalMonumentsDto.getTownsId());

        if (foundTown.isEmpty()) {
            return new ResponseEntity<>("Podałeś id miasta " + historicalMonumentsDto.getTownsId()+"  a tak się składa, że w bazie takiego nie ma", HttpStatus.NOT_FOUND);
        }

        historicalMonumentsDb.setTowns(foundTown.get());

        var created = historicalMonumentsService.create(historicalMonumentsDb);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PatchMapping("/historicalMonuments/{id}")
    public ResponseEntity<?> updateHistoricalMonument(
            @PathVariable int id,
            @RequestBody HistoricalMonumentsDto partialUpdate) {
        var optionalHistoricalMonuments = historicalMonumentsService.getSingle(id);

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
            if (partialUpdate.getTownsId() != 0){
                var foundTown = townsService.getSingle(partialUpdate.getTownsId()).get();
                existingMonument.setTowns(foundTown);
            }

            historicalMonumentsService.createOrUpdate(existingMonument);

            return new ResponseEntity<>(existingMonument, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/historicalMonuments/{id}")
    public ResponseEntity<?> getHistoricalMonuments(@PathVariable int id) {
        var item = historicalMonumentsService.getSingle(id);

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