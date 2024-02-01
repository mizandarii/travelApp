package com.example.hovno.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false)
    private Date start;

    @Column(nullable = false)
    private Date end;

    @Column(nullable = false)
    private double price;


    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @OneToMany(mappedBy = "tour")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "tour_place",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Place> places;

    /**
    @ManyToMany
    @JoinTable(
            name = "tour_transport",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "transport_id")
    )
    private List<Transport> transports;

     **/

    @ManyToMany
    @JoinTable(
        name = "user_tour",
        joinColumns = @JoinColumn(name = "tour_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;



}
