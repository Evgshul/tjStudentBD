package lv.tsi.javacourses.boundary;

import lv.tsi.javacourses.entity.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RequestScoped
@Named
public class StudentDetailForm {
    @PersistenceContext
    private EntityManager em;
    private Long studentId;
    private Student student;


    public void findStudent() {
        student = em.find(Student.class, studentId);
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
}
