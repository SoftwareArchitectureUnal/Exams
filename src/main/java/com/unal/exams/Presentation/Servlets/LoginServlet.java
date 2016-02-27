/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Servlets;

import com.unal.exams.BusinessLogic.Controller.User.ExamController;
import com.unal.exams.BusinessLogic.Controller.User.UserController;
import com.unal.exams.DataAccess.Entity.Exams;
import com.unal.exams.DataAccess.Entity.Users;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndresGutierrez
 */
public class LoginServlet extends HttpServlet {
    
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ExamController examController = new ExamController();
        String username = req.getParameter("inputUsername");
        Collection<Exams> exmas = examController.findExmasUser(username);
        String password = req.getParameter("inputPassword");
        UserController userController = new UserController();
        Users user = userController.login(username, password);
        if(user!=null){//The login was successful
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("totalNotifications",exmas.size());
            req.getSession().setAttribute("notifications",exmas);
            req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
        }else{
            req.getSession().setAttribute("login", "error");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
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
