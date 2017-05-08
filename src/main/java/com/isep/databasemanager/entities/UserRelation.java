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
public class UserRelation implements Serializable {
            
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String tutorName;
    
    @OneToMany(mappedBy = "userRelation", cascade = CascadeType.PERSIST)
    private List<GcfaUser> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public List<GcfaUser> getStudents() {
        return students;
    }

    public void setStudents(List<GcfaUser> students) {
        this.students = students;
    }
    
}
