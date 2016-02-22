/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.BusinessLogic.Controller.User;

import com.unal.exams.DataAccess.DAO.ExamsDAO;
import com.unal.exams.DataAccess.Entity.Exams;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author alej0
 */
public class ExamController {
    
    public Exams insert(int examId, String examName, Date expeditionDate, Date realizationDate, String description){
        System.out.println("----------------"+examId+" "+examName+" "+expeditionDate+" "+realizationDate+" "+description);
        ExamsDAO examsDAO = new ExamsDAO();
        Exams exam = new Exams();
        exam.setExamId(examId);
        exam.setName(examName);
        exam.setExpeditionDate(expeditionDate);
        exam.setRealizationDate(realizationDate);
        exam.setDescription(description);
        Exams temp = examsDAO.insert(exam);
        return temp;
    }
    
    public Collection<Exams> findAll(){
        ExamsDAO examsDAO = new ExamsDAO();
        return examsDAO.findAllExams();
    }
    
}
