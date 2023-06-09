package com.awadinhoo.code.drones.mappers;

import com.awadinhoo.code.drones.dto.CityDTO;
import com.awadinhoo.code.drones.entities.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    CityDTO getCityDTOFromEntity(City cityEntity);

    City getCityEntityFromDTO(CityDTO cityDTO);

    List<CityDTO> getListCityDTOFromEntities(List<City> cityEntityList);

    List<City> getListCityEntityFromDTOs(List<CityDTO> cityDTOList);
}
