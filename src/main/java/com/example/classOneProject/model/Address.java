package com.example.classOneProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;

    /**
     * many to many mapping
     */
    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)//ekhane mappedBy kamne kaj kortice,ata sara o kaj kore
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();
}
