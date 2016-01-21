package a.m.a.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
@Table(name = "ROUTE")
public final class RouteEntity implements BasicEntity<Long> {

    @Id
    @Column(name = "ID")
    private long id;

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

    public RouteEntity(@Nonnull String name,
                       @Nonnull GradeEntity grade,
                       @Nonnull CragEntity crag,
                       @Nullable String description) {
        this();
        setName(name);
        setGrade(grade);
        setCrag(crag);
        setDescription(description);
    }

    //<editor-fold desc="Getters & setters">
    @Override
    @Nullable
    public Long getId() {
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


    //<editor-fold desc="equals, hashCode & toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (crag != null ? !crag.equals(that.crag) : that.crag != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (crag != null ? crag.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RouteEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", crag=" + crag +
                ", description='" + description + '\'' +
                '}';
    }
    //</editor-fold>
}
