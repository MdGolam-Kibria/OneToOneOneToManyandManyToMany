package com.example.classOneProject.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Product extends BaseModel{
    private String name;
    private Double price;
    private String descripton;
}
