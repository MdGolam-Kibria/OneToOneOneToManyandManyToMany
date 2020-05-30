package com.example.classOneProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponceDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
