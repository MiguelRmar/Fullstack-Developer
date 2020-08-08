/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.DAO;

import com.mycompany.pruebaemployeeapi.exceptions.EmployeePersistenceException;
import com.mycompany.pruebaemployeeapi.model.Employee;

/**
 *
 * @author Usuario
 */
public interface EmployeeDAO {
    
    public Employee consultEmployee(int id);
    public Boolean createEmployee(Employee employee)throws EmployeePersistenceException;
    
}
