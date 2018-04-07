package lv.tsi.javacourses.entity;

import javax.persistence.*;

@Entity
@Table(name = "controlworks")
public class Controlworks {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int controlwork1;
    @Column
    private int controlwork2;
    @Column
    private int controlwork3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getControlwork1() {
        return controlwork1;
    }

    public void setControlwork1(int controlwork1) {
        this.controlwork1 = controlwork1;
    }

    public int getControlwork2() {
        return controlwork2;
    }

    public void setControlwork2(int controlwork2) {
        this.controlwork2 = controlwork2;
    }

    public int getControlwork3() {
        return controlwork3;
    }

    public void setControlwork3(int controlwork3) {
        this.controlwork3 = controlwork3;
    }
}
