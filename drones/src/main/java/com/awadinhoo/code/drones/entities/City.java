package com.awadinhoo.code.drones.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @JoinColumn(name = "ZONE_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Zone zone;

    @Column(name = "AVG_TIME_SECONDS_FOR_LIGHT_WEIGHT_DRONE", nullable = false)
    private Integer avgTimeSecondsForLightWeightDrone;

    @Column(name = "AVG_TIME_SECONDS_FOR_MIDDLE_WEIGHT_DRONE", nullable = false)
    private Integer avgTimeSecondsForMiddleWeightDrone;

    @Column(name = "AVG_TIME_SECONDS_FOR_CRUISE_WEIGHT_DRONE", nullable = false)
    private Integer avgTimeSecondsForCruiseWeightDrone;

    @Column(name = "AVG_TIME_SECONDS_FOR_HEAVY_WEIGHT_DRONE", nullable = false)
    private Integer avgTimeSecondsForHeavyWeightDrone;

    @Column(name = "AVG_BATTERY_CAPACITY_CONSUMED_PER_TRIP", nullable = false)
    private Integer avgBatteryCapacityConsumedPerTrip;
}
