package lv.tsi.javacourses.boundary;


import lv.tsi.javacourses.entity.Evaluation;
import lv.tsi.javacourses.entity.Student;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@ViewScoped
@Named
public class StudentEvaluation implements Serializable {

    private Long studentId;
    private Student student;
    private String dateofexam;
    private String exam;
    private String controlwork1;
    private String controlwork2;
    private String controlwork3;


    @PersistenceContext
    private EntityManager em;


    public SelectItem[] getEvaluation() {

        SelectItem[] ev = new SelectItem[Evaluation.values().length];
        int i = 0;
        for (Evaluation e : Evaluation.values()) {
            ev[i++] = new SelectItem(e, e.getLabel());
        }
        return ev;
    }


    @Transactional
    public void findEvaluationStudent() {
        student = em.find(Student.class, studentId);
    }

    @Transactional
    public String studEvaluation() {

        Student studentevaluation = em.find(Student.class, studentId);
        studentevaluation.setDateofexam(dateofexam);
        studentevaluation.setExam(exam);
        em.persist(studentevaluation);
        return "/admin-space/index.xhtml?faces-redirect=true";
    }

    @Transactional
    public String controlworkSetMark1() {
        Student studentcontrol1 = em.find(Student.class, studentId);
        studentcontrol1.setControlwork1(controlwork1);
        em.persist(studentcontrol1);
        return "Success";
    }

    @Transactional
    public String controlworkSetMark2() {
        Student studentcontrol2 = em.find(Student.class, studentId);
        studentcontrol2.setControlwork1(controlwork2);
        em.persist(studentcontrol2);
        return "/admin-space/searchstudentforevaluation.xhtml?faces-redirect=true";
    }

    @Transactional
    public String controlworkSetMark3() {
        Student studentcontrol3 = em.find(Student.class, studentId);
        studentcontrol3.setControlwork1(controlwork3);
        em.persist(studentcontrol3);
        FacesContext.getCurrentInstance().addMessage("controlworks:controlworks3",
                new FacesMessage("You succesful set mark for controlwork3"));

        return "/admin-space/searchstudentforevaluation.xhtml?faces-redirect=true";
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

    public String getDateofexam() {
        return dateofexam;
    }

    public void setDateofexam(String dateofexam) {
        this.dateofexam = dateofexam;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getControlwork1() {
        return controlwork1;
    }

    public void setControlwork1(String controlwork1) {
        this.controlwork1 = controlwork1;
    }

    public String getControlwork2() {
        return controlwork2;
    }

    public void setControlwork2(String controlwork2) {
        this.controlwork2 = controlwork2;
    }

    public String getControlwork3() {
        return controlwork3;
    }

    public void setControlwork3(String controlwork3) {
        this.controlwork3 = controlwork3;
    }
}
