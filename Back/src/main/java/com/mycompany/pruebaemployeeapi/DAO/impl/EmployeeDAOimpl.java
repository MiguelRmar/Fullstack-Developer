/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.DAO.impl;

import com.mycompany.pruebaemployeeapi.DAO.EmployeeDAO;
import com.mycompany.pruebaemployeeapi.exceptions.EmployeePersistenceException;
import com.mycompany.pruebaemployeeapi.model.Employee;
import com.mycompany.pruebaemployeeapi.persistence.EmployeeDB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class EmployeeDAOimpl implements EmployeeDAO{
    
    private EmployeeDB edb = new EmployeeDB();
    
    @Override
    public Employee consultEmployee(int id) {
        try {
            return edb.consultEmployee(id);
        } catch (EmployeePersistenceException ex) {
            Logger.getLogger(EmployeeDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    
    @Override
    public List<Employee> consultEmployees() {
        try {
            return edb.consultEmployees();
        } catch (EmployeePersistenceException ex) {
            Logger.getLogger(EmployeeDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean createEmployee(Employee employee) throws EmployeePersistenceException{
        return edb.insertEmployee(employee);
    }
}
