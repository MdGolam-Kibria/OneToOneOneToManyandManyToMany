package com.example.classOneProject.service;

import com.example.classOneProject.model.Address;
import com.example.classOneProject.model.Employee;
import com.example.classOneProject.repository.AddressRepository;
import com.example.classOneProject.repository.EmployeeRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DbInt {
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;


    public DbInt(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @PostConstruct ///ata dewer mane hosse applicatoin ta run korer sathe sathe ei method ta age run korbe.
    public void init() {
        //for save quick test

        Address address = new Address();
        address.setCity("vola");
        address.setCountry("bangladesh");

        Employee employee = new Employee();
        employee.setName("anika akter akhi");
        employee.setAddress(address);
        //address = addressRepository.save(address);
        employee = employeeRepository.save(employee);
        System.out.println("Employee ID =  " + employee.getId());
        System.out.println("ADDRESS ID =  " + address.getId());

        //for delete quick


//        Employee employee = new Employee();
//        employee = employeeRepository.findById(Long.valueOf(1)).get();
//        employeeRepository.delete(employee);
    }
}
