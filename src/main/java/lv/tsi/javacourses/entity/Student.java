package lv.tsi.javacourses.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String stnum;
    //    @Column
    //  private String discipline;
    @Column
    private String fullName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    //@Enumerated(EnumType.STRING)
    private String exam;
    @Column
    //@Enumerated(EnumType.STRING)
    private String controlwork1;
    @Column
    //@Enumerated(EnumType.STRING)
    private String controlwork2;
    @Column
    //@Enumerated(EnumType.STRING)
    private String controlwork3;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

/*    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }*/


    /*public Evaluation getExam() {
        return exam;
    }

    public void setExam(Evaluation exam) {
        this.exam = exam;
    }


    public Evaluation getControlwork1() {
        return controlwork1;
    }

    public void setControlwork1(Evaluation controlwork1) {
        this.controlwork1 = controlwork1;
    }


    public Evaluation getControlwork2() {
        return controlwork2;
    }

    public void setControlwork2(Evaluation controlwork2) {
        this.controlwork2 = controlwork2;
    }

    public Evaluation getControlwork3() {
        return controlwork3;
    }

    public void setControlwork3(Evaluation controlwork3) {
        this.controlwork3 = controlwork3;
    }*/

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stnum='" + stnum + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", exam=" + exam +
                ", controlwork1=" + controlwork1 +
                ", controlwork2=" + controlwork2 +
                ", controlwork3=" + controlwork3 +
                '}';
    }

/*   @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stnum='" + stnum + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", exam='" + exam + '\'' +
                ", controlwork1='" + controlwork1 + '\'' +
                ", controlwork2='" + controlwork2 + '\'' +
                ", controlwork3='" + controlwork3 + '\'' +
                '}';
    }*/
}
