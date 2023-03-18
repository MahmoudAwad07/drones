package com.awadinhoo.code.drones.services.impl;

import com.awadinhoo.code.drones.costants.Constants;
import com.awadinhoo.code.drones.dto.ZoneDTO;
import com.awadinhoo.code.drones.entities.City;
import com.awadinhoo.code.drones.entities.Zone;
import com.awadinhoo.code.drones.exception.DronesCustomException;
import com.awadinhoo.code.drones.exception.ResourceNotFoundException;
import com.awadinhoo.code.drones.mappers.CityMapper;
import com.awadinhoo.code.drones.mappers.ZoneMapper;
import com.awadinhoo.code.drones.repositories.ZoneRepository;
import com.awadinhoo.code.drones.services.ZoneService;
import com.awadinhoo.code.drones.validation.CityValidationService;
import com.awadinhoo.code.drones.validation.ZoneValidationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;


@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;
    private final ZoneMapper zoneMapper;
    private final CityMapper cityMapper;
    private final ZoneValidationService zoneValidationService;

    private final CityValidationService cityValidationService;


    public ZoneServiceImpl(ZoneRepository zoneRepository, ZoneMapper zoneMapper,
                           CityMapper cityMapper, ZoneValidationService zoneValidationService,
                           CityValidationService cityValidationService) {
        this.zoneMapper = zoneMapper;
        this.zoneRepository = zoneRepository;
        this.cityMapper = cityMapper;
        this.zoneValidationService = zoneValidationService;
        this.cityValidationService = cityValidationService;
    }

    @Override
    public ZoneDTO createZone(ZoneDTO zoneDTO) {

        // if returned will be false , or will not return and throw exception
        zoneValidationService.isZoneAlreadyExistByName(zoneDTO.getName());

        // check if there are duplicates in the list of cities, if there are duplicates will throw an exception
        cityValidationService.isCityNamesUnique(zoneDTO.getCities());

        // check if there are already served before in another zone, if so will throw an exception
        cityValidationService.isCityAlreadyExist(zoneDTO.getCities());

        // get the Entity form the DTO
        Zone zoneEntity = zoneMapper.getZoneEntityFromDTO(zoneDTO);
        // save the Zone Entity and get the Zone DTO from the result
        return zoneMapper.getZoneDTOFromEntity(zoneRepository.save(zoneEntity));
    }

    @Override
    public ZoneDTO updateZone(Long zoneId, ZoneDTO updatedZoneDTO) {

        // check if the zone id in the request is the same on the body for security reasons
        if(!zoneId.equals(updatedZoneDTO.getZoneId())){
          throw new DronesCustomException(Constants.StatusMessages.INVALID_REQUEST_MESSAGE);
        }

        // check if there are duplicates in the list of cities, if there are duplicates will throw an exception
        cityValidationService.isCityNamesUnique(updatedZoneDTO.getCities());

        // check if the zone is already on database or not , if not will throw a not found exception
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.StatusMessages.ZONE_NOT_FOUND_MESSAGE + zoneId));

        // check if there are already served before in another zone, not the same zone , if so will throw an exception
        cityValidationService.isCityAlreadyExistInAnotherZone(zoneId, updatedZoneDTO.getCities());

        zone.setName(updatedZoneDTO.getName());
        List<City> listCityDTOs = cityMapper.getListCityEntityFromDTOs(updatedZoneDTO.getCities());
        zone.setCities(new HashSet<>(listCityDTOs));

        return zoneMapper.getZoneDTOFromEntity(zoneRepository.save(zone));
    }

    @Override
    public void deleteZone(Long zoneId) {

        // check if the zone is already on database or not , if not will throw a not found exception
        zoneValidationService.isZoneAlreadyExistById(zoneId);
        zoneRepository.deleteById(zoneId);
    }

    @Override
    public ZoneDTO getZoneById(Long zoneId) {

        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.StatusMessages.ZONE_NOT_FOUND_MESSAGE + zoneId));

        return zoneMapper.getZoneDTOFromEntity(zone) ;
    }

    @Override
    public List<ZoneDTO> getZones() {

        List<Zone> allZones = zoneRepository.findAll();

        if(allZones == null && allZones.isEmpty()){
            throw new DronesCustomException(Constants.StatusMessages.ZONES_NOT_FOUND_MESSAGE);
        }

        return zoneMapper.getListZoneDTOFromEntities(allZones);

    }
}
