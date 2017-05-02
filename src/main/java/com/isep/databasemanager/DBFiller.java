/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager.filler;

import com.isep.databasemanager.entities.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sliveer
 */
public class DBFiller {

    public static void main(String[] args) {
        
        
        
        
        

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gcfaPU");

        EntityManager em = emf.createEntityManager();

        File file = new File();

        EntityTransaction transac = em.getTransaction();

        transac.begin();

        em.persist(file);

        transac.commit();

        em.close();

    }

}
