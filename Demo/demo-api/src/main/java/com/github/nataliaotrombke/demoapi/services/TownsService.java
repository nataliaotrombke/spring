package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownsService {
    private final TownsRepository townRepo;

    public TownsService(TownsRepository townRepo) {
        this.townRepo = townRepo;
    }

    @Cacheable(value = "towns")
    public List<Towns> getAll() {
        return townRepo.findAll();
    }

    @CacheEvict(value = "towns", allEntries = true)
    public int create(Towns towns) {
        var created = townRepo.save(towns);
        return created.getTownsId();
    }

    @CacheEvict(value = "towns", allEntries = true)
    public int createOrUpdate(Towns towns) {
        var created = townRepo.save(towns);
        return created.getTownsId();
    }

    @Cacheable(value = "towns", key = "#id")
    public Optional<Towns> getSingle(int id) {
        return townRepo.findById(id);
    }

    @CacheEvict(value = "towns", key = "#id")
    public boolean delete(int id) {
        if (townRepo.existsById(id)) {
            townRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
