package lv.tsi.javacourses.boundary;


import lv.tsi.javacourses.entity.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
@Named
public class StudentRegistrationForm {
@PersistenceContext
    private EntityManager em;

private String stnum;
private String fullName;
private String email;
private String phone;

public String studregister() {


    Student student = new Student();
    student.setStnum(stnum);
    student.setFullName(fullName);
    student.setEmail(email);
    student.setPhone(phone);

    em.persist(student);

    return null;
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
}
