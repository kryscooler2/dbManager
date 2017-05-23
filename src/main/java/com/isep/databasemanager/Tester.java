/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager;

import com.isep.databasemanager.dao.FileDAO;
import com.isep.databasemanager.dao.TransactionManager;
import com.isep.databasemanager.dao.UserDAO;
import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserFile;
import com.isep.databasemanager.entities.UserTime;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
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

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

//        UserDAO userDao = new UserDAO();
//        List<GcfaUser> l = userDao.getUsersByKeyWord("Theophile");
//        
//        for (GcfaUser u:l) {
//            System.out.println(u.getFirstName());
//        }


        //System.out.println(userDao.getUserById(8095).getFirstName());
            



        FileDAO fDao = new FileDAO();
        List<UserFile> l = fDao.getFilesByFileType("journal1");
        
        for (UserFile f : l) {
            System.out.println(f.getFileName());
        }

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

        persistObject(new GcfaUser(1l, name, "firstname", "toto@toto.fr", "ttoto", new UserTime(), new UserTime(), null));

        return getUserEmail(name);

    }

}
