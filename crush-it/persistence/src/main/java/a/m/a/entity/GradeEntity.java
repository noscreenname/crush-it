package a.m.a.entity;

import a.m.a.Grade;

import javax.annotation.Nonnull;
import javax.persistence.*;

@Entity
@Table(name = "GRADE")
public final class GradeEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "TECH_VALUE", nullable = false, unique = false)
    private int techValue;

    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    @ManyToOne(targetEntity = GradeSystemEntity.class, fetch = FetchType.EAGER)
    private GradeSystemEntity gradeSystem;

    public GradeEntity() {
    }

    //<editor-fold desc="getters & setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTechValue() {
        return techValue;
    }

    public void setTechValue(int techValue) {
        this.techValue = techValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeSystemEntity getGradeSystem() {
        return gradeSystem;
    }

    public void setGradeSystem(GradeSystemEntity gradeSystem) {
        this.gradeSystem = gradeSystem;
    }

    @Nonnull
    public Grade toGrade() {
        return new Grade(gradeSystem.toGradeSystem(), techValue, name);
    }
    //</editor-fold>
}
