package com.github.nataliaotrombke.demoapi.services;

import com.github.nataliaotrombke.demodata.databaseModel.Voivodeships;
import com.github.nataliaotrombke.demodata.repositories.VoivodeshipsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoivodeshipsService {
    private VoivodeshipsRepository VoivodeshipsRepo;

    public VoivodeshipsService(VoivodeshipsRepository voivodeshipsRepo) {
        VoivodeshipsRepo = voivodeshipsRepo;
    }

    public List<Voivodeships> getAll() {
        return VoivodeshipsRepo.findAll();
    }

    public int create(Voivodeships voivodeships) {
        var created = VoivodeshipsRepo.save(voivodeships);
        return created.getVoivodeshipsId();
    }

    public int createOrUpdate(Voivodeships voivodeships) {
        var created = VoivodeshipsRepo.save(voivodeships);
        return created.getVoivodeshipsId();
    }

    public Optional<Voivodeships> getSignle(int id) {
        return VoivodeshipsRepo.findById(id);
    }

    public boolean delete(int id) {
        if (VoivodeshipsRepo.existsById(id)) {
            VoivodeshipsRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}