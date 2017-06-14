
package com.isep.databasemanager.dao;

import com.isep.databasemanager.entities.FileType;
import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserFile;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;

public class FileDAO {

    public List<UserFile> getFilesByFileType(String keyWord) {

        EntityManager em = TransactionManager.initTransaction();

        List<UserFile> typeList = em.createQuery("SELECT f FROM UserFile f WHERE f.type.name LIKE :kw", UserFile.class)
                .setParameter("kw", "%" + keyWord + "%")
                .getResultList();
        TransactionManager.closeTransaction();

        return typeList;

    }

    public UserFile getFileById(long id) {

        EntityManager em = TransactionManager.initTransaction();
        UserFile file = em.find(UserFile.class, id);
        TransactionManager.closeTransaction();

        return file;

    }
    
    public void postNewFile(UserFile file) {
        
        EntityManager em = TransactionManager.initTransaction();
        em.merge(file);
        TransactionManager.closeTransaction();
        
    }
    
    public void validateFile(UserFile file) {
        
        file.setValidated(true);
        EntityManager em = TransactionManager.initTransaction();
        em.merge(file);
        TransactionManager.closeTransaction();
        
    }
    
}
