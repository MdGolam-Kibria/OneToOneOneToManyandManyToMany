package com.example.classOneProject.controller;

import com.example.classOneProject.repository.AddressRepository;
import com.example.classOneProject.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/hikibria")
public class TestController {

    private EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    public TestController(EmployeeRepository employeeRepository,AddressRepository addressRepository){
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }
    @GetMapping("/")
    public String hello(){
        return "test";
    }
    @GetMapping("/get")
    @ResponseBody
    public Set<String> hellolIst(){
        Set<String> set = new HashSet<>();
        set.add("golam");
        set.add("kibria");
        set.add("anika");
        set.add("fatema");
        set.add("rosni");
        return set;
    }
    @GetMapping("/plain")
    @ResponseBody
    public String hhh(){
        return "hello";
    }
}
