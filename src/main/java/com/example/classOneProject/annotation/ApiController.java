package com.example.classOneProject.annotation;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@RestController//ata je ekta rest controller seta ekhane bollam
//@CrossOrigin({"GET", "POST", "PUT", "DELETE"})//this is for Cross Origin Resource Sharing (CORS) problem solve this is one way
// another way given below
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.OPTIONS})
@ResponseBody
public @interface ApiController {
    @org.springframework.core.annotation.AliasFor(annotation = org.springframework.stereotype.Controller.class)
    java.lang.String value() default "";
}
