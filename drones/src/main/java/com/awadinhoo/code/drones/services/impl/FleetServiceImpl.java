package com.awadinhoo.code.drones.services.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.FleetDTO;
import com.awadinhoo.code.drones.entities.Fleet;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.mappers.FleetMapper;
import com.awadinhoo.code.drones.repositories.FleetRepository;
import com.awadinhoo.code.drones.services.FleetService;
import com.awadinhoo.code.drones.validation.FleetValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetServiceImpl implements FleetService {

    private final FleetRepository fleetRepository;
    private final FleetValidationService fleetValidationService;

    private final FleetMapper fleetMapper;

    public FleetServiceImpl(FleetRepository fleetRepository,
                            FleetValidationService fleetValidationService,
                            FleetMapper fleetMapper) {
        this.fleetRepository = fleetRepository;
        this.fleetValidationService = fleetValidationService;
        this.fleetMapper = fleetMapper;
    }

    @Override
    public FleetDTO createFleet(FleetDTO fleetDTO) {

        // check if there is a fleet with the same name already in DB, if found throw an exception
        fleetValidationService.isFleetAlreadyExistByName(fleetDTO.getName());

        // check if the fleet is empty
        fleetValidationService.isFleetIsEmpty(fleetDTO.getDrones());

        // check the number of drones doesn't exceed the limit
        fleetValidationService.isExceedsFleetLimit(fleetDTO.getMaxNumberOfDrones() , fleetDTO.getDrones());

        Fleet fleetEntity = fleetMapper.getFleetEntityFromDTO(fleetDTO);

        return fleetMapper.getFleetDTOFromEntity(fleetRepository.save(fleetEntity));
    }

    @Override
    public FleetDTO updateFleet(Long fleetId, FleetDTO updatedFleetDTO) {

        // check if the fleetId id in the request is the same on the body for security reasons
        if(!fleetId.equals(updatedFleetDTO.getFleetId())){
            throw new DronesCustomException(Constants.StatusMessages.INVALID_REQUEST_MESSAGE);
        }

        // check if the fleet is found on DB or not, if not throw an exception
        Fleet oldFleet = fleetValidationService.isFleetAlreadyExistById(fleetId);

        // check if there is a fleet with the same name already in DB, if found throw an exception
        fleetValidationService.isUpdatedNameOnAnotherFleet(fleetId , updatedFleetDTO.getName());

        // check the number of drones doesn't exceed the limit
        fleetValidationService.isExceedsFleetLimit(updatedFleetDTO.getMaxNumberOfDrones() , updatedFleetDTO.getDrones());

        Fleet updatedFleetEntity = fleetMapper.getFleetEntityFromDTO(updatedFleetDTO);


        return fleetMapper.getFleetDTOFromEntity(fleetRepository.save(updatedFleetEntity));
    }

    @Override
    public void deleteFleet(Long fleetId) {

        // check if the fleet is found on DB or not, if not throw an exception
        Fleet oldFleet = fleetValidationService.isFleetAlreadyExistById(fleetId);

        // TODO : check if there is any drone on the fleet is in delivering state

        fleetRepository.deleteById(fleetId);
    }

    @Override
    public List<FleetDTO> getAllFleets() {

        List<Fleet> allFleets = fleetRepository.findAll();

        if(allFleets == null || allFleets.isEmpty()){
            throw new DronesCustomException(Constants.StatusMessages.FLEETS_NOT_FOUND_MESSAGE);
        }
        return fleetMapper.getListFleetDTOFromEntities(allFleets);
    }

    @Override
    public FleetDTO getFleetById(Long fleetId) {

        // check if the fleet is found on DB or not, if not throw an exception
        Fleet fleet = fleetValidationService.isFleetAlreadyExistById(fleetId);
        return fleetMapper.getFleetDTOFromEntity(fleet);
    }


}
