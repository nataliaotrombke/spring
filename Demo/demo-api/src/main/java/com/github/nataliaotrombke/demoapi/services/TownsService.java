package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownsService {
    private final TownsRepository townRepo;

    public TownsService(TownsRepository townRepo) {
        this.townRepo = townRepo;
    }

    public List<Towns> getAll() {
        return townRepo.findAll();
    }

    public int create(Towns towns) {
        var created = townRepo.save(towns);
        return created.getTownsId();
    }

    public int createOrUpdate(Towns towns) {
        var created = townRepo.save(towns);
        return created.getTownsId();
    }

    public Optional<Towns> getSingle(int id) {
        return townRepo.findById(id);
    }

    public boolean delete(int id) {
        if (townRepo.existsById(id)) {
            townRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
