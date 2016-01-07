package a.m.a.entity;

import a.m.a.GradeSystem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRADE_SYSTEM")
public final class GradeSystemEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    //<editor-fold desc="getters & setters">
    public GradeSystemEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nonnull
    public GradeSystem toGradeSystem() {
        return new GradeSystem(name);
    }
    //</editor-fold>
}
