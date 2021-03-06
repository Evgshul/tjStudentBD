package lv.tsi.javacourses.boundary;



import lv.tsi.javacourses.control.Util;
import lv.tsi.javacourses.entity.Nameofdiscipline;
import lv.tsi.javacourses.entity.Student;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;


@ViewScoped
@Named
public class StudentRegistrationForm implements Serializable {
    private final static String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    @PersistenceContext
    private EntityManager em;

    private String stnum;
    private String fullName;
    private String discipline;
    private String email;
    private String phone;
    private Long studentId;
    private Student student;


    @Transactional
    public void findStudent() {
        student = em.find(Student.class, studentId);
    }

    public SelectItem[] selectDiscipline(){

        SelectItem[] sd = new SelectItem[Nameofdiscipline.values().length];

        /*int i = 0;
        for (Nameofdiscipline n : Nameofdiscipline.values()) {
            sd[i++] = new SelectItem(n, n.getLabel());
        }*/

        for (int i = 0; i < Nameofdiscipline.values().length; i++) {
            sd[i] = new SelectItem(Nameofdiscipline.values()[i], Nameofdiscipline.values()[i].getLabel());
            System.out.println(sd[i]);
        }
        return sd;
    }


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
        student.setDiscipline(discipline);
        student.setFullName(fullName);
        student.setEmail(email);
        student.setPhone(phone);
        em.persist(student);

        Util.addConfirm("student:confirm", "Successfull set initial student data");

        return null;
    }

    @Transactional
    public String setdiscipline() {
        Student stdiscipline = em.find(Student.class, studentId);
        stdiscipline.setDiscipline(discipline);
        em.persist(stdiscipline);

        Util.addConfirm("studdatacorr:discipline", "Discipline set successfull");

        return null;
    }

    @Transactional
    public String existstudregemail() {

        Student existstud = em.find(Student.class, studentId);
        existstud.setEmail(email);
        em.persist(existstud);
        Util.addConfirm("studdatacorr:email", "Email set success");
        return null;
    }


    @Transactional
    public String existstudregphone() {

        Student existstud = em.find(Student.class, studentId);
        existstud.setPhone(phone);
        em.persist(existstud);
        Util.addConfirm("studdatacorr:phone", "phone number set successfully");

        return null;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
