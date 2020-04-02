package com.pointtechnique.demo.jpa;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String companyLocation;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, 
    cascade = CascadeType.ALL)
    @Transient
    private Set<Employee> employeeList;
}