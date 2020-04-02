package com.pointtechnique.demo.controller;

import java.util.List;

import com.pointtechnique.demo.jpa.Company;
import com.pointtechnique.demo.jpa.CompanyRepository;
import com.pointtechnique.demo.jpa.Employee;
import com.pointtechnique.demo.jpa.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
  @Autowired
  private CompanyRepository companyRepository;

  @PostMapping("/employee")
  Employee insert(@RequestBody Employee newEmployee, String companyName) {

    Company company = companyRepository.findByCompanyName(companyName);
    newEmployee.setCompany(company);
    try {
      return employeeRepository.save(newEmployee);
    } catch (Exception e) {
      throw new CompanyNotFoundException(companyName);
    }
  }

  @PostMapping("/company")
  Company insert(@RequestBody Company newCompany) {

    return companyRepository.save(newCompany);
  }

  @GetMapping("/employees")
  List<Employee> all() {
    return (List<Employee>) employeeRepository.findAll();
  }

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {
    return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @GetMapping("/list/{companyName}")
  List<Employee> allByCompany(@PathVariable String companyName) {
    Company company = companyRepository.findByCompanyName(companyName);
    return employeeRepository.findByCompany(company,Sort.by(Sort.Direction.ASC, "fullName"));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return employeeRepository.findById(id).map(employee -> {
      employee.setFullName(newEmployee.getFullName());
      employee.setHireDate(newEmployee.getHireDate());
      return employeeRepository.save(employee);
    }).orElseGet(() -> {
      newEmployee.setId(id);
      return employeeRepository.save(newEmployee);
    });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {

    employeeRepository.deleteById(id);
  }

}