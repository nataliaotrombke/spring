package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.ImmovableMonuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImmovableMonumentsRepository extends JpaRepository<ImmovableMonuments, Integer> {
    Optional<ImmovableMonuments> findFirstByMonumentsName(String monumentsName);
}
