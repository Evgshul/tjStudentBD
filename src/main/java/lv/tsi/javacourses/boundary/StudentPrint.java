package lv.tsi.javacourses.boundary;


import lv.tsi.javacourses.entity.Student;

import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.PrintWriter;
import java.util.List;

@Stateless
@Named
public class StudentPrint {

    @PersistenceContext
    private EntityManager em;


    public List<Student> getAllStudent() {

        Query query = em.createQuery("SELECT a from Student a");
        return query.getResultList();

    }
}
