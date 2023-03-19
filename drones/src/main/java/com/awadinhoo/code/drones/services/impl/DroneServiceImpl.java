package com.awadinhoo.code.drones.services.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.DroneDTO;
import com.awadinhoo.code.drones.dto.FleetDTO;
import com.awadinhoo.code.drones.entities.Drone;
import com.awadinhoo.code.drones.entities.Fleet;
import com.awadinhoo.code.drones.enums.DroneState;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.mappers.DroneMapper;
import com.awadinhoo.code.drones.repositories.DroneRepository;
import com.awadinhoo.code.drones.services.DroneService;
import com.awadinhoo.code.drones.validation.DroneValidationService;
import com.awadinhoo.code.drones.validation.FleetValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    private final FleetValidationService fleetValidationService;

    private final DroneValidationService droneValidationService;

    private final DroneMapper droneMapper;

    public DroneServiceImpl(DroneRepository droneRepository,
                            FleetValidationService fleetValidationService,
                            DroneValidationService droneValidationService,
                            DroneMapper droneMapper) {
        this.droneRepository = droneRepository;
        this.fleetValidationService = fleetValidationService;
        this.droneValidationService = droneValidationService;
        this.droneMapper = droneMapper;
    }

    @Override
    public DroneDTO createDrone(DroneDTO droneDTO) {

        // check if the fleet is on DB or not, if not throw an exception
        Fleet fleet = fleetValidationService.isFleetAlreadyExistById(droneDTO.getFleetId());

        // check if the Fleet is active or not
        if(fleet.getActive().equals(0)){
            throw new DronesCustomException(Constants.StatusMessages.FLEET_MUST_BE_IN_ACTIVE_STATE_MESSAGE + fleet.getFleetId());
        }

        // check on the drone state
        if(droneDTO.getState() != null){
            droneValidationService.isDroneInInitialState(droneDTO.getState());
        }else {
            // Initial State for the drone
            droneDTO.setState(DroneState.IDLE);
        }

        // check if there is drone with the same serial number
        droneValidationService.isDroneExistBySerialNumber(droneDTO.getSerialNumber());

        Drone createdDrone = droneRepository.save(droneMapper.getDroneEntityFromDTO(droneDTO));

        // TODO : Add the drone to the cached fleet

        return droneMapper.getDroneDTOFromEntity(createdDrone);
    }

    @Override
    public DroneDTO updateDrone(Long droneId, DroneDTO updatedFleetDTO) {
        return null;
    }

    @Override
    public void deleteDrone(Long droneId) {

    }

    @Override
    public FleetDTO getFleetById(Long fleetId) {
        return null;
    }

    @Override
    public List<DroneDTO> getAllDrones() {
        return null;
    }
}
