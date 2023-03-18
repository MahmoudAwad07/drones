package com.awadinhoo.code.drones.repositories;

import com.awadinhoo.code.drones.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<List<City>> findByNameIn(List<String> cityNames);

    Optional<List<City>> findByIdNotAndByNameIn(Long cityId, List<String> cityNames);
}
