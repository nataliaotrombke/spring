package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Museums;
import com.github.nataliaotrombke.demodata.repositories.MuseumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    private final MuseumRepository museumRepo;

    public MuseumService(MuseumRepository museumRepo) {
        this.museumRepo = museumRepo;
    }

    public List<Museums> getAll() {
        return museumRepo.findAll();
    }

    public int create(Museums museums) {
        var created = museumRepo.save(museums);
        return created.getMuseumsId();
    }

    public int createOrUpdate(Museums museums) {
        var created = museumRepo.save(museums);
        return created.getMuseumsId();
    }

    public Optional<Museums> getSingle(int id) {
        return museumRepo.findById(id);
    }

    public boolean delete(int id) {
        if (museumRepo.existsById(id)) {
            museumRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}