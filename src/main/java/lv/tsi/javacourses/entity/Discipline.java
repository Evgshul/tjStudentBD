package lv.tsi.javacourses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discipline {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100)
    private String disname;



}
