/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.persistence;

import com.mycompany.pruebaemployeeapi.exceptions.EmployeePersistenceException;
import com.mycompany.pruebaemployeeapi.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class EmployeeDB {
    private String urlDatabase = "jdbc:postgresql://ec2-54-165-36-134.compute-1.amazonaws.com:5432/d3ckljhjikb54l";
    private String usuarioDb = "khmwcxngcevhfl";
    private String passwordDb = "00d145a9ac598e7f244c56b463bbe44d5a4bdc9820f5de415a04bd65745dfa02";
    static Connection c = null;
    
    public void realizaConexion() throws EmployeePersistenceException {

        try {
            c = DriverManager.getConnection(urlDatabase, usuarioDb, passwordDb);
            // System.out.println("La conexion se realizo sin problemas!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertEmployee(Employee employee) throws EmployeePersistenceException{
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        Employee em = employee;
        String SQLcount = "SELECT count(distinct id) FROM public.\"meal\"";
        boolean res = false;
        
        try{
            if(c == null || c.isClosed()){
                realizaConexion();
            }
            pstmt2 = c.prepareStatement(SQLcount, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet mnid = pstmt2.executeQuery();
            mnid.next();
            int idmn = mnid.getInt("count") + 1;
            String SQL = "INSERT INTO public.\"Employee\" (\"IdEmployee\",fullname,boss,function)"
                    + "VALUES ('" + employee.getIdentificacion() + "','" + employee.getFullname()+ "','" + employee.getBoss()+ "','" + employee.getPosition()+ "');";
            
            pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = pstmt.execute();   
            res= true;
            pstmt.close();
            
        }catch(SQLException ex){
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return res;    
    }
    
    public Employee consultEmployee(int id)throws EmployeePersistenceException{
        String SQL = "SELECT * FROM public.\"Employee\" WHERE \"IdEmployee\" = ? ";
        Employee em = new Employee();
        try {
            if (c == null || c.isClosed()) {
                realizaConexion();
            }
            PreparedStatement pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if (rs.absolute(1)) {
                em = new Employee(rs.getInt("IdEmployee"),rs.getString("fullname"),rs.getString("function"),rs.getInt("boss"));
                /* c.close(); */
                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return em;
    }
    
    public List<Employee> consultEmployees()throws EmployeePersistenceException{
        String SQL = "SELECT * FROM public.\"Employee\" ";
        List<Employee> lemp = null;
        int idEmployeeCreate;
        
        try {
            if (c == null || c.isClosed()) {
                realizaConexion();
            }
            PreparedStatement pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery();
            int idEmployee;
            rs.next();
            if (rs.absolute(1)) {
                lemp = new ArrayList<Employee>();
                idEmployee = rs.getInt("IdEmployee");
                lemp.add(consultEmployee(idEmployee));
                idEmployeeCreate = idEmployee;
                while (rs.next()) {
                    idEmployee = rs.getInt("IdEmployee");
                    if (idEmployee != idEmployeeCreate) {
                        lemp.add(consultEmployee(idEmployee));
                        idEmployeeCreate = idEmployee;
                    }
                }
                /* c.close(); */
                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lemp;
    }
}
