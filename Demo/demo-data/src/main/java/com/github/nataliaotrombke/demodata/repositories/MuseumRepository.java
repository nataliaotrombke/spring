package com.github.nataliaotrombke.demodata.repositories;

import com.github.nataliaotrombke.demodata.databaseModel.Museums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuseumRepository extends JpaRepository<Museums, Integer> {

    Optional<Museums> findFirstByMuseumsName(String museumsName);
}
