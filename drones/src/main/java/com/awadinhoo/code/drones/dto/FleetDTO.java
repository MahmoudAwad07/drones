package com.awadinhoo.code.drones.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class FleetDTO {

    private Long fleetId;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;
    @NotBlank
    @Min(1)
    private Integer maxNumberOfDrones;
    @NotNull
    @Valid
    private List<DroneDTO> drones;
    @NotBlank
    @Min(0)
    @Max(1)
    private Integer active;
}
