package com.awadinhoo.code.drones.validation;

import com.awadinhoo.code.drones.dto.CityDTO;

import java.util.List;

public interface CityValidationService {

    boolean isCityNamesUnique(List<CityDTO> cityDTOList);

    boolean isCityAlreadyExist(List<CityDTO> cityDTOList);

    boolean isCityAlreadyExistInAnotherZone(Long cityId, List<CityDTO> cityDTOList);
}
