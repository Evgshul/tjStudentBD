package lv.tsi.javacourses.boundary;


import com.sun.beans.finder.ClassFinder;
import lv.tsi.javacourses.entity.Student;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;

@SessionScoped
@Named
public class StudentRegistrationForm implements Serializable{
    private final static String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    @PersistenceContext
    private EntityManager em;

    private String stnum;
    private String fullName;
    private String email;
    private String phone;

    private Long studentId;

    @Transactional
    public String studregister() {

        Query e = em.createQuery("select s from Student s where s.stnum = :stnum");
        e.setParameter("stnum", stnum);
        if (e.getResultList().size() > 0) {
            FacesContext.getCurrentInstance()
                    .addMessage("student:stnum",
                            new FacesMessage("Student with this number already registered"));
            return null;

        }

        Student student = new Student();
        student.setStnum(stnum);
        student.setFullName(fullName);
        student.setEmail(email);
        student.setPhone(phone);

        em.persist(student);

        return "/admin-space/index.xhtml?faces-redirect=true";

    }

    @Transactional
    public String existstudreg() {

        Student existstud = em.find(Student.class, studentId);
        existstud.setEmail(email);
        existstud.setPhone(phone);

        em.persist(existstud);

        return "/admin-space/index.xhtml?faces-redirect=true";
    }


    public String getEmailRegex() {
        return EMAIL_REGEX;
    }

    public String getStnum() {
        return stnum;
    }

    public void setStnum(String stnum) {
        this.stnum = stnum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
