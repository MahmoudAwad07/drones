package com.awadinhoo.code.drones.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MedicationDTO {

    private Long medicationId;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9_-]+$")
    private String code;
    @NotBlank
    @Min(1)
    private Integer weightInGrams;
    private Byte[] image;
}
