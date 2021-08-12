package com.example.flightapp.services;

import com.example.flightapp.entities.City;
import com.example.flightapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public City getCityById(int id){
        return cityRepository.findById(id).get();
    }

    public Set<City> getCityByCountry(String country){
        return cityRepository.findCityByCountry(country);
    }

    public City getCityByName(String name){
        return cityRepository.findCityByName(name);
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public void deleteCity(int id){
        cityRepository.deleteById(id);
    }

}
