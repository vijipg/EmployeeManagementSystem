package com.viji.employeeManagement.service;

import com.viji.employeeManagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee getEmployeeById(int id);
}
