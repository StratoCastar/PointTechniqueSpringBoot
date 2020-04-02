package com.pointtechnique.demo.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "EMPLOYEE")
public class Employee {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "Full_Name", length=128, nullable = false)
    private String fullName;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="company_id",nullable=true)
    private Company company;

    @Temporal(TemporalType.DATE)
    @Column(name = "Hire_Date" , nullable = false)
    private Date hireDate;

   

    
}