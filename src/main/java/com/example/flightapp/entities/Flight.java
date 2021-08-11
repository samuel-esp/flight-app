package com.example.flightapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;

@Table(name = "flights")
@Getter @Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Flight.class)
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String flightNumber;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "departurecity_id", referencedColumnName = "city_id")
    private City departureCity;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "destinationcity_id", referencedColumnName = "city_id")
    private City destinationCity;

    @ManyToOne(targetEntity = Aircraft.class)
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @ManyToOne(targetEntity = Airline.class)
    @JoinColumn(name = "airline_id")
    private Airline airline;

}
