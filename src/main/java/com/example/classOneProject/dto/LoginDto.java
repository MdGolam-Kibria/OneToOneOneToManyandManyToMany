package com.example.classOneProject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class LoginDto {
    @NotBlank(message = "User Name Mandatory")
    private String username;
    @NotBlank(message = "Password Mandatory")
    private String password;
}
