package com.awadinhoo.code.drones.services;

import com.awadinhoo.code.drones.dto.FleetDTO;

import java.util.List;

public interface FleetService {

    FleetDTO createFleet(FleetDTO fleetDTO);
    FleetDTO updateFleet(Long fleetId, FleetDTO updatedFleetDTO);
    void deleteFleet(Long fleetId);
    FleetDTO getFleetById(Long fleetId);
    List<FleetDTO> getAllFleets();

}
