package com.awadinhoo.code.drones.dto;

import com.awadinhoo.code.drones.entities.Fleet;
import com.awadinhoo.code.drones.enums.DroneModel;
import com.awadinhoo.code.drones.enums.DroneState;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DroneDTO {

    private Long droneId;
    @NotBlank
    @Size(max = 100)
    private String serialNumber;
    @NotBlank
    private DroneModel model;
    private DroneState state;
    @NotBlank
    @Min(1)
    private Long weightLimitInGrams;
    @NotBlank
    @Min(1)
    @Max(100)
    private Integer batteryCapacity;
    private Long fleetId;
    @NotBlank
    @Min(0)
    @Max(1)
    private Integer active;


}
