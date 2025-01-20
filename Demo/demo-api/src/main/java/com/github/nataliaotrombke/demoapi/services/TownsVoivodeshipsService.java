package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.TownsVoivodeships;
import com.github.nataliaotrombke.demodata.databaseModel.TownsVoivodeshipsId;
import com.github.nataliaotrombke.demodata.repositories.TownsVoivodeshipsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownsVoivodeshipsService {
    private TownsVoivodeshipsRepository townsVoivodeshipsRepo;

    public TownsVoivodeshipsService(TownsVoivodeshipsRepository townsVoivodeshipsRepo) {
        this.townsVoivodeshipsRepo = townsVoivodeshipsRepo;
    }

    public List<TownsVoivodeships> getAll() {
        return townsVoivodeshipsRepo.findAll();
    }

    public int create(TownsVoivodeships townsVoivodeships) {
        var created = townsVoivodeshipsRepo.save(townsVoivodeships);
        return created.getTownsId();
    }

    public Optional<TownsVoivodeships> getSignle(int id) {
        return Optional.empty();
    }

    public boolean delete(int key1, int key2) {
        TownsVoivodeshipsId compositeKey =new TownsVoivodeshipsId(key1,key2);
        if (townsVoivodeshipsRepo.existsById(compositeKey)) {
            townsVoivodeshipsRepo.deleteById(compositeKey);
            return true;
        }
        else {
            return false;
        }
    }
}