package com.awadinhoo.code.drones.repositories;

import com.awadinhoo.code.drones.entities.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {

    Optional<Fleet> findByName(String name);

    Optional<Fleet> findByIdNotAndName(Long fleetId, String name);

}
