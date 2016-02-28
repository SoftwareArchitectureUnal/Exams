package com.unal.exams.DataAccess.DAO;

import com.unal.exams.DataAccess.Entity.Exams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author AndresGutierrez
 */
public class ExamsDAO {
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnitExams");
    
    public Exams insert(Exams exam){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(exam);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            return null;
        }finally{
            em.close();
        }
        return exam;
    }
    
    public Exams update(Exams exam){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Exams exUpdate = em.find(Exams.class, exam.getExamId());
            exUpdate.setName(exam.getName());
            exUpdate.setExpeditionDate(exam.getExpeditionDate());
            exUpdate.setRealizationDate(exam.getRealizationDate());
            exUpdate.setDescription(exam.getDescription());
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            return null;
        }finally{
            em.close();
        }
        return exam;
    }
    
    public Collection<Exams> findAllExams() {
        EntityManager em = emf.createEntityManager();
        Query query;
        try{
            query = em.createNamedQuery("Exams.findAll");
            return (Collection<Exams>) query.getResultList();
        }catch(Exception e){
            return null;
        }
    }
    public Collection<Exams> findExamsUser(String username){
        EntityManager em = emf.createEntityManager();
        Query query;
        try{
                query = em.createNativeQuery("SELECT * FROM Relation AS r INNER JOIN Exams AS e ON r.idExam=e.examId WHERE (r.idUser=? && (e.realizationDate>=DATE_SUB(CURDATE(),INTERVAL 2 DAY) && e.realizationDate<=CURDATE()));",Exams.class);
            query.setParameter(1,username);
            return query.getResultList();
        }catch(Exception e){
            System.out.println(e.toString());
            return new ArrayList<Exams>();
        }
    }
    
    public boolean deleteByExamId(Exams exam) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            exam = em.merge(exam);
            em.remove(exam);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return true;
    }
    
    public Exams getExam( int idExam)
    {
         EntityManager em = emf.createEntityManager();
        Query query;
        try{
            query = em.createNamedQuery("Exams.findAll");
            return (Exams)query.getResultList().get(0);
        }catch(Exception e){
            return null;
        }
        
    }

}
