/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hc.model.Marca;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rodol
 */
@Repository
public class MarcaDao {
    
    
        public Integer insert(Marca m){
        Integer id=0;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           //CREATE
           manager.persist(m);
           id=m.getIdMarca();
           
           tx.commit();
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return id;
    }
        
        
        
    public Integer update(Marca m){
        Integer id=0;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
           Marca me = manager.find(Marca.class,m.getIdMarca());
           me.setNombre(m.getNombre());
           me.setDescripcion(m.getDescripcion());        

            
           manager.persist(me);
           id=m.getIdMarca();
           
           tx.commit();
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return id;
    }
    
    
    
     public boolean delete(Integer id_marca){
        boolean b=false;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
             Marca m = manager.find(Marca.class, id_marca);
             manager.remove(m);
    
           tx.commit();
           b=true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
           b=false;
        }

        return b;
    }
     
     
     public Marca read(Integer id_marca){
        Marca m= new Marca();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
             m = manager.find(Marca.class, id_marca);
    
           tx.commit();
         
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return m;
    }
     
     
      public List<Marca> getAll(){
        List<Marca> lista_marcas= new ArrayList<>();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
            lista_marcas= manager.createQuery("select a from Marca a", Marca.class).getResultList();
    
           tx.commit();
         
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return lista_marcas;
    }
}

