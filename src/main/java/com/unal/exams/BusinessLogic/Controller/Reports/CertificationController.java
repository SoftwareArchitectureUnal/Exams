/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.BusinessLogic.Controller.Reports;

import com.unal.exams.DataAccess.DAO.ExamsDAO;
import com.unal.exams.DataAccess.DAO.RelationDAO;
import com.unal.exams.DataAccess.Entity.Exams;
import com.unal.exams.DataAccess.Entity.Relation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author yeisondavid
 */
public class CertificationController {
    // return the passed exam of a user with idUser
    public static Collection<Exams> getPasExamsofUser(String idUser)
    {
        RelationDAO myRelationDAO = new RelationDAO();
        Collection<Relation> query = myRelationDAO.findRelationByIdUser(idUser);
        Iterator iter = query.iterator();
        Relation auxRelation;
        int idExam;
        ExamsDAO myExamsDAO = new ExamsDAO();
        Collection<Exams> result = new ArrayList<Exams>();
        while( iter.hasNext())
        {
            auxRelation = (Relation)iter.next();
            idExam = auxRelation.getIdExam();
            result.add(myExamsDAO.getExam(idExam));
        }
        return result;
    }
}
