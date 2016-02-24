/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.BusinessLogic.Controller.User;
import com.unal.exams.DataAccess.DAO.ExamsDAO;
import com.unal.exams.DataAccess.DAO.RelationDAO;
import com.unal.exams.DataAccess.Entity.Exams;
import com.unal.exams.DataAccess.Entity.Relation;
import com.unal.exams.DataAccess.Entity.Users;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author yeisondavid
 */
public class ExamRegisterController {
       public static int count = 0;
       public static Collection<Exams> allExams()
       {
           ExamsDAO myDao = new ExamsDAO();
           return myDao.findAllExams();
       }
       public static void RegisterExam(Users iduser, String idExam)
       {
           //TODO estoy toca hacerlo bien, toca crear las tablas de nuevo.
           Random rr = new Random();
           Relation r = new Relation( new Integer(rr.nextInt()), 0, "sin presentar");
           r.setIdUser(iduser);
            // r.setIdUser(idUser);
           RelationDAO myDAO = new RelationDAO();
           myDAO.insert(r);
       }
}
