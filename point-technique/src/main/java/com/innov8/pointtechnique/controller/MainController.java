package com.innov8.pointtechnique.controller;

import java.util.List;

import com.innov8.pointtechnique.jpa.Employee;
import com.innov8.pointtechnique.jpa.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
class MainController {
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    @PostMapping("/employees")
    Employee insert(@RequestBody Employee newEmployee) {

        return employeeRepository.save(newEmployee);
    }
 
    @GetMapping("/employees")
    List<Employee> all() {
 
        return (List<Employee>) employeeRepository.findAll();
    }
 
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
  
      return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
  
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
  
      return employeeRepository.findById(id)
        .map(employee -> {
          employee.setFullName(newEmployee.getFullName());
          employee.setHireDate(newEmployee.getHireDate());
          return employeeRepository.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return employeeRepository.save(newEmployee);
        });
    }
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
      }
 
}