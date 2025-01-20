package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.TownsHistoricalMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.TownsHistoricalMonumentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownsHistoricalMonumentsRepository extends JpaRepository<TownsHistoricalMonuments, TownsHistoricalMonumentsId> {

}