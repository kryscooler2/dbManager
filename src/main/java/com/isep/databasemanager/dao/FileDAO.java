/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager.dao;

import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserFile;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Sliveer
 */
public class FileDAO {

    public List<UserFile> getFilesByFileType(String keyWord) {

        EntityManager em = TransactionManager.initTransaction();

        List l = em.createNativeQuery("SELECT f.id FROM UserFile f WHERE f.type.name LIKE ?")
                .setParameter(1, "%" + keyWord + "%")
                .getResultList();

        List<UserFile> ans = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {
            ans.add(this.getFileById((long) l.get(i)));
        }

        return ans;

    }
    
    public UserFile getFileById(long id) {
        
        EntityManager em = TransactionManager.initTransaction();
        UserFile file = em.find(UserFile.class, id);
        TransactionManager.closeTransaction();
        
        return file;
        
    }
}
