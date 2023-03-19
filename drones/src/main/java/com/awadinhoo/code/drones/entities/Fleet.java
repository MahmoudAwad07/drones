package com.awadinhoo.code.drones.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "FLEETS")
public class Fleet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fleetId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "SUPPORTED_ZONE_ID", referencedColumnName = "zoneId")
    private Zone supportedZone;

    @Column(name = "MAX_NUMBER_OF_DRONES", nullable = false)
    private Integer maxNumberOfDrones;

    @OneToMany(mappedBy = "fleet")
    private List<Drone> drones;

    @Column(name = "ACTIVE", nullable = false)
    private Integer active;
}
