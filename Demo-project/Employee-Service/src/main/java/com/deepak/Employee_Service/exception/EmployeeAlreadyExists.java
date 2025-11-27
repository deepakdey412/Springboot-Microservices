package com.deepak.Employee_Service.exception;

public class EmployeeAlreadyExists extends RuntimeException{
    public EmployeeAlreadyExists(String message){
        super(message);
    }
}
