package com.awadinhoo.code.drones.validation;

import com.awadinhoo.code.drones.dto.DroneDTO;
import com.awadinhoo.code.drones.entities.Fleet;

import java.util.List;

public interface FleetValidationService {

    void isFleetAlreadyExistByName(String name);
    void isExceedsFleetLimit(Integer limit, List<DroneDTO> dronesList);
    void isFleetIsEmpty(List<DroneDTO> dronesList);
    Fleet isFleetAlreadyExistById(Long fleetId);
    void isUpdatedNameOnAnotherFleet(Long fleetId , String name);

}
