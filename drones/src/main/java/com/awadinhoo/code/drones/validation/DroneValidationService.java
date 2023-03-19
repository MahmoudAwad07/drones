package com.awadinhoo.code.drones.validation;

import com.awadinhoo.code.drones.enums.DroneState;

public interface DroneValidationService {
    void isDroneInInitialState(DroneState droneState);
    void isDroneExistBySerialNumber(String serialNumber);

}
