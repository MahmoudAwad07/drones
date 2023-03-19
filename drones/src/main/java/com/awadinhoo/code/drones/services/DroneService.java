package com.awadinhoo.code.drones.services;

import com.awadinhoo.code.drones.dto.DroneDTO;
import com.awadinhoo.code.drones.dto.FleetDTO;

import java.util.List;

public interface DroneService {

    DroneDTO createDrone(DroneDTO droneDTO);
    DroneDTO updateDrone(Long droneId, DroneDTO updatedFleetDTO);
    void deleteDrone(Long droneId);
    FleetDTO getFleetById(Long fleetId);
    List<DroneDTO> getAllDrones();
}
