package com.example.classOneProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    /**
     * above for one to one mapping in this mapping don't need to make any change in this entity.
     */

    //now

    /**
     * one to many and
     * many to many
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * now start for many to many mapping in inshallah next day i will cover the topic
     */
}
