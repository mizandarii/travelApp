
package com.example.hovno.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 50)
    private String address;
    @Column(length = 250)
    private String description;
    @Column(length = 250)
    private String website;


    @ManyToMany(mappedBy = "places")
    private List<Tour> tours;

}