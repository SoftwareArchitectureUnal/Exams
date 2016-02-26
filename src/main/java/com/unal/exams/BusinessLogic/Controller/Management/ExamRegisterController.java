/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.BusinessLogic.Controller.Management;
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
       public static void RegisterExam(String idUser, int idExam)
       {
           RelationDAO myRelationDAO = new RelationDAO();
           Relation myRelation = new Relation();
           myRelation.setApproved(0);
           myRelation.setIdExam(idExam);
           myRelation.setIdUser(idUser);
           myRelation.setState("sin calificar");
           myRelationDAO.insert(myRelation);
       }
}
