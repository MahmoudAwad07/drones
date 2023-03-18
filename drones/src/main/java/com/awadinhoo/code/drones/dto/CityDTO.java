package com.awadinhoo.code.drones.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CityDTO {

    private Long cityId;
    @NotBlank
    private String name;
    @NotBlank
    @Min(60)
    private Integer avgTimeSecondsForLightWeightDrone;
    @NotBlank
    @Min(60)
    private Integer avgTimeSecondsForMiddleWeightDrone;
    @NotBlank
    @Min(60)
    private Integer avgTimeSecondsForCruiseWeightDrone;
    @NotBlank
    @Min(60)
    private Integer avgTimeSecondsForHeavyWeightDrone;
    @NotBlank
    @Min(1)
    @Max(100)
    private Integer avgBatteryCapacityConsumedPerTrip;
}
