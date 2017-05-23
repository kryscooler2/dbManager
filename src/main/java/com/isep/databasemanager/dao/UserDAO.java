/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager.dao;

import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserRelation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Sliveer
 */
public class UserDAO {

    public GcfaUser getUserById(long id) {
        
        String path = System.getProperty("user.dir");
        
        EntityManager em = TransactionManager.initTransaction();
        GcfaUser user = em.find(GcfaUser.class, id);
        TransactionManager.closeTransaction();
        
        return user;
        
    }

    public List<GcfaUser> getUserRelationByTutorId(long tutorId) {
        
        EntityManager em = TransactionManager.initTransaction();
        UserRelation relation = em.find(UserRelation.class, tutorId);
        TransactionManager.closeTransaction();
        List<GcfaUser> students = relation.getStudents();
        
        return students;
        
    }
//
//    public String get() {
//
//    }
//
//    public String get() {
//
//    }
//
//    public String get() {
//
//    }
    public List<GcfaUser> getUsersByKeyWord(String keyWord) {

        EntityManager em = TransactionManager.initTransaction();

        List l = em.createNativeQuery("SELECT u.id FROM GcfaUser u WHERE u.name LIKE ?")
                .setParameter(1, "%"+keyWord+"%")
                .getResultList();
        
        List<GcfaUser> ans = new ArrayList<>();
        
        for (int i = 0; i < l.size(); i++) {
            ans.add(this.getUserById((long)l.get(i)));
        }
        
        return ans;

    }

}
