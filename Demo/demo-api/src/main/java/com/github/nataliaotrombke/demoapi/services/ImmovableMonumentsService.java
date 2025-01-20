package com.github.nataliaotrombke.demoapi.services;


import com.github.nataliaotrombke.demodata.databaseModel.ImmovableMonuments;
import com.github.nataliaotrombke.demodata.repositories.ImmovableMonumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImmovableMonumentsService {
    private ImmovableMonumentsRepository ImmovableMonumentsRepo;

    public ImmovableMonumentsService(ImmovableMonumentsRepository immovableMonumentsRepo) {
        ImmovableMonumentsRepo = immovableMonumentsRepo;
    }

    public  List<ImmovableMonuments> getAll(){
       return ImmovableMonumentsRepo.findAll();
    }

    public int create(ImmovableMonuments immovableMonuments) {
        var create = ImmovableMonumentsRepo.save(immovableMonuments);
        return create.getMonumentsId();
    }

    public int createOrUpdate(ImmovableMonuments immovableMonuments) {
        var created = ImmovableMonumentsRepo.save(immovableMonuments);
        return created.getMonumentsId();
    }

    public Optional<ImmovableMonuments> getSignle(int id) {
        return ImmovableMonumentsRepo.findById(id);
    }

    public boolean delete(int id) {
        if (ImmovableMonumentsRepo.existsById(id)) {
            ImmovableMonumentsRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}