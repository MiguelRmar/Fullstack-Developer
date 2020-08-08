/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebaemployeeapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 *
 * @author Usuario
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.mycompany.pruebaemployeeapi" })
@EntityScan("com.mycompany.pruebaemployeeapi")
public class EmployeeApi extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(EmployeeApi.class, args);
    }
    
}
