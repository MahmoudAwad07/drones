package com.awadinhoo.code.drones.mappers;

import com.awadinhoo.code.drones.dto.ZoneDTO;
import com.awadinhoo.code.drones.entities.Zone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ZoneMapper {

    ZoneDTO getZoneDTOFromEntity(Zone zoneEntity);
    Zone getZoneEntityFromDTO(ZoneDTO zoneDTO);

    List<ZoneDTO> getListZoneDTOFromEntities(List<Zone> ZoneEntityList);

    List<Zone> getListZoneEntityFromDTOs(List<ZoneDTO> zoneDTOList);

}
