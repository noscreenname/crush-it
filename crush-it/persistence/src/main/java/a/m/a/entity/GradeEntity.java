package a.m.a.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
@Table(name = "GRADE")
public final class GradeEntity implements BasicEntity<Long> {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "TECH_VALUE", nullable = false, unique = false)
    private int techValue;

    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    @ManyToOne(targetEntity = GradeSystemEntity.class, fetch = FetchType.EAGER)
    private GradeSystemEntity gradeSystem;

    public GradeEntity() {
    }

    public GradeEntity(@Nonnull GradeSystemEntity system, int techValue, @Nonnull String name) {
        this();
        setGradeSystem(system);
        setTechValue(techValue);
        setName(name);
    }

    //<editor-fold desc="getters & setters">
    @Override
    @Nullable
    public Long getId() {
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
    //</editor-fold>


    //<editor-fold desc="equals, hashCode & toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeEntity that = (GradeEntity) o;

        if (techValue != that.techValue) return false;
        if (gradeSystem != null ? !gradeSystem.equals(that.gradeSystem) : that.gradeSystem != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = techValue;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gradeSystem != null ? gradeSystem.hashCode() : 0);
        return result;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return "GradeEntity{" +
                "id=" + id +
                ", techValue=" + techValue +
                ", name='" + name + '\'' +
                ", gradeSystem=" + gradeSystem +
                '}';
    }
    //</editor-fold>
}
