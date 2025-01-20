package com.github.nataliaotrombke.demoapi.controllers;

import com.github.nataliaotrombke.demoapi.services.TownsVoivodeshipsService;
import com.github.nataliaotrombke.demodata.databaseModel.TownsVoivodeships;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TownsVoivodeshipsControler {
    private TownsVoivodeshipsService townsVoivodeshipsService;

    public TownsVoivodeshipsControler(TownsVoivodeshipsService townsVoivodeshipsService) {
        this.townsVoivodeshipsService = townsVoivodeshipsService;
    }

    @GetMapping("/townsVoivodeships")
    public List<TownsVoivodeships> getAllTownsVoivodeships() {
        return townsVoivodeshipsService.getAll();
    }

    @PostMapping("/townsVoivodeships")
    public int createTownsVoivodeships(@RequestBody TownsVoivodeships townsVoivodeships) {
        return townsVoivodeshipsService.create(townsVoivodeships);
    }

    @GetMapping("/townsVoivodeships/{id}")
    public ResponseEntity<?> getTownsVoivodeships(@PathVariable int id) {
        var item = townsVoivodeshipsService.getSignle(id);

        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/townsVoivodeships/{key1}/{key2}")
    public ResponseEntity<String> deleteTownsVoivodeships(
            @PathVariable int key1,
            @PathVariable int key2) {
        boolean isDeleted = townsVoivodeshipsService.delete(key1, key2);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted # " + key1 + key2, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The given Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}