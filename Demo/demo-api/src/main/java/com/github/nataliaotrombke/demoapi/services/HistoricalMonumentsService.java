package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import com.github.nataliaotrombke.demodata.repositories.HistoricalMonumentsRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalMonumentsService {
    private final HistoricalMonumentsRepository historicalMonumentsRepo;

    public HistoricalMonumentsService(HistoricalMonumentsRepository historicalMonumentsRepo) {
        this.historicalMonumentsRepo = historicalMonumentsRepo;
    }

    @Cacheable(value = "historicalMonuments")
    public List<HistoricalMonuments> getAll() {
//        System.out.println("wywołano get all");
        return historicalMonumentsRepo.findAll();
    }

    @CacheEvict(value = "historicalMonuments", allEntries = true)
    public int create(HistoricalMonuments historicalMonuments) {
        var created = historicalMonumentsRepo.save(historicalMonuments);
        return created.getMonumentsId();
    }

    @CacheEvict(value = "historicalMonuments", allEntries = true)
    public int createOrUpdate(HistoricalMonuments historicalMonuments) {
        var created = historicalMonumentsRepo.save(historicalMonuments);
        return created.getMonumentsId();
    }

    @Cacheable(value = "historicalMonuments", key = "#id")
    public Optional<HistoricalMonuments> getSingle(int id) {
        return historicalMonumentsRepo.findById(id);
    }

    @CacheEvict(value = "historicalMonuments", key = "#id")
    public boolean delete(int id) {
        if (historicalMonumentsRepo.existsById(id)) {
            historicalMonumentsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
