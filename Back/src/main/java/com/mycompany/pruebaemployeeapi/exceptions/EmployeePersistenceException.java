/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.exceptions;

/**
 *
 * @author Usuario
 */
public class EmployeePersistenceException extends Exception{
    
    private static final long serialVersionUID = 1L;

    public EmployeePersistenceException(String message) {
        super(message);
    }

    public EmployeePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
