package com.unal.exams.DataAccess.DAO;

import com.unal.exams.DataAccess.Entity.Exams;
import com.unal.exams.DataAccess.Entity.Relation;
import java.util.List;
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
    public int sizeRelationTable() {
        EntityManager em = emf.createEntityManager();
        Query query;
        try{
            query = em.createNamedQuery("Relation.findSize");
            return (int)(query.getResultList().get(0));
        }catch(Exception e){
            return -1;
        }
    }
    public Collection<Relation>  findRelationByIdUser(String idUser)
    {
        EntityManager em = emf.createEntityManager();
        Query query;
        try
        {
            query = em.createNamedQuery("Relation.findByIdUser").setParameter("idUser", idUser);
            return query.getResultList();
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    
     public boolean deleteByRelationId(Relation relation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            relation = em.merge(relation);
            em.remove(relation);
            em.getTransaction().commit();
            System.out.println("good");
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("bad");
        }finally{
            em.close();
        }
        return true;
    }
    
    public Collection<Relation> findAllRelation(){
        EntityManager em = emf.createEntityManager();
        Query query;
        try{
            query = em.createNamedQuery("Relation.findAll");
            return (Collection<Relation>) query.getResultList();
        }catch(Exception e){
            return null;
        }
    }
}
