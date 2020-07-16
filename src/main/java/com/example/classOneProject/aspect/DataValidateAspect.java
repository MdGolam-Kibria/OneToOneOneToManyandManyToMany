package com.example.classOneProject.aspect;

import com.example.classOneProject.dto.Responce;
import com.example.classOneProject.utill.ResponceBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@Aspect
@Configuration
public class DataValidateAspect {
    Logger logger = LoggerFactory.getLogger(DataValidateAspect.class.getName());
    @Around("@annotation(com.example.classOneProject.annotation.ValidateData) && args(..)")
    public Responce validateData(ProceedingJoinPoint joinPoint) {
        Object[] signatures = joinPoint.getArgs();
        BindingResult result = null;
        for (int i = 0; i < signatures.length; i++) {
            if (signatures[i] instanceof BindingResult)
                result = (BindingResult) signatures[i];
            break;
        }
        if (result.hasErrors()) {
            return ResponceBuilder.getFailureResponce(result, "Bean Binding error");
        }
        try {
            return (Responce) joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
            return ResponceBuilder.getFailureResponce(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
