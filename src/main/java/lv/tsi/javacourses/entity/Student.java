package lv.tsi.javacourses.entity;

import javax.persistence.*;

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
    private String exam;
    @Column
    private String controlwork1;
    @Column
    private String controlwork2;
    @Column
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

    @Override
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
