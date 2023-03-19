package com.awadinhoo.code.drones.validation.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.entities.Medication;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.exception.ResourceNotFoundException;
import com.awadinhoo.code.drones.repositories.MedicationRepository;
import com.awadinhoo.code.drones.validation.MedicationValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicationValidationServiceImpl implements MedicationValidationService {

    private final MedicationRepository medicationRepository;

    public MedicationValidationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public boolean isMedicationAlreadyExistByNameOrCode(String medicationName, String medicationCode) {

        Optional<Medication> medicationOptional = medicationRepository.findByNameOrCode(medicationName, medicationCode);

        if(medicationOptional.isPresent()){

            Medication medicationFound = medicationOptional.get();
            if(medicationFound.getName().equalsIgnoreCase(medicationName)){
                throw new DronesCustomException(Constants.StatusMessages.MEDICATION_ALREADY_EXIST_BY_NAME_MESSAGE + medicationName);
            }else {
                throw new DronesCustomException(Constants.StatusMessages.MEDICATION_ALREADY_EXIST_BY_CODE_MESSAGE + medicationCode);
            }
        }

        return false;
    }

    @Override
    public boolean isMedicationAlreadyExistByNameOrCodeOnAnother(Long medicationId, String medicationName, String medicationCode) {

        Optional<Medication> medicationOptional = medicationRepository.findByIdNotAndNameAndCode(medicationId, medicationName, medicationCode);

        if(medicationOptional.isPresent()){

            Medication medicationFound = medicationOptional.get();
            if(medicationFound.getName().equalsIgnoreCase(medicationName)){
                throw new DronesCustomException(Constants.StatusMessages.MEDICATION_ALREADY_EXIST_BY_NAME_MESSAGE + medicationName);
            }else {
                throw new DronesCustomException(Constants.StatusMessages.MEDICATION_ALREADY_EXIST_BY_CODE_MESSAGE + medicationCode);
            }
        }

        return false;
    }

    @Override
    public Medication isMedicationAlreadyExistById(Long medicationId) {

        return medicationRepository.findById(medicationId)
                .orElseThrow(()-> new ResourceNotFoundException(Constants.StatusMessages.MEDICATION_NOT_FOUND_MESSAGE + medicationId));
    }
}
