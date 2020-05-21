package com.example.classOneProject.employeeService;

import com.example.classOneProject.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save (Employee employee);
    Employee update (Employee employee);
    void delete (Long id);
    Employee get (Long id);
    List<Employee>getALl();
}
