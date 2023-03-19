package com.awadinhoo.code.drones.repositories;

import com.awadinhoo.code.drones.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    Optional<Medication> findByNameOrCode(String name, String code);

    Optional<Medication> findByIdNotAndNameAndCode(Long medicationId, String name, String code);
}
