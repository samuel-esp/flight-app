package com.example.flightapp.controllers;

import com.example.flightapp.entities.City;
import com.example.flightapp.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getCities(){
        return cityService.getCities();
    }

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable("id") int id){
        return cityService.getCityById(id);
    }

    @GetMapping("/cities/country/{country}")
    public Set<City> getCityByCountry(@PathVariable("country") String country){
        return cityService.getCityByCountry(country);
    }

    @GetMapping("/cities/name/{name}")
    public City getCityByName(@PathVariable("name") String name){
        return cityService.getCityByName(name);
    }

    @PostMapping("/cities")
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") int id){
        cityService.deleteCity(id);
    }

}
