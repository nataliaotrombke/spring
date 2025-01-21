package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.Towns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownsRepository extends JpaRepository<Towns, Integer> {
    Optional<Towns> findByTownsName(String townsName);

    Optional<Towns> findFirstByTownsName(String townName);
}