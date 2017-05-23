/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.databasemanager.dao;

import com.isep.databasemanager.entities.FileType;
import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserFile;
import java.math.BigInteger;
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

        List typeIdList = em.createNativeQuery("SELECT t.id FROM FileType t WHERE t.name LIKE ?")
                .setParameter(1, "%" + keyWord + "%")
                .getResultList();

        List<UserFile> ans = new ArrayList<>();

        for (int i = 0; i < typeIdList.size(); i++) {

            List<UserFile> l = em.find(FileType.class, (long) typeIdList.get(i)).getUserFiles();
            for (UserFile f : l) {
                ans.add(f);
            }
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
