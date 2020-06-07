package com.example.classOneProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotNull(message = "price is mandatory")
    private Double price;
    @JsonIgnore//jodi ami chai je ei "description" field ta dekhabo na json response etahole ei annotation ta dibo.
    private String description;
}
