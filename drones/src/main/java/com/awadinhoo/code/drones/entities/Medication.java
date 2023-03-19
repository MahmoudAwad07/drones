package com.awadinhoo.code.drones.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MEDICATIONS")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "WEIGHT_IN_GRAMS", nullable = false)
    private Integer weightInGrams;

    @Lob
    @Column(name = "IMAGE", nullable = false)
    private Byte[] image;


}
