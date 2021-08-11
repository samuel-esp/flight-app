package com.example.flightapp.repositories;

import com.example.flightapp.entities.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {

    Aircraft findAircraftByType(String name);

    List<Aircraft> findAircraftByMaxPassengersGreaterThan(int number);

    List<Aircraft> findAircraftByMaxPassengersLessThan(int number);

}
