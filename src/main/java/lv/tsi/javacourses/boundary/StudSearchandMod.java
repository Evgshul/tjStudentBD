package lv.tsi.javacourses.boundary;

import lv.tsi.javacourses.entity.Student;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@ViewScoped
@Named
public class StudSearchandMod implements Serializable {

    @PersistenceContext
    private EntityManager em;

    private List<Student> student;


    public Student getexistStudent(String stnum) {

        student = em.createQuery("SELECT e from Student e WHERE e.stnum =:stnum")
                .setParameter("stnum", stnum)
                .getResultList();


        return null;
    }

    @Transactional
    public Student corExistStudent(String stnum, String phone, String email) {
        Query b = em.createQuery("update Student a SET a.phone =:phone," +
                " a.email =:email where a.stnum =:stnum", Student.class)
                .setParameter("stnum", stnum)
                .setParameter("phone", phone)
                .setParameter("email", email);

        em.persist(b);
        return null;
    }


    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
