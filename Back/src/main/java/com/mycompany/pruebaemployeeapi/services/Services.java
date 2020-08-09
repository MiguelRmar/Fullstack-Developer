/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.services;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface Services {
    
    //CRUD
    //CREATE
    public void createElement(Object elemento);
    
    //READ
    public Object Read();

    //UPDATE
    public Object Update();

    //DELETE
    public void Delete();
        
    public ArrayList<Object> allElements();
    public Object getElement( Object obj) throws Exception;
}
