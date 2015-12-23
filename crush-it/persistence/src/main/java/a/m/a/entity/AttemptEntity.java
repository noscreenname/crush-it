package a.m.a.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ATTEMPT")
public final class AttemptEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE", nullable = false, unique = false)
    private Date date;

    @Column(name = "tries", nullable = false, unique = false)
    private int tries;

    @ManyToOne(targetEntity = AttemptEntity.class, fetch = FetchType.EAGER)
    @Column(name = "ROUTE_ID")
    private RouteEntity routes;

    public AttemptEntity() {
    }

    //<editor-fold desc="getters & setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public RouteEntity getRoutes() {
        return routes;
    }

    public void setRoutes(RouteEntity routes) {
        this.routes = routes;
    }
    //</editor-fold>
}
