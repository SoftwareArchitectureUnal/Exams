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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import javafx.util.Pair;


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
       public static Collection<Pair<Exams, Boolean>> ExamsUser(String idUser)
       {
           ExamsDAO myDao = new ExamsDAO();
           RelationDAO myRelationDAO = new RelationDAO();
           Collection<Exams> myCollectionExams = myDao.findAllExams();
           Collection<Relation> myCollectionRelation = myRelationDAO.findRelationByIdUser(idUser);
           TreeSet<Integer> mySet = new TreeSet<Integer>();
           for( Relation myRelation : myCollectionRelation )
           {
               mySet.add(myRelation.getIdExam());
           }
           Iterator iter = myCollectionExams.iterator();
           Exams myExam;
           Collection result = new ArrayList<Pair<Exams, Boolean>>();
           while( iter.hasNext())
           {
               myExam = (Exams)iter.next();
               if ( mySet.contains(myExam.getExamId()))
               {
                   result.add( new Pair(myExam, true));
               }
               else
               {
                   result.add( new Pair(myExam, false));
               }
           }
           return result;
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
       public static void unSubcribeExam(String idUser, int idExam)
       {
           RelationDAO myRelationDAO = new RelationDAO();
           Collection<Relation> collection = myRelationDAO.findRelationByIdUser(idUser);
           for( Relation myRelation : collection)
           {
               if ( myRelation.getIdExam() == idExam)
               {
                    myRelationDAO.deleteByRelationId(myRelation);
                    break;
               }
           }
       }
}
