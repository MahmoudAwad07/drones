package com.awadinhoo.code.drones.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DRONES")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long droneId;

    @Column(name = "SERIAL_NUMBER", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "WEIGHT_LIMIT_IN_GRAMS", nullable = false)
    private Long weightLimitInGrams;

    @Column(name = "BATTERY_CAPACITY", nullable = false)
    private Integer batteryCapacity;

    // TODO : @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FLEET_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Fleet fleet;


}
