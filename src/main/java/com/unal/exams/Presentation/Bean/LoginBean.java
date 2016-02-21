/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Bean;

import com.unal.exams.DataAccess.Entity.*;
import com.unal.exams.BusinessLogic.Controller.User.*;
import javax.annotation.Resource;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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
    
    public String login(){
        
        Users userSession = (Users)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(userSession!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userSession);
            if(userSession.getRole().equals("admin")){
                return "/admin/index";
            }
            return "/user/index";
        }else{
            UserController userController = new UserController();
            Users user = userController.login(username, password);


            if(user!=null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
                if(user.getRole().equals("admin")){
                    return "/admin/index";
                }
                return "/user/index";
            }
            return "";
        }
    }
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        return "/index";
    }
    public String verify(){
        Users userSession = (Users)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(userSession!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userSession);
            if(userSession.getRole().equals("admin")){
                return "/admin/index";
            }
            return "/user/index";
        }
        return "";
    }
    
}
