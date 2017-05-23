package com.isep.databasemanager.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GcfaUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserTime startDate;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserTime endDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserRelation userRelation;
    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<UserFile> userFiles;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserType type;

    public GcfaUser() {
    }

    public GcfaUser(long id, String firstName, String lastName, String email, String login, UserTime startDate, UserTime endDate, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }   
    
    public GcfaUser(Object[] o) {
        this.id = (long) o[0];
        this.email = (String) o[1];
        this.login = (String) o[2];
        this.firstName = (String) o[3];
        this.lastName = (String) o[4];
        this.endDate = (UserTime) o[6];//      TODO give him dates
        this.startDate = (UserTime) o[7];
        this.userFiles = (List<UserFile>) o[7];//    TODO give him files
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRelation getUserRelation() {
        return userRelation;
    }

    public void setUserRelation(UserRelation userRelation) {
        this.userRelation = userRelation;
    }

    public List<UserFile> getUserFiles() {
        return userFiles;
    }

    public void setUserFiles(List<UserFile> userFiles) {
        this.userFiles = userFiles;
    }
}