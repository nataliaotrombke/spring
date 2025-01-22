package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.ImmovableMonuments;
import com.github.nataliaotrombke.demodata.repositories.ImmovableMonumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImmovableMonumentsService {
    private final ImmovableMonumentsRepository immovableMonumentsRepo;

    public ImmovableMonumentsService(ImmovableMonumentsRepository immovableMonumentsRepo) {
        this.immovableMonumentsRepo = immovableMonumentsRepo;
    }

    public List<ImmovableMonuments> getAll() {
        return immovableMonumentsRepo.findAll();
    }

    public int create(ImmovableMonuments immovableMonuments) {
        var created = immovableMonumentsRepo.save(immovableMonuments);
        return created.getMonumentsId();
    }

    public int createOrUpdate(ImmovableMonuments immovableMonuments) {
        var created = immovableMonumentsRepo.save(immovableMonuments);
        return created.getMonumentsId();
    }

    public Optional<ImmovableMonuments> getSingle(int id) {
        return immovableMonumentsRepo.findById(id);
    }

    public boolean delete(int id) {
        if (immovableMonumentsRepo.existsById(id)) {
            immovableMonumentsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
