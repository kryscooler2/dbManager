/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sliveer
 */
public class TransactionManager {
    
    public final static String DATABASE_PU = "gcfaPU";

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static EntityTransaction transac;

    public static EntityManager initTransaction() {
        
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(DATABASE_PU);
        }
        em = emf.createEntityManager();
        transac = em.getTransaction();
        transac.begin();
        return em;
        
    }

    public static void closeTransaction() {
        transac.commit();
        em.close();
        if(emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
        em = null;
    }

}
