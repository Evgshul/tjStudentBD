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
    private List<Student> getallstudent;

    @PersistenceContext
    private EntityManager em;


    public void getAllStudent() {

        Query query = em.createQuery("SELECT a from Student a");
        setGetallstudent(query.getResultList());

    }

    public List<Student> getGetallstudent() {
        return getallstudent;
    }

    public void setGetallstudent(List<Student> getallstudent) {
        this.getallstudent = getallstudent;
    }
}
