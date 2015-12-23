package a.m.a.entity;

import javax.persistence.*;

@Entity
@Table(name = "ZONE")
public final class ZoneEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private int name;

    @ManyToOne(targetEntity = CraigEntity.class, fetch = FetchType.EAGER)
    private CraigEntity craig;

    public ZoneEntity() {
    }

    //<editor-fold desc="getters & setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public CraigEntity getCraig() {
        return craig;
    }

    public void setCraig(CraigEntity craig) {
        this.craig = craig;
    }
    //</editor-fold>
}
