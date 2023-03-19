package com.awadinhoo.code.drones.controllers;


import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.MedicationDTO;
import com.awadinhoo.code.drones.dto.ZoneDTO;
import com.awadinhoo.code.drones.services.MedicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public ResponseEntity<MedicationDTO> createMedication(@Valid @RequestBody MedicationDTO medicationDTO) {
        // create medication
        MedicationDTO createdMedication = medicationService.createMedication(medicationDTO);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);

    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<MedicationDTO> updateMedication(@PathVariable("medicationId") Long medicationId, @RequestBody MedicationDTO medicationDTO){

        MedicationDTO updatedMedicationDTO = medicationService.updateMedication(medicationId, medicationDTO);
        return new ResponseEntity<>(updatedMedicationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable("medicationId") Long medicationId){

        medicationService.deleteMedication(medicationId);
        return new ResponseEntity<>(Constants.StatusMessages.MEDICATION_DELETED_SUCCESSFULLY_MESSAGE , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> getAllZones(){

        List<MedicationDTO> allMedications = medicationService.getMedications();
        return new ResponseEntity<>(allMedications, HttpStatus.OK);
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<MedicationDTO> getMedicationById(@PathVariable("medicationId") Long medicationId){

        MedicationDTO medication = medicationService.getMedicationById(medicationId);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }
}
