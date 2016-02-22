package com.unal.exams.DataAccess.DAO;

import com.unal.exams.DataAccess.Entity.Exams;
import java.util.Collection;
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
            return exam;
        }
    }
    
    public Collection<Exams> findAllExams() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query;
        try{
            Exams exams = new Exams();
            
            query = em.createQuery("SELECT e FROM Exams e");
            return (Collection<Exams>) query.getResultList();
        }catch(Exception e){
            em.getTransaction().rollback();
            return null;
        }
      }

}
