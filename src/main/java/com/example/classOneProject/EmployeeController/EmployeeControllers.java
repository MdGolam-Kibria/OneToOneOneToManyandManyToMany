package com.example.classOneProject.EmployeeController;

import com.example.classOneProject.annotation.ApiController;
import com.example.classOneProject.employeeService.EmployeeService;
import com.example.classOneProject.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiController//this is my own create annotation for solve (CORS) problem and @RestController together
@RequestMapping("/employee")
public class EmployeeControllers {

    private final EmployeeService employeeService;

    public EmployeeControllers(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable(name = "id") Long id) {
        return employeeService.get(id);
    }

    @GetMapping("/getALl")
    public List<Employee> getALL() {
        return employeeService.getALl();
    }

}
