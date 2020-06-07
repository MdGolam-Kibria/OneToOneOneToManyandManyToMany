package com.example.classOneProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Responce {//amer server e ki ki responce thakte pare seta ekhane rekhechi.
    @JsonInclude(JsonInclude.Include.ALWAYS)//Responce failure or success jai hok na keno si data thakbe json e ;
    private long timestamp;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private int statusCode;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String status;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)//jodi data ti NON_NULL na hoi tahole dekhabe.
    private Object content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int numberOfElement;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long rowCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorResponceDto> errors;
}
