/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.Presentation.Bean;

import com.unal.exams.BusinessLogic.Controller.User.ExamController;
import com.unal.exams.DataAccess.Entity.Exams;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alej0
 */
@ManagedBean(name="examBean")
@ViewScoped
public class ExamBean {
    
    private int examId;
    private String examName;
    private String expeditionDate;
    private String realizationDate;
    private String description;
    
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(String expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public String getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(String realizationDate) {
        this.realizationDate = realizationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void onload(int examId) {
        this.examId = examId;
        System.out.println( "examid "+this.examId );
    }
    
    public void saveExam(){
        try{
            DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
            String expDateAsString = expeditionDate;
            Date expDate = sourceFormat.parse(expDateAsString);
            
            String realDateAsString = realizationDate;
            Date realDate = sourceFormat.parse(realDateAsString);
            Exams exam = new ExamController().insert(examId, examName, expDate, realDate, description);
        }catch(Exception e){
            System.out.println( "error al guardar ");
            e.printStackTrace();
        }
    }
    
    public Collection<Exams> loadExam(){
        try{
            return new ExamController().findAll();
        }catch(Exception e){
            System.out.println( "error al cargar ");
            e.printStackTrace();
        }
        return null;
    }
    
    public void deleteExam(Exams exam){
        System.out.println("eliminar " + exam);
        try{
            new ExamController().deleteByExamId(exam);
        }catch(Exception e){
            System.out.println( "error al borrar " + exam);
            e.printStackTrace();
        }
    }
     
}
