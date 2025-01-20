package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.services.VoivodeshipsService;
import com.github.nataliaotrombke.demodata.databaseModel.Voivodeships;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoivodeshipsControler {
    private VoivodeshipsService voivodeshipsService;

    public VoivodeshipsControler(VoivodeshipsService voivodeshipsService) {
        this.voivodeshipsService = voivodeshipsService;
    }

    @GetMapping("/voivodeships")
    public List<Voivodeships> getAllVoivodeships() {
        return voivodeshipsService.getAll();
    }

    @PostMapping("/voivodeships")
    public int createVoivodeship(@RequestBody Voivodeships voivodeships) {
        return voivodeshipsService.create(voivodeships);
    }

    @PatchMapping("/voivodeships/{id}")
    public ResponseEntity<?> updateVoivodeships(
            @PathVariable int id,
            @RequestBody Voivodeships partialUpdate) {
        var optionalVoivodeships = voivodeshipsService.getSignle(id);

        if (optionalVoivodeships.isPresent()) {
            Voivodeships existingVoivodeships = optionalVoivodeships.get();

            if (partialUpdate.getVoivodeshipsName() != null) {
                existingVoivodeships.setVoivodeshipsName(partialUpdate.getVoivodeshipsName());
            }

            voivodeshipsService.createOrUpdate(existingVoivodeships);

            return new ResponseEntity<>(existingVoivodeships, HttpStatus.OK);
        }

        return new ResponseEntity<>("The given Id doesn't exist in the database",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/voivodeships/{id}")
    public ResponseEntity<?> getVoivodeships(@PathVariable int id) {
        var item = voivodeshipsService.getSignle(id);

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