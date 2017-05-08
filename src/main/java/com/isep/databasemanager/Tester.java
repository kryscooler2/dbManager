/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager;

import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sliveer
 */
public class Tester {

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static EntityTransaction transac;

    public static void main(String[] args) {

        persistObject(new GcfaUser("toto", "mypass", "toto@toto.fr", "ttoto", new UserTime(), new UserTime()));

    }

    private static void persistObject(Object o) {
        initTransaction();
        em.persist(o);
        closeTransaction();
    }

    public static String getUserEmail(String name) {

        initTransaction();
        Query q = em.createNativeQuery("SELECT g.email FROM GcfaUser g WHERE g.name = ?");
        q.setParameter(1, name);
        String email = (String) q.getSingleResult();
        
        return email;

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

    public static String createAndRetrieveUserEmail(String name) {

        persistObject(new GcfaUser(name, "mypass", "toto@toto.fr", "ttoto", new UserTime(), new UserTime()));

        return getUserEmail(name);

    }

}
