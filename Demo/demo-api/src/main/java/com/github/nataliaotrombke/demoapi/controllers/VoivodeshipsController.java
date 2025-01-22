package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.dto.VoivodeshipsDto;
import com.github.nataliaotrombke.demoapi.services.TownsService;
import com.github.nataliaotrombke.demoapi.services.VoivodeshipsService;
import com.github.nataliaotrombke.demodata.databaseModel.Voivodeships;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoivodeshipsController {
    private final VoivodeshipsService voivodeshipsService;
    private final TownsService townsService;

    public VoivodeshipsController(VoivodeshipsService voivodeshipsService, TownsService townsService) {
        this.voivodeshipsService = voivodeshipsService;
        this.townsService = townsService;
    }

    @GetMapping("/voivodeships")
    public List<Voivodeships> getAllVoivodeships() {
        return voivodeshipsService.getAll();
    }

    @PostMapping("/voivodeships")
    public int createVoivodeship(@RequestBody VoivodeshipsDto voivodeshipsDto) {
        var voivodeshipsDb = new Voivodeships();
        voivodeshipsDb.setVoivodeshipsName(voivodeshipsDto.getVoivodeshipsName());
        return voivodeshipsService.create(voivodeshipsDb);
    }

    @PatchMapping("/voivodeships/{id}")
    public ResponseEntity<?> updateVoivodeships(
            @PathVariable int id,
            @RequestBody VoivodeshipsDto partialUpdate) {
        var optionalVoivodeships = voivodeshipsService.getSingle(id);

        if (optionalVoivodeships.isPresent()) {
            Voivodeships existingVoivodeships = optionalVoivodeships.get();

            if (partialUpdate.getVoivodeshipsName() != null) {
                existingVoivodeships.setVoivodeshipsName(partialUpdate.getVoivodeshipsName());
            }

            voivodeshipsService.createOrUpdate(existingVoivodeships);

            return new ResponseEntity<>(existingVoivodeships, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/voivodeships/{id}")
    public ResponseEntity<?> getVoivodeships(@PathVariable int id) {
        var item = voivodeshipsService.getSingle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/voivodeships/{id}")
    public ResponseEntity<String> deleteVoivodeships(@PathVariable int id) {
        boolean isDeleted = voivodeshipsService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + id, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}