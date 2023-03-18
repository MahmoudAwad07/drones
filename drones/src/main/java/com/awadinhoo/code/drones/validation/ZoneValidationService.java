package com.awadinhoo.code.drones.validation;

import com.awadinhoo.code.drones.dto.CityDTO;

import java.util.List;

public interface ZoneValidationService {
    boolean isZoneAlreadyExistByName(String zoneName);

    boolean isZoneAlreadyExistById(Long zoneId);
}
