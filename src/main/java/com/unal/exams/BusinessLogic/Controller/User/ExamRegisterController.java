/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.BusinessLogic.Controller.User;
import com.unal.exams.DataAccess.DAO.ExamsDAO;
import com.unal.exams.DataAccess.Entity.Exams;
import java.util.Collection;

/**
 *
 * @author yeisondavid
 */
public class ExamRegisterController {
       public static Collection<Exams> allExams()
       {
           ExamsDAO myDao = new ExamsDAO();
           return myDao.findAllExams();
       }
}
