package com.awadinhoo.code.drones.controllers;


import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.DroneDTO;
import com.awadinhoo.code.drones.dto.FleetDTO;
import com.awadinhoo.code.drones.services.DroneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    public ResponseEntity<DroneDTO> createDrone(@Valid @RequestBody DroneDTO droneDTO) {
        // create drone
        DroneDTO createdDrone = droneService.createDrone(droneDTO);
        return new ResponseEntity<>(createdDrone, HttpStatus.CREATED);

    }

}
