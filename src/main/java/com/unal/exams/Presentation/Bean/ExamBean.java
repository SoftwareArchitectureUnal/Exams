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
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;

/**
 *
 * @author alej0
 */
@ManagedBean(name="examBean")
@ViewScoped
public class ExamBean {
    
    private HtmlInputText inputExpDate = new HtmlInputText();
    private HtmlInputText inputRealDate = new HtmlInputText();
    private HtmlInputText inputExamName = new HtmlInputText();
    private HtmlInputText inputExamId = new HtmlInputText();
    private HtmlInputText inputDescription = new HtmlInputText();
    
    private int examId;
    private String examName;
    private String expeditionDate;
    private String realizationDate;
    private String description;
    
    private Exams exam;
    
    public ExamBean(){
    }
    
    public HtmlInputText getInputExamName() {
        return inputExamName;
    }

    public void setInputExamName(HtmlInputText inputExamName) {
        this.inputExamName = inputExamName;
    }

    public HtmlInputText getInputExamId() {
        return inputExamId;
    }

    public void setInputExamId(HtmlInputText inputExamId) {
        this.inputExamId = inputExamId;
    }

    public HtmlInputText getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(HtmlInputText inputDescription) {
        this.inputDescription = inputDescription;
    }
    
    public HtmlInputText getInputRealDate() {
        return inputRealDate;
    }

    public void setInputRealDate(HtmlInputText inputRealDate) {
        this.inputRealDate = inputRealDate;
    }
    
    public HtmlInputText getInputExpDate() {
        return inputExpDate;
    }

    public void setInputExpDate(HtmlInputText inputExpDate) {
        this.inputExpDate = inputExpDate;
    }

    public Exams getExam() {
        return exam;
    }

    public void setExam(Exams Exam) {
        this.exam = Exam;
    }
    
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
        if(expeditionDate != null)
            System.out.println("fechaaaaaa " + Arrays.toString(expeditionDate.split(" ")));
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
    
    public void onLoad(Exams exam) {
        this.exam = exam;
        inputExpDate.setValue( dateToString(exam.getExpeditionDate()) );
        inputRealDate.setValue( dateToString(exam.getRealizationDate()) );
        inputExamId.setValue( exam.getExamId() );
        inputExamName.setValue( exam.getName() );
        inputDescription.setValue( exam.getDescription() );
    }
    
    public String dateToString(Date date){
        String dateString = date.getDate() + "/";
        int month = date.getMonth() + 1;
        if( month < 10)
            dateString += "0" + month;
        else
            dateString += "" + month;
        return dateString + "/" + (date.getYear() + 1900);
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
    
    public static Collection<Exams> loadExams(){
        try{
            return new ExamController().findAll();
        }catch(Exception e){
            System.out.println( "error al cargar ");
            e.printStackTrace();
        }
        return null;
    }
    
    public static Exams loadExamById(int id){
        try{
            return new ExamController().findByExamId(id);
        }catch(Exception e){
            System.out.println( "error al cargar ");
            e.printStackTrace();
        }
        return null;
    }
    
    public void deleteExam(Exams exam){
        try{
            new ExamController().deleteByExamId(exam);
        }catch(Exception e){
            System.out.println( "error al borrar " + exam);
            e.printStackTrace();
        }
    }
    
    public void updateExam(){
        try{
            DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
            String expDateAsString = expeditionDate;
            Date expDate = sourceFormat.parse(expDateAsString);
            
            String realDateAsString = realizationDate;
            Date realDate = sourceFormat.parse(realDateAsString);
            Exams exam = new ExamController().update(examId, examName, expDate, realDate, description);
        }catch(Exception e){
            System.out.println( "error al actualizar ");
            e.printStackTrace();
        }
    }
     
}
