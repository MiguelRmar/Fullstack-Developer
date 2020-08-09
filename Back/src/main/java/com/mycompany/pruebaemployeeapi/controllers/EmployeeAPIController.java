/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.controllers;


import com.mycompany.pruebaemployeeapi.exceptions.EmployeePersistenceException;
import com.mycompany.pruebaemployeeapi.model.Employee;
import com.mycompany.pruebaemployeeapi.services.impl.EmployeeServices;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author Usuario
 */
@RequestMapping("/session")
@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST})
public class EmployeeAPIController {
    
    @Autowired
    EmployeeServices esi = new EmployeeServices();
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> verifyLogin(@PathVariable("id") int id)
            throws InterruptedException, EmployeePersistenceException {
        Employee emp = esi.getEmployee(id);
        return new ResponseEntity<>(emp, HttpStatus.ACCEPTED);
    }
    

    @RequestMapping(method = RequestMethod.GET, path = "/employees")
    public ResponseEntity<?> verifyLogin()
            throws InterruptedException, EmployeePersistenceException {
        List<Employee> emp = esi.getEmployees();
        return new ResponseEntity<>(emp, HttpStatus.ACCEPTED);
    }
    

    @RequestMapping(method = RequestMethod.POST , path = "/createEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee emp){
        try {
            Boolean b = esi.addUser(emp);
            return new ResponseEntity<>(b, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 406", HttpStatus.NOT_ACCEPTABLE);
        }
    }
     
}
