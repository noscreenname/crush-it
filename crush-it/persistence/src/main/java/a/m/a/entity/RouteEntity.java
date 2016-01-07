package a.m.a.entity;

import a.m.a.Route;

import javax.annotation.Nonnull;
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

    public GradeEntity getGrade() {
        return grade;
    }

    public void setGrade(GradeEntity grade) {
        this.grade = grade;
    }

    public CragEntity getCrag() {
        return crag;
    }

    public void setCrag(CragEntity crag) {
        this.crag = crag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //</editor-fold>

    public static Route toRoute(@Nonnull Object entity) {
        RouteEntity routeEntity = (RouteEntity) entity;
        return new Route(
                routeEntity.name,
                GradeEntity.toGrade(routeEntity.grade),
                CragEntity.toCrag(routeEntity.crag),
                routeEntity.description);
    }
}
