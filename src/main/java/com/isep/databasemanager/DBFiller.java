/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager;

import com.isep.databasemanager.dao.TransactionManager;
import com.isep.databasemanager.entities.FileType;
import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserFile;
import com.isep.databasemanager.entities.UserRelation;
import com.isep.databasemanager.entities.UserTime;
import com.isep.databasemanager.entities.UserType;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) {

        UserType admin = new UserType("admin");
        UserType tutor = new UserType("tutor");
        UserType student = new UserType("student");
        
        FileType journal1 = new FileType("journal1");
        FileType journal2 = new FileType("journal2");
        FileType rapportE1 = new FileType("rapportE1");
        FileType rapportE2 = new FileType("rapportE2");
        FileType documentation = new FileType("documentation");
        
        UserTime userTime1 = new UserTime();
        UserTime userTime2 = new UserTime();
        UserTime userTime3 = new UserTime();
        
        GcfaUser student1 = new GcfaUser(8095, "Arrivet", "theophile@isep.fr", "tarrivet", userTime1, userTime3, student);
        GcfaUser student2 = new GcfaUser(9203, "Gourou", "jerem@isep.fr", "jgourou", userTime2, userTime3, student);
        GcfaUser student3 = new GcfaUser(9150, "Zingu", "julachris@isep.fr", "jzingu", userTime1, userTime3, student);
        GcfaUser student4 = new GcfaUser(9202, "Hugues", "theo@isep.fr", "thugues", userTime1, userTime3, student);
        GcfaUser admin1 = new GcfaUser(4, "Admin", "admin@isep.fr", "aadmin", userTime1, userTime3, admin);
        GcfaUser tutor1 = new GcfaUser(5, "Tutor1", "tutor1@isep.fr", "ttutor1", userTime1, userTime3, tutor);
        GcfaUser tutor2 = new GcfaUser(6, "Tutor1", "tutor1@isep.fr", "ttutor1", userTime1, userTime3, tutor);
        
        UserFile userFile1 = new UserFile("documentation.txt", 1494854000000l, admin1, true, documentation);
        UserFile userFile2 = new UserFile("guideDeLApprentissage.txt", 1494853890000l, admin1, true, documentation);
        UserFile userFile3 = new UserFile("journal.txt", 1494853400000l, student1, true, journal1);
        UserFile userFile4 = new UserFile("journal01.txt", 1494853100000l, student2, true, journal1);
        UserFile userFile5 = new UserFile("journal1.txt", 1494849000000l, student3, true, journal1);
        UserFile userFile6 = new UserFile("journal2.txt", 1494853700000l, student1, false, journal2);
        UserFile userFile7 = new UserFile("rapportE1.txt", 1494853889437l, student1, true, rapportE1);
        
        List<GcfaUser> group1 = new ArrayList<>();
        group1.add(student1);
        group1.add(student2);
        List<GcfaUser> group2 = new ArrayList<>();
        group1.add(student3);
        group1.add(student4);
        
        UserRelation relation1 = new UserRelation(tutor1.getName(), group1);
        UserRelation relation2 = new UserRelation(tutor2.getName(), group2);
        
        
        em = TransactionManager.initTransaction();
        em.persist(userFile1);
        em.persist(userFile2);
        em.persist(userFile3);
        em.persist(userFile4);
        em.persist(userFile5);
        em.persist(userFile6);
        em.persist(userFile7);
        
        em.persist(relation1);
        em.persist(relation2);
        TransactionManager.closeTransaction();
        
//        persistObject(new UserFile());
        
    }

    private static void persistObject(Object o) {
        em = TransactionManager.initTransaction();
        em.persist(o);
        TransactionManager.closeTransaction();
    }
//
//    private static void initTransaction() {
//        emf = Persistence.createEntityManagerFactory("gcfaPU");
//        em = emf.createEntityManager();
//        transac = em.getTransaction();
//        transac.begin();
//    }
//
//    private static void closeTransaction() {
//        transac.commit();
//        em.close();
//    }

}
