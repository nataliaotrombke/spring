package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.HistoricalMonuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoricalMonumentsRepository extends JpaRepository<HistoricalMonuments, Integer> {

    Optional<HistoricalMonuments> findHistoricalMonumentsByMonumentsName(String historicalMonumentsName);

}
