package com.awadinhoo.code.drones.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "zone")
    private Set<City> cities;

    @OneToOne(mappedBy = "supportedZone")
    private Fleet fleet;
}
