package com.example.flightapp.services;

import com.example.flightapp.entities.Aircraft;
import com.example.flightapp.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService{

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircraft> getAircrafts(){
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraft(int id){
        return aircraftRepository.findById(id).get();
    }

    public List<Aircraft> getAircraftGreaterThan(int number){
        return aircraftRepository.findAircraftByMaxPassengersGreaterThan(number);
    }

    public List<Aircraft> getAircraftLessThan(int number){
        return aircraftRepository.findAircraftByMaxPassengersLessThan(number);
    }

    public Aircraft getAircraftType(String type){
        return aircraftRepository.findAircraftByType(type);
    }

    public Aircraft saveAircraft(Aircraft aircraft){
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(int id){
        aircraftRepository.deleteById(id);
    }


}
