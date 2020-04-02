package com.pointtechnique.demo.controller;


class EmployeeNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3577188132752178931L;

    EmployeeNotFoundException(Long id) {
        super("Could not find employee" + id);
    }
}