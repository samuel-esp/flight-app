package com.example.flightapp.controllers;

import com.example.flightapp.entities.Flight;
import com.example.flightapp.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flight> getFlights(){
        return flightService.getFlights();
    }

    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable("id") int id){
        return flightService.getFlightById(id);
    }

    @GetMapping("/flights/aircraft/{aircraft}")
    public Set<Flight> getFlightByAircraft(@PathVariable("aircraft") String aircraft){
        List<Flight> flightSet = flightService.getFlights();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAircraft().getType().equals(aircraft))
                querySet.add(temp);
        }
        return querySet;
    }

    @GetMapping("/flights/airline/{airline}")
    public Set<Flight> getFlightByAirline(@PathVariable("airline") String airline){
        List<Flight> flightSet = flightService.getFlights();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAirline().getName().equals(airline))
                querySet.add(temp);
        }
        return querySet;
    }

    @GetMapping("/flights/departure_city/{city}")
    public Set<Flight> getFlightByDepartureCity(@PathVariable("city") String city){
        List<Flight> flightSet = flightService.getFlights();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getDepartureCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    @GetMapping("/flights/destination_city/{city}")
    public Set<Flight> getFlightByDestinationCity(@PathVariable("city") String city){
        List<Flight> flightSet = flightService.getFlights();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getDestinationCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    @GetMapping("/flights/departure_city/{city}/aircraft_greater_than/{number}")
    public Set<Flight> getFlightByDepartureCityAndAircraftGreater(@PathVariable("city") String city, @PathVariable("number") int number){
        List<Flight> flightSet = flightService.getFlights();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAircraft().getMaxPassengers() > number && temp.getDestinationCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    @GetMapping("/flights/destination_city/{city}/aircraft_greater_than/{number}")
    public Set<Flight> getFlightByDestinationCityAndAircraftGreater(@PathVariable("city") String city, @PathVariable("number") int number){
        List<Flight> flightSet = flightService.getFlights();
        Set<Flight> querySet = new HashSet<>();
        for (Flight temp : flightSet) {
            if(temp.getAircraft().getMaxPassengers() > number && temp.getDestinationCity().getName().equals(city))
                querySet.add(temp);
        }
        return querySet;
    }

    @GetMapping("/flights/flightnumber/{number}")
    public Flight getCityByName(@PathVariable("number") String number){
        return flightService.getCityByName(number);
    }

    @PostMapping("/flights")
    public Flight saveFlight(@RequestBody Flight flight){
        return flightService.saveFlight(flight);
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlight(@PathVariable("id") int id){
        flightService.deleteFlight(id);
    }


}
