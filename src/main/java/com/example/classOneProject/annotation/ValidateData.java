package com.example.classOneProject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//ElementType.Method, which means it will only work on methods.
public @interface ValidateData {
}
