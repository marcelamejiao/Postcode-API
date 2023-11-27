package io.nology.postcodeAPI.suburb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "suburbs")
public class Suburb {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String postcode;

    // default empty constructor for requirement of Spring
    public Suburb() {}

    //constructor
    public Suburb(String name, String postcode) {
        this.name = name;
        this.postcode = postcode;
    }
}
