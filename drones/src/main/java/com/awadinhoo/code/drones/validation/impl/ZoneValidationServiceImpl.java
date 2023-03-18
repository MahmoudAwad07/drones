package com.awadinhoo.code.drones.validation.impl;


import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.CityDTO;
import com.awadinhoo.code.drones.entities.Zone;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.exception.ResourceNotFoundException;
import com.awadinhoo.code.drones.repositories.ZoneRepository;
import com.awadinhoo.code.drones.validation.ZoneValidationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ZoneValidationServiceImpl implements ZoneValidationService {

    private final ZoneRepository zoneRepository;

    public ZoneValidationServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public boolean isZoneAlreadyExistByName(String zoneName) {

        // check if there is a zone in the database with the same name
        Optional<Zone> oldZone = zoneRepository.findByName(zoneName);

        if(oldZone.isPresent()){
            throw new DronesCustomException(Constants.StatusMessages.ZONE_IS_FOUND_WITH_THE_SAME_NAME_MESSAGE);
        }

        return false;
    }

    @Override
    public boolean isZoneAlreadyExistById(Long zoneId) {

        // check if the zone is already on database or not
        Optional<Zone> optionalZone = zoneRepository.findById(zoneId);

        if(optionalZone.isEmpty()){
            throw new ResourceNotFoundException(Constants.StatusMessages.ZONE_NOT_FOUND_MESSAGE + zoneId);
        }

        return false;
    }
}
