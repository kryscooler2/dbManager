package com.isep.databasemanager.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GcfaUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    private String password;
    private String email;
    private String login;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserTime startDate;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserTime endDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserRelation userRelation;

    public GcfaUser() {
    }

    public GcfaUser(String name, String password, String email, String login, UserTime startDate, UserTime endDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.login = login;
        this.startDate = startDate;
        this.endDate = endDate;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserTime getStartDate() {
        return startDate;
    }

    public void setStartDate(UserTime startDate) {
        this.startDate = startDate;
    }

    public UserTime getEndDate() {
        return endDate;
    }

    public void setEndDate(UserTime endDate) {
        this.endDate = endDate;
    }
}