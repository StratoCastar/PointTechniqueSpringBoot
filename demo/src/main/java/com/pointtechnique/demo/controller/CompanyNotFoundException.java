package com.pointtechnique.demo.controller;

public class CompanyNotFoundException extends RuntimeException{

    
    /**
     *
     */
    private static final long serialVersionUID = -574695426190203021L;

    CompanyNotFoundException(String companyName) {
        super("Could not find Company : " + companyName);
    }

}
