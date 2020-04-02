package com.pointtechnique.demo.jpa;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long>{

    Company findByCompanyName(String companyName);
}