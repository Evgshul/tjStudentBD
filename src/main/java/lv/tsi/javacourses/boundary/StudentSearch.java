package lv.tsi.javacourses.boundary;


import lv.tsi.javacourses.entity.Student;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Named
public class StudentSearch {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private StudentsSearchForm studentSearchForm;

    private List<Student> getallstudent() {
        Query q = em.createQuery("SELECT s from Student s");
        return q.getResultList();
    }


    public void doSearch() {

        Query q = em.createQuery("SELECT s from Student s where " +
                "UPPER(s.stnum) like :cond " +
                "OR UPPER(s.fullName) like :cond " +
                "OR UPPER(s.email) like :cond " +
                "OR UPPER(s.phone) like :cond " +
                "OR UPPER(s.controlwork1) like :cond " +
                "OR UPPER(s.controlwork2) like :cond " +
                "OR UPPER(s.controlwork3) like :cond " +
                "OR UPPER(s.exam) like :cond ");
        String cond = "%" + studentSearchForm.getCond().toUpperCase() + "%";
        q.setParameter("cond", cond);
        studentSearchForm.setSearchResult(q.getResultList());

    }

}
