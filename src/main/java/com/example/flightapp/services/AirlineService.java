package com.example.flightapp.services;

import com.example.flightapp.entities.Airline;
import com.example.flightapp.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AirlineService{

    @Autowired
    private AirlineRepository airlineRepository;

    public List<Airline> getAirlines(){
        return airlineRepository.findAll();
    }

    public Airline getAirline(int id){
        return airlineRepository.findById(id).get();
    }

    public Set<Airline> getAirlineByCountry(String country){
        return airlineRepository.findAirlineByCountry(country);
    }
    public Airline getAirlineByName(String name){
        return airlineRepository.findAirlineByName(name);
    }

    public Airline saveAirline(Airline airline){
        return airlineRepository.save(airline);
    }

    public void deleteAirline(int id){
        airlineRepository.deleteById(id);
    }


}
