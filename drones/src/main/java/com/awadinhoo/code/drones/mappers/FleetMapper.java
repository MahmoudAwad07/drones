package com.awadinhoo.code.drones.mappers;

import com.awadinhoo.code.drones.dto.FleetDTO;
import com.awadinhoo.code.drones.entities.Fleet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FleetMapper {

    FleetDTO getFleetDTOFromEntity(Fleet fleetEntity);
    Fleet getFleetEntityFromDTO(FleetDTO fleetDTO);
    List<FleetDTO> getListFleetDTOFromEntities(List<Fleet> fleetList);
    List<Fleet> getListFleetEntityFromDTOs(List<FleetDTO> fleetDTOList);


}
