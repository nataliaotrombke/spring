package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Voivodeships;
import com.github.nataliaotrombke.demodata.repositories.VoivodeshipsRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoivodeshipsService {
    private final VoivodeshipsRepository voivodeshipsRepo;

    public VoivodeshipsService(VoivodeshipsRepository voivodeshipsRepo) {
        this.voivodeshipsRepo = voivodeshipsRepo;
    }

    @Cacheable(value = "voivodeships")
    public List<Voivodeships> getAll() {
        return voivodeshipsRepo.findAll();
    }

    @CacheEvict(value = "voivodeships", allEntries = true)
    public int create(Voivodeships voivodeships) {
        var created = voivodeshipsRepo.save(voivodeships);
        return created.getVoivodeshipsId();
    }

    @CacheEvict(value = "voivodeships", allEntries = true)
    public int createOrUpdate(Voivodeships voivodeships) {
        var created = voivodeshipsRepo.save(voivodeships);
        return created.getVoivodeshipsId();
    }

    @Cacheable(value = "voivodeships", key = "#id")
    public Optional<Voivodeships> getSingle(int id) {
        return voivodeshipsRepo.findById(id);
    }

    @CacheEvict(value = "voivodeships", key = "#id")
    public boolean delete(int id) {
        if (voivodeshipsRepo.existsById(id)) {
            voivodeshipsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}