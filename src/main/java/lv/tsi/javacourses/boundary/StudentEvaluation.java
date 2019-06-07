package lv.tsi.javacourses.boundary;


import lv.tsi.javacourses.entity.Evaluation;
import lv.tsi.javacourses.entity.Student;

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
    private String exam;

    //private Evaluation controlwork1;
    //private Evaluation controlwork2;
    //private Evaluation controlwork3;


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
        studentevaluation.setExam(exam);
        em.persist(studentevaluation);
        return "/admin-space/index.xhtml?faces-redirect=true";
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

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

}
