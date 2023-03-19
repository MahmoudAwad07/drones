package com.awadinhoo.code.drones.controllers;


import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.FleetDTO;
import com.awadinhoo.code.drones.dto.MedicationDTO;
import com.awadinhoo.code.drones.services.FleetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fleets")
public class FleetController {

    private final FleetService fleetService;

    public FleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    }

    @PostMapping
    public ResponseEntity<FleetDTO> createFleet(@Valid @RequestBody FleetDTO fleetDTO) {
        // create fleet
        FleetDTO createdFleet = fleetService.createFleet(fleetDTO);
        return new ResponseEntity<>(createdFleet, HttpStatus.CREATED);

    }

    @PutMapping("/{fleetId}")
    public ResponseEntity<FleetDTO> updateFleet(@PathVariable("fleetId") Long fleetId, @RequestBody FleetDTO fleetDTO){

        FleetDTO updatedFleet = fleetService.updateFleet(fleetId, fleetDTO);
        return new ResponseEntity<>(updatedFleet, HttpStatus.OK);
    }

    @DeleteMapping("/{fleetId}")
    public ResponseEntity<String> deleteFleet(@PathVariable("fleetId") Long fleetId){

        fleetService.deleteFleet(fleetId);
        return new ResponseEntity<>(Constants.StatusMessages.FLEET_DELETED_SUCCESSFULLY_MESSAGE , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FleetDTO>> getAllFleets(){

        List<FleetDTO> allFleets = fleetService.getAllFleets();
        return new ResponseEntity<>(allFleets, HttpStatus.OK);
    }

    @GetMapping("/{fleetId}")
    public ResponseEntity<FleetDTO> getFleetById(@PathVariable("fleetId") Long fleetId){

        FleetDTO fleet = fleetService.getFleetById(fleetId);
        return new ResponseEntity<>(fleet, HttpStatus.OK);
    }



}
