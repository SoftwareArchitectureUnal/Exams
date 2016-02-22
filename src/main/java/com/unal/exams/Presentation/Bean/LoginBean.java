/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Bean;

import com.unal.exams.DataAccess.Entity.*;
import com.unal.exams.BusinessLogic.Controller.User.*;
import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean {
    
    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String loginAdmin () {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) 
        context.getExternalContext().getRequest();
       
        
        try {
            System.out.println(username+" "+password);
            request.login(this.username, this.password);
        } catch (ServletException e) {
     
            context.addMessage(null, new FacesMessage("Login failed."));
            return "loginAdm";
        }
        return "/admin/index";
    }

    public void logoutAdmin() throws IOException, ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) 
          context.getExternalContext().getRequest();
       
        HttpServletResponse response = (HttpServletResponse) 
          context.getExternalContext().getResponse();
        try {
            request.logout();
        } catch (ServletException e) {
            
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
        request.getRequestDispatcher("/index.xhtml").forward(request, response);

    }
 
    
    public String login() {
       
        Users userSession = (Users)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(userSession!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userSession);
            return "/user/index";
        }else{
            UserController userController = new UserController();
            Users user = userController.login(username, password);


            if(user!=null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
                return "/user/index";
            }
            return "login";
        }
    }
    public void logout() throws ServletException, IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) 
          context.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) 
          context.getExternalContext().getResponse();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        request.getRequestDispatcher("/index.xhtml").forward(request, response);
       
        
        
    }
    public String verify() {
        Users userSession = (Users)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        
        if(userSession!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userSession);
            
            return "/user/index";
        }
        return "login";
    }
    
}
