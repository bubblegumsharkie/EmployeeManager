package com.studyhardpro.EmployeeManager.repository;

import com.studyhardpro.EmployeeManager.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
