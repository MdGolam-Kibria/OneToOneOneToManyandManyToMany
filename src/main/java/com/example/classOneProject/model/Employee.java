package com.example.classOneProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /**
     * for one to one mapping
     */
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;

    /**
     * for one to many mapping
     */
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
//    private List<Address> address;


    /**
     * many to many mapping
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employee_address",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "address_id") }
    )
   private List<Address> addresses = new ArrayList<>();
}
