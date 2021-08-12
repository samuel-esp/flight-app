package com.example.flightapp.services;

import com.example.flightapp.entities.Flight;
import com.example.flightapp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(int id){
        return flightRepository.findById(id).get();
    }

    public Set<Flight> getFlightByAircraft(String aircraft){
        List<Flight> flightSet = flightRepository.findAll();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAircraft().getType().equals(aircraft))
                querySet.add(temp);
        }
        return querySet;
    }

    public Set<Flight> getFlightByAirline(String airline){
        List<Flight> flightSet = flightRepository.findAll();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAirline().getName().equals(airline))
                querySet.add(temp);
        }
        return querySet;
    }

    public Set<Flight> getFlightByDepartureCity(String city){
        List<Flight> flightSet = flightRepository.findAll();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getDepartureCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    public Set<Flight> getFlightByDestinationCity(String city){
        List<Flight> flightSet = flightRepository.findAll();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getDestinationCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    public Set<Flight> getFlightByDepartureCityAndAircraftGreater(String city, int number){
        List<Flight> flightSet = flightRepository.findAll();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAircraft().getMaxPassengers() > number && temp.getDestinationCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    public Set<Flight> getFlightByDestinationCityAndAircraftGreater(String city, int number){
        List<Flight> flightSet = flightRepository.findAll();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAircraft().getMaxPassengers() > number && temp.getDestinationCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    public Flight getCityByName(String number){
        return flightRepository.findFlightByFlightNumber(number);
    }

    public Flight saveFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public void deleteFlight(int id){
        flightRepository.deleteById(id);
    }

}
