package com.example.flightapp.controllers;

import com.example.flightapp.entities.Airline;
import com.example.flightapp.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlines")
    public List<Airline> getAirlines(){
        return airlineService.getAirlines();
    }

    @GetMapping("/airlines/{id}")
    public Airline getAirline(@PathVariable("id") int id){
        return airlineService.getAirline(id);
    }

    @GetMapping("/airlines/country/{country}")
    public Set<Airline> getAirlineByCountry(@PathVariable("country") String country){
        return airlineService.getAirlineByCountry(country);
    }

    @GetMapping("/airlines/name/{name}")
    public Airline getAirlineByName(@PathVariable("name") String name){
        return airlineService.getAirlineByName(name);
    }

    @PostMapping("/airlines")
    public Airline saveAirline(@RequestBody Airline airline){
        return airlineService.saveAirline(airline);
    }

    @DeleteMapping("/airlines/{id}")
    public void deleteAirline(@PathVariable("id") int id){
        airlineService.deleteAirline(id);
    }

}
