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
    private String position;
    private int identificacion;
    private int boss;

    public Employee(){};
            
    
    public Employee(int id , String fullname, String function,int Boss) {
        this.fullname = fullname;
        this.position = function;
        this.identificacion = id;
        this.boss=Boss;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBoss() {
        return boss;
    }

    public void setBoss(int boss) {
        this.boss = boss;
    }


    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Employee{" + "fullname=" + fullname + ", position=" + position + ", identificacion=" + identificacion + ", boss=" + boss + '}';
    }





    
}
