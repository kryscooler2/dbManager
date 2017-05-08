package com.isep.databasemanager.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserTime implements Serializable {
            
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private long millis;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<GcfaUser> users;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public List<GcfaUser> getUsers() {
        return users;
    }

    public void setUsers(List<GcfaUser> users) {
        this.users = users;
    }
    
}
