package a.m.a.entity;

import javax.persistence.*;

@Entity
@Table(name = "GRADE_SYSTEM")
public final class RouteEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = true, unique = false)
    private String name;

    @ManyToOne(targetEntity = GradeEntity.class, fetch = FetchType.EAGER)
    private GradeEntity grade;

    @ManyToOne(targetEntity = ZoneEntity.class, fetch = FetchType.LAZY)
    private ZoneEntity zone;

    @ManyToOne(targetEntity = CraigEntity.class, fetch = FetchType.LAZY)
    private CraigEntity craig;

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

    public ZoneEntity getZone() {
        return zone;
    }

    public void setZone(ZoneEntity zone) {
        this.zone = zone;
    }

    public CraigEntity getCraig() {
        return craig;
    }

    public void setCraig(CraigEntity craig) {
        this.craig = craig;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //</editor-fold>
}
