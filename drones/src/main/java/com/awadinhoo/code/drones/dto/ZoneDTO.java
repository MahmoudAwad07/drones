package com.awadinhoo.code.drones.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ZoneDTO {

    private Long zoneId;
    @NotBlank
    private String name;
    @NotNull
    @Valid
    private List<CityDTO> cities;

}
