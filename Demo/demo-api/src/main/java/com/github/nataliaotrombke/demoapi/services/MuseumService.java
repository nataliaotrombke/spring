package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Museums;
import com.github.nataliaotrombke.demodata.repositories.MuseumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    private MuseumRepository MuseumRepo;

    public MuseumService(MuseumRepository museumRepo) {
        MuseumRepo = museumRepo;
    }
    public List<Museums>getAll() {
        return MuseumRepo.findAll();
    }

    public int create(Museums museums) {
        var created = MuseumRepo.save(museums);

        return created.getMuseumsId();
    }

    public int createOrUpdate(Museums museums) {
        var created = MuseumRepo.save(museums);
        return created.getMuseumsId();
    }

    public Optional<Museums> getSignle(int id) {
        return MuseumRepo.findById(id);
    }

    public boolean delete(int id) {
        if (MuseumRepo.existsById(id)) {
            MuseumRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
