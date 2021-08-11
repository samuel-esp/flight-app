package com.example.flightapp.controllers;

import com.example.flightapp.entities.Aircraft;
import com.example.flightapp.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping("/aircrafts")
    public List<Aircraft> getAircrafts(){
        return aircraftRepository.findAll();
    }

    @GetMapping("/aircrafts/{id}")
    public Aircraft getAircraft(@PathVariable("id") int id){
        return aircraftRepository.findById(id).get();
    }

    @GetMapping("/aircrafts/passengers_greater_than/{number}")
    public List<Aircraft> getAircraftGreaterThan(@PathVariable("number") int number){
        return aircraftRepository.findAircraftByMaxPassengersGreaterThan(number);
    }

    @GetMapping("/aircrafts/passengers_less_than/{number}")
    public List<Aircraft> getAircraftLessThan(@PathVariable("number") int number){
        return aircraftRepository.findAircraftByMaxPassengersLessThan(number);
    }

    @GetMapping("/aircrafts/type/{type}")
    public Aircraft getAircraftType(@PathVariable("type") String type){
        return aircraftRepository.findAircraftByType(type);
    }

    @PostMapping("/aircrafts")
    public Aircraft saveAircraft(@RequestBody Aircraft aircraft){
        return aircraftRepository.save(aircraft);
    }

    @DeleteMapping("/aircrafts/{id}")
    public void deleteAircraft(@PathVariable("id") int id){
        aircraftRepository.deleteById(id);
    }

}
