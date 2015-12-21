package a.m.a.entity;

import javax.persistence.*;

@Entity
@Table(name = "GRADE_SYSTEM")
public final class GradeSystemEntity {

    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    //<editor-fold desc="getters & setters">
    public GradeSystemEntity() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>
}
