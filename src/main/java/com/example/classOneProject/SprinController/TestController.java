package com.example.classOneProject.SprinController;

import com.example.classOneProject.model.Address;
import com.example.classOneProject.model.Employee;
import com.example.classOneProject.repository.AddressRepository;
import com.example.classOneProject.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
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

    @PostConstruct ///ata dewer mane hosse applicatoin ta run korer sathe sathe ei method ta age run korbe.
    public void init() {
        Employee employee = new Employee();
        Address address = new Address();
        address.setCountry("bangladesh");
        address.setCity("vola");
        // address = addressRepository.save(address);
        employee.setName("golam kibria");
        employee.setAddress(address);
        employee = employeeRepository.save(employee);
        System.out.println("Employee ID =  " + employee.getId());
        System.out.println("ADDRESS ID =  " + address.getId());
    }
}
