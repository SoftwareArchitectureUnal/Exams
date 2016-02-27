/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Servlets;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndresGutierrez
 */
public class LoginAdminServlet extends HttpServlet {
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        try {
            //System.out.println(username+" "+password);
            req.login(username, password);
        } catch (ServletException e) {
            req.getRequestDispatcher("/loginError.jsp").forward(req, resp);
            return;
        }
        req.getSession().setAttribute("admin", "admin");
        req.getRequestDispatcher("admin/index.xhtml").forward(req, resp);
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
