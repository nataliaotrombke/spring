package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.TownsVoivodeships;
import com.github.nataliaotrombke.demodata.databaseModel.TownsVoivodeshipsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownsVoivodeshipsRepository extends JpaRepository<TownsVoivodeships, TownsVoivodeshipsId> {
}
