package com.example.flightapp.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = City.class)
@Table(name = "cities")
@Getter @Setter
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "destinationCity", cascade = CascadeType.ALL)
    private Set<Flight> destinationFlightSet;

    @OneToMany(mappedBy = "departureCity", cascade = CascadeType.ALL)
    private Set<Flight> departureFlightSet;

}
