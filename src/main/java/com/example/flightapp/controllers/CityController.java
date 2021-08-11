package com.example.flightapp.controllers;

import com.example.flightapp.entities.City;
import com.example.flightapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities(){
        return cityRepository.findAll();
    }

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable("id") int id){
        return cityRepository.findById(id).get();
    }

    @GetMapping("/cities/country/{country}")
    public Set<City> getCityByCountry(@PathVariable("country") String country){
        return cityRepository.findCityByCountry(country);
    }

    @GetMapping("/cities/name/{name}")
    public City getCityByName(@PathVariable("name") String name){
        return cityRepository.findCityByName(name);
    }

    @PostMapping("/cities")
    public City saveCity(@RequestBody City city){
        return cityRepository.save(city);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") int id){
        cityRepository.deleteById(id);
    }

}
