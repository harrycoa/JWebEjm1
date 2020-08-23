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
import org.hc.model.Usuario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rodol
 */
@Repository
public class UsuarioDao {
    
    
        public Integer insert(Usuario m){
        Integer id=0;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           //CREATE
           manager.persist(m);
           id=m.getIdUsuario();
           
           tx.commit();
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return id;
    }
        
        
        
    public Integer update(Usuario m){
        Integer id=0;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
           Usuario me = manager.find(Usuario.class,m.getIdUsuario());
           me.setLogin(m.getLogin());
           me.setClave(m.getClave());        

            
           manager.persist(me);
           id=m.getIdUsuario();
           
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
           
             Usuario m = manager.find(Usuario.class, id_marca);
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
     
     
     public Usuario read(Integer id_marca){
        Usuario m= new Usuario();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
             m = manager.find(Usuario.class, id_marca);
    
           tx.commit();
         
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return m;
    }
     
     
      public List<Usuario> getAll(){
        List<Usuario> lista_marcas= new ArrayList<>();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
           
            lista_marcas= manager.createQuery("select a from Usuario a", Usuario.class).getResultList();
    
           tx.commit();
         
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }

        return lista_marcas;
    }
      
    public boolean validar_usuario(String login, String clave) {
        boolean rpta = false;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWebEjm1PU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {

            List<Usuario> lista_usuarios = manager.createQuery("select a from Usuario a where a.login='" + login + "' and a.clave='" + clave + "'", Usuario.class).getResultList();

            if (lista_usuarios.size() > 0) {
                rpta = true;
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        }

        return rpta;
    } 
    
}

