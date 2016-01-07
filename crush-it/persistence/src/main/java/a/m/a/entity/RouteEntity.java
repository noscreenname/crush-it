package a.m.a.entity;

import a.m.a.Route;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
@Table(name = "ROUTE")
public final class RouteEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = true, unique = false)
    private String name;

    @ManyToOne(targetEntity = GradeEntity.class, fetch = FetchType.EAGER)
    private GradeEntity grade;

    @ManyToOne(targetEntity = CragEntity.class, fetch = FetchType.LAZY)
    private CragEntity crag;

    @Column(name = "DESCRIPTION", nullable = true, unique = false)
    private String description;

    public RouteEntity() {
    }

    //<editor-fold desc="Getters & setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public GradeEntity getGrade() {
        return grade;
    }

    public void setGrade(@Nonnull GradeEntity grade) {
        this.grade = grade;
    }

    public CragEntity getCrag() {
        return crag;
    }

    public void setCrag(@Nonnull CragEntity crag) {
        this.crag = crag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
    //</editor-fold>

    @Nonnull
    public Route toRoute() {
        return new Route(
                name,
                grade.toGrade(),
                crag.toCrag(),
                description);
    }
}
