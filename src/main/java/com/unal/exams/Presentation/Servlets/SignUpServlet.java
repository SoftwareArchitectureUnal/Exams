/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Servlets;

import com.unal.exams.DataAccess.DAO.UsersDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unal.exams.DataAccess.DAO.UsersDAO;
import com.unal.exams.DataAccess.Entity.Users;

/**
 *
 * @author AndresGutierrez
 */

public class SignUpServlet extends HttpServlet{
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String username = (String) req.getParameter("inputUsername");
        String name = (String) req.getParameter("inputName");
        String password = (String) req.getParameter("inputPassword");
        String email = (String) req.getParameter("inputEmail");
        int gender =  Integer.parseInt((String)req.getParameter("gender"));
        UsersDAO usersDAO = new UsersDAO();
        Users user = new Users();
        user.setEmail(email);
        user.setUserId(username);
        user.setGender(gender);
        user.setPassword(password);
        user.setRole("user");
        user.setName(name);
        System.out.println(user.getUserId()+ " "+gender);
        
        if(usersDAO.persist(user)!=null){// The register was successful
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
        }else{
            req.setAttribute("signUp", "error");
            req.getRequestDispatcher("signUp.jsp").forward(req, resp);
        }
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
