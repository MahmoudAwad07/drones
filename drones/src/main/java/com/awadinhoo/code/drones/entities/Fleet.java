package com.awadinhoo.code.drones.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

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

    @OneToMany(mappedBy = "fleet")
    private Set<Drone> drones;
}
