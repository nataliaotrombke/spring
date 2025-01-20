package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.TownsHistoricalMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.TownsHistoricalMonumentsId;
import com.github.nataliaotrombke.demodata.repositories.TownsHistoricalMonumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownsHistoricalMonumentsService {
    private TownsHistoricalMonumentsRepository townsHistoricalMonumentsRepo;

    public TownsHistoricalMonumentsService(TownsHistoricalMonumentsRepository townsHistoricalMonumentsRepo) {
        this.townsHistoricalMonumentsRepo = townsHistoricalMonumentsRepo;
    }
    public List<TownsHistoricalMonuments> getAll() {
        return townsHistoricalMonumentsRepo.findAll();
    }
    public int create(TownsHistoricalMonuments townsHistoricalMonuments) {
        var created = townsHistoricalMonumentsRepo.save(townsHistoricalMonuments);
        return created.getTownsId();
    }

    public Optional<TownsHistoricalMonuments> getSignle(int id) {
        return Optional.empty();
    }

    public boolean delete(int key1, int key2) {
        TownsHistoricalMonumentsId compositeKey = new TownsHistoricalMonumentsId(key1, key2);
        if (townsHistoricalMonumentsRepo.existsById(compositeKey)) {
            townsHistoricalMonumentsRepo.deleteById(compositeKey);
            return true;
        }
        else {
            return false;
        }
    }
}