package com.awadinhoo.code.drones.repositories;

import com.awadinhoo.code.drones.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneRepository extends JpaRepository<Drone, Long> {

}
