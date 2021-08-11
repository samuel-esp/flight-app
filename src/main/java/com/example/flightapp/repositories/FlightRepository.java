package com.example.flightapp.repositories;

import com.example.flightapp.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Set<Flight> findFlightByAircraft(String aircraft);

    Set<Flight> findFlightByDepartureCity(String departureCity);

    Set<Flight> findFlightByDestinationCity(String destinationCity);

    Set<Flight> findFlightByAirline(String airline);

    Flight findFlightByFlightNumber(String flightNumber);


}
