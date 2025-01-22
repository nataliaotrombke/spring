package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import com.github.nataliaotrombke.demodata.repositories.HistoricalMonumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalMonumentsService {
    private final HistoricalMonumentsRepository historicalMonumentsRepo;

    public HistoricalMonumentsService(HistoricalMonumentsRepository historicalMonumentsRepo) {
        this.historicalMonumentsRepo = historicalMonumentsRepo;
    }

    public List<HistoricalMonuments> getAll() {
        return historicalMonumentsRepo.findAll();
    }

    public int create(HistoricalMonuments historicalMonuments) {
        var created = historicalMonumentsRepo.save(historicalMonuments);
        return created.getMonumentsId();
    }

    public int createOrUpdate(HistoricalMonuments historicalMonuments) {
        var created = historicalMonumentsRepo.save(historicalMonuments);
        return created.getMonumentsId();
    }

    public Optional<HistoricalMonuments> getSingle(int id) {
        return historicalMonumentsRepo.findById(id);
    }

    public boolean delete(int id) {
        if (historicalMonumentsRepo.existsById(id)) {
            historicalMonumentsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
