package com.example.flightapp.controllers;

import com.example.flightapp.entities.Airline;
import com.example.flightapp.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
public class AirlineController {

    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping("/airlines")
    public List<Airline> getAirlines(){
        return airlineRepository.findAll();
    }

    @GetMapping("/airlines/{id}")
    public Airline getAirline(@PathVariable("id") int id){
        return airlineRepository.findById(id).get();
    }

    @GetMapping("/airlines/country/{country}")
    public Set<Airline> getAirlineByCountry(@PathVariable("country") String country){
        return airlineRepository.findAirlineByCountry(country);
    }

    @GetMapping("/airlines/name/{name}")
    public Airline getAirlineByName(@PathVariable("name") String name){
        return airlineRepository.findAirlineByName(name);
    }

    @PostMapping("/airlines")
    public Airline saveAirline(@RequestBody Airline airline){
        return airlineRepository.save(airline);
    }

    @DeleteMapping("/airlines/{id}")
    public void deleteAirline(@PathVariable("id") int id){
        airlineRepository.deleteById(id);
    }

}
