package com.awadinhoo.code.drones.entities;


import com.awadinhoo.code.drones.enums.DroneModel;
import com.awadinhoo.code.drones.enums.DroneState;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "MODEL", nullable = false)
    private DroneModel model;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", nullable = false)
    private DroneState state;

    @Column(name = "WEIGHT_LIMIT_IN_GRAMS", nullable = false)
    private Long weightLimitInGrams;

    @Column(name = "BATTERY_CAPACITY", nullable = false)
    private Integer batteryCapacity;

    // TODO : @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FLEET_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Fleet fleet;


}
