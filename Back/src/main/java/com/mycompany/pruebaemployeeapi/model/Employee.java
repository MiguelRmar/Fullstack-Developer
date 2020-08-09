/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.model;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Employee {
    
    private String fullname;
    private String function;
    private int identificacion;
    private List<Employee> employees;

    public Employee(){};
            
    
    public Employee(int id , String fullname, String function) {
        this.fullname = fullname;
        this.function = function;
        this.identificacion = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Employee{" + "fullname=" + fullname + ", function=" + function + ", identificacion=" + identificacion + ", employees=" + employees + '}';
    }



    
}
