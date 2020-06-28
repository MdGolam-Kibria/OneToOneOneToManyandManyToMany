package com.example.classOneProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class LoginResponceDto {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String token;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String username;
}
