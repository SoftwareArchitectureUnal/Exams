/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Bean;

import com.unal.exams.BusinessLogic.Controller.User.UserController;
import com.unal.exams.DataAccess.Entity.Users;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author AndresGutierrez
 */
@ManagedBean(name="registerBean")
@ViewScoped
public class RegisterBean {
    private String username;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String register(){
        int genderNumber = this.gender.equals("M")?1:0;
        role = "user";
        Users user = new UserController().register(username, name, email, 
                password,genderNumber , role);
        return "index";
    }
}
