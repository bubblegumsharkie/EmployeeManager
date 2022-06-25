package com.studyhardpro.EmployeeManager.services;

import com.studyhardpro.EmployeeManager.exceptions.UserNotFoundException;
import com.studyhardpro.EmployeeManager.models.Employee;
import com.studyhardpro.EmployeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setImageUrl("https://avatars.dicebear.com/api/human/" + employee.getEmail() + ".svg");
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("The user with the id: " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
