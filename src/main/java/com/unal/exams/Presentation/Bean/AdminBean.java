/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndresGutierrez
 */
@ManagedBean(name="adminBean")
@ViewScoped
public class AdminBean {
    
    public void redirect() throws ServletException, IOException{
        FacesContext context = FacesContext.getCurrentInstance();
         
        HttpServletResponse response = (HttpServletResponse) 
          context.getExternalContext().getResponse();
        response.sendRedirect("http://localhost:8080/Exams/admin/adminExams.jsp");

    }
    
}
