/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager;

import com.isep.databasemanager.entities.UserFile;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sliveer
 */
public class DBFiller {

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static EntityTransaction transac;

    public static void main(String[] args) {

        persistObject(new UserFile());
        
    }

    private static void persistObject(Object o) {
        initTransaction();
        em.persist(o);
        closeTransaction();
    }

    private static void initTransaction() {
        emf = Persistence.createEntityManagerFactory("gcfaPU");
        em = emf.createEntityManager();
        transac = em.getTransaction();
        transac.begin();
    }

    private static void closeTransaction() {
        transac.commit();
        em.close();
    }

}
