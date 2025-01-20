package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import com.github.nataliaotrombke.demodata.repositories.HistoricalMonumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HistoricalMonumentsService {
    private HistoricalMonumentsRepository HistoricalMonumentsRepo;

    public HistoricalMonumentsService(HistoricalMonumentsRepository historicalMonumentsRepo) {
        HistoricalMonumentsRepo = historicalMonumentsRepo;
    }

    public List<HistoricalMonuments>getAll(){
        return HistoricalMonumentsRepo.findAll();
    }

    public int create(HistoricalMonuments historicalMonuments) {
        var created = HistoricalMonumentsRepo.save(historicalMonuments);
        return created.getMonumentsId();
    }

    public int createOrUpdate(HistoricalMonuments historicalMonuments) {
        var created = HistoricalMonumentsRepo.save(historicalMonuments);
        return created.getMonumentsId();
    }

    public Optional<HistoricalMonuments> getSignle(int id) {
        return HistoricalMonumentsRepo.findById(id);
    }

    public boolean delete(int id) {
        if (HistoricalMonumentsRepo.existsById(id)) {
            HistoricalMonumentsRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}