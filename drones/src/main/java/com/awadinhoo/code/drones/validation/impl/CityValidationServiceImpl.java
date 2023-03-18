package com.awadinhoo.code.drones.validation.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.CityDTO;
import com.awadinhoo.code.drones.entities.City;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.repositories.CityRepository;
import com.awadinhoo.code.drones.validation.CityValidationService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CityValidationServiceImpl implements CityValidationService {

    private final CityRepository cityRepository;

    public CityValidationServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean isCityNamesUnique(List<CityDTO> cityDTOList) {

        Set<String> cityNames = new HashSet<>();

        // check if there is duplicates in cities
        for (CityDTO cityDTO :cityDTOList){
            if(cityNames.contains(cityDTO.getName())){
                throw new DronesCustomException(Constants.StatusMessages.CITIES_MUST_BE_UNIQUE_MESSAGE);
            }else {
                cityNames.add(cityDTO.getName());
            }
        }

        return true;
    }

    @Override
    public boolean isCityAlreadyExist(List<CityDTO> cityDTOList) {

        Optional<List<City>> alreadyExistCities = cityRepository.findByNameIn(cityDTOList.stream()
                                                .map(CityDTO::getName)
                                                .collect(Collectors.toList()));

        if(alreadyExistCities.isPresent() && !alreadyExistCities.isEmpty() ){
            throw new DronesCustomException(Constants.StatusMessages.CITY_IS_ALREADY_SERVED_IN_ANOTHER_ZONE_MESSAGE + alreadyExistCities.get().get(0));
        }

        return false;
    }

    @Override
    public boolean isCityAlreadyExistInAnotherZone(Long cityId, List<CityDTO> cityDTOList) {

        Optional<List<City>> alreadyExistCities = cityRepository.findByIdNotAndByNameIn(cityId, cityDTOList.stream()
                .map(CityDTO::getName)
                .collect(Collectors.toList()));

        if(alreadyExistCities.isPresent() && !alreadyExistCities.isEmpty() ){
            throw new DronesCustomException(Constants.StatusMessages.CITY_IS_ALREADY_SERVED_IN_ANOTHER_ZONE_MESSAGE + alreadyExistCities.get().get(0));
        }

        return false;
    }
}
