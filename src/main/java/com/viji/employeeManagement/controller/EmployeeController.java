package com.viji.employeeManagement.controller;

import com.viji.employeeManagement.model.Employee;
import com.viji.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String homePage(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employeeList",employees);
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_employee";

    }

    @PostMapping(value={"/addEmployee","/updateEmployee"})
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable  int id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
