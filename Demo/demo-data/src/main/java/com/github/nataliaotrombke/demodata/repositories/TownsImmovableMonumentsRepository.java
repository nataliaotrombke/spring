package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.TownsImmovableMonuments;
import com.github.nataliaotrombke.demodata.databaseModel.TownsImmovableMonumentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownsImmovableMonumentsRepository extends JpaRepository<TownsImmovableMonuments, TownsImmovableMonumentsId> {

}