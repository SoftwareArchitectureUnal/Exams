package com.unal.exams.DataAccess.DAO;

import com.unal.exams.DataAccess.Entity.Exams;
import com.unal.exams.DataAccess.Entity.Relation;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndresGutierrez
 */
public class RelationDAO {
     public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnitExams");
    
    public Relation insert(Relation relation){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(relation);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            return null;
        }finally{
            em.close();
        }
        return relation;
    }
}
