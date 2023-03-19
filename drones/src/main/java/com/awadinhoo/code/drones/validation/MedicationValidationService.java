package com.awadinhoo.code.drones.validation;

import com.awadinhoo.code.drones.entities.Medication;

public interface MedicationValidationService {
    boolean isMedicationAlreadyExistByNameOrCode(String medicationName, String medicationCode);

    boolean isMedicationAlreadyExistByNameOrCodeOnAnother(Long medicationId, String medicationName, String medicationCode);

    Medication isMedicationAlreadyExistById(Long medicationId);
}
