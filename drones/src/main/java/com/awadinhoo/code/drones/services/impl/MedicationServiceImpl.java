package com.awadinhoo.code.drones.services.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.MedicationDTO;
import com.awadinhoo.code.drones.entities.Medication;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.exception.ResourceNotFoundException;
import com.awadinhoo.code.drones.mappers.MedicationMapper;
import com.awadinhoo.code.drones.repositories.MedicationRepository;
import com.awadinhoo.code.drones.services.MedicationService;
import com.awadinhoo.code.drones.validation.MedicationValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {


    private final MedicationRepository medicationRepository;
    private final MedicationValidationService medicationValidationService;

    private final MedicationMapper medicationMapper;

    public MedicationServiceImpl(MedicationRepository medicationRepository,
                                 MedicationValidationService medicationValidationService,
                                 MedicationMapper medicationMapper) {
        this.medicationRepository = medicationRepository;
        this.medicationValidationService = medicationValidationService;
        this.medicationMapper = medicationMapper;
    }

    @Override
    public MedicationDTO createMedication(MedicationDTO medicationDTO) {

        // check if there is a medication with the same name and cod already exist on DB
        medicationValidationService.isMedicationAlreadyExistByNameOrCode(medicationDTO.getName(), medicationDTO.getCode());

        Medication medicationEntity = medicationMapper.getMedicationEntityFromDTO(medicationDTO);
        return medicationMapper.getMedicationDTOFromEntity(medicationRepository.save(medicationEntity));
    }

    @Override
    public MedicationDTO updateMedication(Long medicationId, MedicationDTO updatedMedicationDTO) {

        // check if the medication id in the request is the same on the body for security reasons
        if(!medicationId.equals(updatedMedicationDTO.getMedicationId())){
            throw new DronesCustomException(Constants.StatusMessages.INVALID_REQUEST_MESSAGE);
        }

        // check if the medication is already exist or not , if not throw resource not found exception
        Medication oldMedication = medicationValidationService.isMedicationAlreadyExistById(medicationId);

        // check if the new values already on another medication
        medicationValidationService.isMedicationAlreadyExistByNameOrCodeOnAnother(medicationId,
                updatedMedicationDTO.getName(),
                updatedMedicationDTO.getCode());

        Medication medicationUpdatedEntity = medicationMapper.getMedicationEntityFromDTO(updatedMedicationDTO);
        return medicationMapper.getMedicationDTOFromEntity(medicationRepository.save(medicationUpdatedEntity));
    }

    @Override
    public void deleteMedication(Long medicationId) {

        // check if the medication is already exist or not , if not throw resource not found exception
        Medication oldMedication = medicationValidationService.isMedicationAlreadyExistById(medicationId);
        medicationRepository.deleteById(medicationId);

    }

    @Override
    public MedicationDTO getMedicationById(Long medicationId) {

        // check if the medication is already exist or not , if not throw resource not found exception
        Medication oldMedication = medicationValidationService.isMedicationAlreadyExistById(medicationId);
        return medicationMapper.getMedicationDTOFromEntity(oldMedication);
    }

    @Override
    public List<MedicationDTO> getMedications() {
        List<Medication> allMedications = medicationRepository.findAll();

        if(allMedications == null || allMedications.isEmpty()){
            throw new DronesCustomException(Constants.StatusMessages.MEDICATIONS_NOT_FOUND_MESSAGE);
        }
        return medicationMapper.getListMedicationDTOFromEntities(allMedications);
    }
}
