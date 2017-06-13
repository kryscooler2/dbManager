
package com.isep.databasemanager.dao;

import com.isep.databasemanager.entities.GcfaUser;
import com.isep.databasemanager.entities.UserRelation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class UserDAO {

    public GcfaUser getUserById(long id) {

        EntityManager em = TransactionManager.initTransaction();
        GcfaUser user = em.find(GcfaUser.class, id);
        TransactionManager.closeTransaction();

        return user;

    }

//    public List<GcfaUser> getUserRelationByTutorId(long tutorId) {
//
//        EntityManager em = TransactionManager.initTransaction();
//        UserRelation relation = em.find(UserRelation.class, tutorId);
//        TransactionManager.closeTransaction();
//        List<GcfaUser> students = relation.getStudents();
//
//        return students;
//
//    }
//
//    public String get() {
//
//    }
//
//    public String get() {
//
//    }
//

    public List<GcfaUser> getStudentListByTutor(GcfaUser tutor) {

        if (this.getUserById(tutor.getId()).getType().getName().equals("tutor")) {

            EntityManager em = TransactionManager.initTransaction();

            List<GcfaUser> users = em.createQuery("SELECT u FROM GcfaUser u WHERE u.userRelation.tutor.id = :id", GcfaUser.class)
                    .setParameter("id", tutor.getId())
                    .getResultList();
            TransactionManager.closeTransaction();
            return users;
        }

        return null;

    }

    public List<GcfaUser> getUsersByKeyWord(String keyWord) {

        EntityManager em = TransactionManager.initTransaction();

        List<GcfaUser> users = em.createQuery("SELECT u FROM GcfaUser u WHERE u.lastName LIKE :kw OR u.firstName LIKE :kw OR u.login LIKE :kw", GcfaUser.class)
                .setParameter("kw", "%" + keyWord + "%")
                .getResultList();

        TransactionManager.closeTransaction();

        return users;

    }

}
