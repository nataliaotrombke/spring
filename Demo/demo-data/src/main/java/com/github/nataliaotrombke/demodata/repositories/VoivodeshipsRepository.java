package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.Voivodeships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoivodeshipsRepository extends JpaRepository<Voivodeships, Integer> {

    Optional<Voivodeships> findFirstByVoivodeshipsName(String voivodeshipsName);
}
