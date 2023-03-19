package com.awadinhoo.code.drones.mappers;

import com.awadinhoo.code.drones.dto.DroneDTO;
import com.awadinhoo.code.drones.dto.FleetDTO;
import com.awadinhoo.code.drones.entities.Drone;
import com.awadinhoo.code.drones.entities.Fleet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DroneMapper {

    DroneDTO getDroneDTOFromEntity(Drone droneEntity);
    Drone getDroneEntityFromDTO(DroneDTO droneDTO);
    List<DroneDTO> getListDroneDTOFromEntities(List<Drone> droneList);
    List<Drone> getListDroneEntityFromDTOs(List<DroneDTO> droneDTOList);


}
