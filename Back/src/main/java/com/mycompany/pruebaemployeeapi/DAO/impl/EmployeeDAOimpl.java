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

/**
 *
 * @author Usuario
 */
public class EmployeeDAOimpl implements EmployeeDAO{
    
    private EmployeeDB edb = new EmployeeDB();
    
    @Override
    public Employee consultEmployee(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Employee> consultEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean createEmployee(Employee employee) throws EmployeePersistenceException{
        return edb.insertEmployee(employee);
    }
}
