package com.isep.databasemanager.entities;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserFile implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private File file = new File("Coucou.png");

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}