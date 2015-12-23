package a.m.a.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRAIG")
public final class CraigEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    public CraigEntity() {
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
}
