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
import com.unal.exams.model.utils.ExamResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author alej0
 */
public class ExamController {
    
    public Exams insert(String examName, Date expeditionDate, Date realizationDate, Date certificationDate, String description){
        System.out.println("---insert---- "+examName+" "+expeditionDate+" "+realizationDate+" "+description);
        ExamsDAO examsDAO = new ExamsDAO();
        Exams exam = new Exams();
        exam.setName(examName);
        exam.setExpeditionDate(expeditionDate);
        exam.setRealizationDate(realizationDate);
        exam.setCertificationDate(certificationDate);
        exam.setDescription(description);
        Exams temp = examsDAO.insert(exam);
        return temp;
    }
    
    public Exams update(int examId, String examName, Date expeditionDate, Date realizationDate, Date certificationDate, String description){
        System.out.println("---update---- "+examName+" "+expeditionDate+" "+realizationDate+" "+description);
        ExamsDAO examsDAO = new ExamsDAO();
        Exams exam = new Exams();
        exam.setExamId(examId);
        exam.setName(examName);
        exam.setExpeditionDate(expeditionDate);
        exam.setRealizationDate(realizationDate);
        exam.setCertificationDate(certificationDate);
        exam.setDescription(description);
        Exams temp = examsDAO.update(exam);
        return temp;
    }
    
    public boolean deleteExam(Exams exam){
        System.out.println("---delete----"+exam);
        ExamsDAO examsDAO = new ExamsDAO();
        return examsDAO.deleteExam(exam);
    }
    
    public Collection<Exams> findAll(){
        ExamsDAO examsDAO = new ExamsDAO();
        return examsDAO.findAllExams();
    }
    
    public Exams findById( int id ){
        ExamsDAO examsDAO = new ExamsDAO();
        return examsDAO.findById(id);
    }
    
    public Collection<Exams> findExamsUser(String username){
        ExamsDAO examsDAO = new ExamsDAO();
        return examsDAO.findExamsUser(username);
    }
    
    public Collection<ExamResult> getResultsByExam(){
        RelationDAO relationDAO = new RelationDAO();
        ExamsDAO examsDAO = new ExamsDAO();
        Collection<Relation> relations = relationDAO.findAllRelation();
        Collection<Exams> exams = examsDAO.findAllExams();
        ArrayList<ExamResult> examResults = new ArrayList<ExamResult>();
        for(Exams exam: exams){
            examResults.add(new ExamResult(exam, 0, 0));
        }
        for(Relation relation: relations){
            if(relation.getApproved() == 1){
                for(ExamResult examResult: examResults)
                    if(relation.getIdExam() == examResult.getExam().getExamId())
                        examResult.setPassed(examResult.getPassed()+1);
            }else{
                for(ExamResult examResult: examResults)
                    if(relation.getIdExam() == examResult.getExam().getExamId())
                        examResult.setFailed(examResult.getFailed()+1);
            }
        }
        return examResults;
    } 
    
}
