package com.example.flightapp.repositories;

import com.example.flightapp.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    Airline findAirlineByName(String name);

    Set<Airline> findAirlineByCountry(String name);

}
