package a.m.a.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRAG")
public final class CragEntity implements BasicEntity<Long> {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    public CragEntity() {
    }

    public CragEntity(@Nonnull String name) {
        this();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>


    //<editor-fold desc="equals, hashCode & toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CragEntity that = (CragEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CragEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //</editor-fold>
}
