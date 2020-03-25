package com.innov8.pointtechnique.controller;

class EmployeeNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8319352161197084865L;

    EmployeeNotFoundException(Long id) {
      super("Could not find employee " + id);
    }
  }