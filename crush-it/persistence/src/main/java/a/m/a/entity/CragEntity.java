package a.m.a.entity;

import a.m.a.Crag;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRAG")
public final class CragEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    public CragEntity() {
    }

    //<editor-fold desc="getters & setters">
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
    //</editor-fold>

    public static Crag toCrag(@Nonnull Object entity) {
        CragEntity cragEntity = (CragEntity) entity;
        return new Crag(cragEntity.name);
    }
}
