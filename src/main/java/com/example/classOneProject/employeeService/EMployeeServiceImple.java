package com.example.classOneProject.employeeService;

import com.example.classOneProject.model.Employee;
import com.example.classOneProject.repository.EmployeeRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EMployeeServiceImple implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EMployeeServiceImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee == null) {
            return;
        } else {
            employeeRepository.delete(employee);
        }
    }

    @Override
    public Employee get(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee == null) {
            return null;
        }
        return employee;
    }

    @Override
    public List<Employee> getALl() {
        return employeeRepository.findAll();
    }
}
