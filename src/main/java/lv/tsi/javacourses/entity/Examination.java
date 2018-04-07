package lv.tsi.javacourses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Examination {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int assessments;
    @Column
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAssessments() {
        return assessments;
    }

    public void setAssessments(int assessments) {
        this.assessments = assessments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
