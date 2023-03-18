package com.awadinhoo.code.drones.services;

import com.awadinhoo.code.drones.dto.ZoneDTO;

import java.util.List;

public interface ZoneService {
    ZoneDTO createZone(ZoneDTO zoneDTO);
    ZoneDTO updateZone(Long zoneId, ZoneDTO updatedZoneDTO);
    void deleteZone(Long zoneId);
    ZoneDTO getZoneById(Long zoneId);
    List<ZoneDTO> getZones();

}
