/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.exams.model.utils;

import com.unal.exams.DataAccess.Entity.Exams;

/**
 *
 * @author alej0
 */
public class ExamResult {
    
    private Exams exam;
    private int passed;
    private int failed;
    
    public ExamResult(Exams exam, int passed, int failed){
        this.exam = exam;
        this.passed = passed;
        this.failed = failed;
    }
    
    public Exams getExam() {
        return exam;
    }

    public void setExam(Exams exam) {
        this.exam = exam;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }
    
}
