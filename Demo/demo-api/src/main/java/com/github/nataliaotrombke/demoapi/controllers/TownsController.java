package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.dto.TownsDto;
import com.github.nataliaotrombke.demoapi.dto.VoivodeshipsDto;
import com.github.nataliaotrombke.demoapi.services.TownsService;
import com.github.nataliaotrombke.demoapi.services.VoivodeshipsService;
import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TownsController {
    private final TownsService townsService;
    private final VoivodeshipsService voivodeshipsService;

    public TownsController(TownsService townsService, VoivodeshipsService voivodeshipsService) {
        this.townsService = townsService;
        this.voivodeshipsService = voivodeshipsService;
    }

    @GetMapping("/towns")
    public List<Towns> getAllTowns() {
        return townsService.getAll();
    }
    @PostMapping("/towns")
    public int createTown(@RequestBody TownsDto townsDto, VoivodeshipsDto voivodeshipsDto) {
        var townsDb =  new Towns();
        townsDb.setTownsName(townsDto.getTownsName());
        var foundVoivodeships = voivodeshipsService.getSingle(voivodeshipsDto.getVoivodeshipsId()).get();
        townsDb.setVoivodeships(foundVoivodeships);

        return townsService.create(townsDb);
    }

    @PatchMapping("/towns/{id}")
    public ResponseEntity<?> updateTowns(
            @PathVariable int id,
            @RequestBody TownsDto partialUpdate) {
        var optionalTowns = townsService.getSingle(id);

        if (optionalTowns.isPresent()) {
            Towns existingTowns = optionalTowns.get();

            if (partialUpdate.getTownsName() != null) {
                existingTowns.setTownsName(partialUpdate.getTownsName());
            }
            if (partialUpdate.getVoivodeshipsId() != 0) {
                var foundVoivodeships = voivodeshipsService.getSingle(partialUpdate.getVoivodeshipsId()).get();
                existingTowns.setVoivodeships(foundVoivodeships);
            }

            townsService.createOrUpdate(existingTowns);

            return new ResponseEntity<>(existingTowns, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/towns/{id}")
    public ResponseEntity<?> getTowns(@PathVariable int id) {
        var item = townsService.getSingle(id);

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