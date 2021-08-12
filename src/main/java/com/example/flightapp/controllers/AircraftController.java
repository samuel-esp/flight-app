package com.example.flightapp.controllers;

import com.example.flightapp.entities.Aircraft;
import com.example.flightapp.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircrafts")
    public List<Aircraft> getAircrafts(){
        return aircraftService.getAircrafts();
    }

    @GetMapping("/aircrafts/{id}")
    public Aircraft getAircraft(@PathVariable("id") int id){
        return aircraftService.getAircraft(id);
    }

    @GetMapping("/aircrafts/passengers_greater_than/{number}")
    public List<Aircraft> getAircraftGreaterThan(@PathVariable("number") int number){
        return aircraftService.getAircraftGreaterThan(number);
    }

    @GetMapping("/aircrafts/passengers_less_than/{number}")
    public List<Aircraft> getAircraftLessThan(@PathVariable("number") int number){
        return aircraftService.getAircraftLessThan(number);
    }

    @GetMapping("/aircrafts/type/{type}")
    public Aircraft getAircraftType(@PathVariable("type") String type){
        return aircraftService.getAircraftType(type);
    }

    @PostMapping("/aircrafts")
    public Aircraft saveAircraft(@RequestBody Aircraft aircraft){
        return aircraftService.saveAircraft(aircraft);
    }

    @DeleteMapping("/aircrafts/{id}")
    public void deleteAircraft(@PathVariable("id") int id){
        aircraftService.deleteAircraft(id);
    }

}
