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
public class UserRelation implements Serializable {
            
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private GcfaUser tutor;
    
    @OneToMany(mappedBy = "userRelation", cascade = CascadeType.PERSIST)
    private List<GcfaUser> students;

    public UserRelation() {
    }

    public UserRelation(GcfaUser tutor, List<GcfaUser> students) {
        this.tutor = tutor;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GcfaUser getTutor() {
        return tutor;
    }

    public void setTutor(GcfaUser tutor) {
        this.tutor = tutor;
    }

    public List<GcfaUser> getStudents() {
        return students;
    }

    public void setStudents(List<GcfaUser> students) {
        this.students = students;
    }
    
}
