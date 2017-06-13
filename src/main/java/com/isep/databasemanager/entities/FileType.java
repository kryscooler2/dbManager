
package com.isep.databasemanager.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FileType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<UserFile> userFiles;

    public FileType() {
    }

    public FileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<UserFile> getUserFiles() {
        return userFiles;
    }

    public void setUserFiles(List<UserFile> userFiles) {
        this.userFiles = userFiles;
    }
    
}
