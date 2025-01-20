package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.TownsImmovableMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.TownsImmovableMonumentsId;
import com.github.nataliaotrombke.demodata.repositories.TownsImmovableMonumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownsImmovableMonumentsService {
    private TownsImmovableMonumentsRepository townsImmovableMonumentsRepo;

    public TownsImmovableMonumentsService(TownsImmovableMonumentsRepository townsImmovableMonumentsRepo) {
        this.townsImmovableMonumentsRepo = townsImmovableMonumentsRepo;
    }

    public List<TownsImmovableMonuments> getAll() {
        return townsImmovableMonumentsRepo.findAll();
    }

    public int create(TownsImmovableMonuments townsImmovableMonuments) {
        var created = townsImmovableMonumentsRepo.save(townsImmovableMonuments);
        return created.getTownsId();
    }

    public Optional<TownsImmovableMonuments> getSignle(int id) {
            return Optional.empty();
    }

    public boolean delete(int key1, int key2) {
        TownsImmovableMonumentsId compositeKey = new TownsImmovableMonumentsId(key1, key2);
        if (townsImmovableMonumentsRepo.existsById(compositeKey)) {
            townsImmovableMonumentsRepo.deleteById(compositeKey);
            return true;
        }
        else {
            return false;
        }
    }
}