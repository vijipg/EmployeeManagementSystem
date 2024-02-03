package com.viji.employeeManagement.service;

import com.viji.employeeManagement.model.Employee;
import com.viji.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee =  employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new RuntimeException(" Employee not found for id : " + id);
        }
    }
}
