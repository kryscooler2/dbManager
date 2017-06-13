package com.isep.databasemanager.dao;

import com.isep.databasemanager.entities.FileType;
import com.isep.databasemanager.entities.UserFile;
import javax.persistence.EntityManager;

public class FileTypeDAO {

    public FileType getFileByName(String name) {

        EntityManager em = TransactionManager.initTransaction();
        
        FileType fileType = em.createQuery("SELECT ft FROM FileType ft WHERE ft.name = :name", FileType.class)
                .setParameter("name", name)
                .getSingleResult();
        
        TransactionManager.closeTransaction();

        return fileType;

    }

}
