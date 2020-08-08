/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.impl;


import com.mycompany.pruebaemployeeapi.DAO.impl.EmployeeDAOimpl;
import com.mycompany.pruebaemployeeapi.exceptions.EmployeePersistenceException;
import com.mycompany.pruebaemployeeapi.model.Employee;
import com.mycompany.pruebaemployeeapi.services.Services;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
/**
 *
 * @author Usuario
 */
@Service
public class EmployeeServices implements Services{
    
    EmployeeDAOimpl edi = new EmployeeDAOimpl();

    public boolean addUser(Employee emp) throws EmployeePersistenceException {
        return edi.createEmployee(emp);
    }
    
    public Employee getEmployee (int idEmp) throws EmployeePersistenceException{
        Employee emp = edi.consultEmployee(idEmp);
        return emp;
    }
    
    @Override
    public void createElement(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> allElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getElement(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
