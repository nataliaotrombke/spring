package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import com.github.nataliaotrombke.demodata.repositories.TownsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownsService {
    private TownsRepository TownRepo;

    public TownsService(TownsRepository townRepo) {
        TownRepo = townRepo;
    }

    public List<Towns> getAll(){
       return TownRepo.findAll();
    }

    public int create(Towns towns) {
        var created = TownRepo.save(towns);
        return created.getTownsId();
    }

    public int createOrUpdate(Towns towns) {
        var created = TownRepo.save(towns);
        return created.getTownsId();
    }

    public Optional<Towns> getSignle(int id) {
        return TownRepo.findById(id);
    }

    public boolean delete(int id) {
        if (TownRepo.existsById(id)) {
            TownRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}