package com.awadinhoo.code.drones.mappers;

import com.awadinhoo.code.drones.dto.MedicationDTO;
import com.awadinhoo.code.drones.entities.Medication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MedicationMapper {

    MedicationDTO getMedicationDTOFromEntity(Medication medicationEntity);

    Medication getMedicationEntityFromDTO(MedicationDTO medicationDTO);

    List<MedicationDTO> getListMedicationDTOFromEntities(List<Medication> medicationList);

    List<Medication> getListMedicationEntityFromDTOs(List<MedicationDTO> medicationDTOList);
}
