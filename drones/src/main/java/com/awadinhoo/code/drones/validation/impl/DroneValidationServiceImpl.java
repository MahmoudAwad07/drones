package com.awadinhoo.code.drones.validation.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.entities.Drone;
import com.awadinhoo.code.drones.enums.DroneState;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.repositories.DroneRepository;
import com.awadinhoo.code.drones.validation.DroneValidationService;

public class DroneValidationServiceImpl implements DroneValidationService {

    private final DroneRepository droneRepository;

    public DroneValidationServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void isDroneInInitialState(DroneState droneState) {

        if (!droneState.name().equals(DroneState.IDLE.name()))
            throw new DronesCustomException(Constants.StatusMessages.DRONE_IS_NOT_ON_INITIAL_STATE_MESSAGE);
    }

    @Override
    public void isDroneExistBySerialNumber(String serialNumber) {
       droneRepository.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new DronesCustomException(Constants.StatusMessages.DRONE_IS_FOUND_WITH_THE_SAME_SERIAL_NUMBER_MESSAGE + serialNumber));
    }
}
