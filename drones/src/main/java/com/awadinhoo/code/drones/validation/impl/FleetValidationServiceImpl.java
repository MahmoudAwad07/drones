package com.awadinhoo.code.drones.validation.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.DroneDTO;
import com.awadinhoo.code.drones.entities.Fleet;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.exception.ResourceNotFoundException;
import com.awadinhoo.code.drones.repositories.FleetRepository;
import com.awadinhoo.code.drones.validation.FleetValidationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FleetValidationServiceImpl implements FleetValidationService {

    private final FleetRepository fleetRepository;

    public FleetValidationServiceImpl(FleetRepository fleetRepository) {
        this.fleetRepository = fleetRepository;
    }

    @Override
    public void isFleetAlreadyExistByName(String name) {

        Optional<Fleet> fleetOptional = fleetRepository.findByName(name);

        if(fleetOptional.isPresent()){
            throw new DronesCustomException(Constants.StatusMessages.FLEET_IS_FOUND_WITH_THE_SAME_NAME_MESSAGE + name);
        }
    }

    @Override
    public void isExceedsFleetLimit(Integer limit, List<DroneDTO> dronesList) {

        if(dronesList.size() > limit){
            throw new DronesCustomException(Constants.StatusMessages.NUMBER_OF_DRONES_EXCEEDS_FLEET_LIMIT_MESSAGE);
        }
    }

    @Override
    public void isFleetIsEmpty(List<DroneDTO> dronesList) {

        if(dronesList == null || dronesList.isEmpty()){
            throw new DronesCustomException(Constants.StatusMessages.FLEET_MUST_CONTAIN_AT_LEAST_ONE_DRONE_MESSAGE);
        }
    }

    @Override
    public Fleet isFleetAlreadyExistById(Long fleetId) {

        return fleetRepository.findById(fleetId).
                orElseThrow( () -> new ResourceNotFoundException(Constants.StatusMessages.FLEET_NOT_FOUND_MESSAGE + fleetId));

    }

    @Override
    public void isUpdatedNameOnAnotherFleet(Long fleetId , String name) {

        Optional<Fleet> fleetOptional = fleetRepository.findByIdNotAndName(fleetId, name);

        if(fleetOptional.isPresent()){
            throw new DronesCustomException(Constants.StatusMessages.FLEET_IS_FOUND_WITH_THE_SAME_NAME_MESSAGE + name);
        }
    }


}
