package com.example.flightapp.repositories;

import com.example.flightapp.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Set<City> findCityByCountry(String name);

    City findCityByName(String name);

}
