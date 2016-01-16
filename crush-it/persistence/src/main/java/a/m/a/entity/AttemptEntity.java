package a.m.a.entity;

import a.m.a.Attempt;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "ATTEMPT")
public final class AttemptEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE", nullable = false, unique = false)
    private Date date;

    @Column(name = "TRIES", nullable = false, unique = false)
    private int tries;

    @ManyToOne(targetEntity = RouteEntity.class, fetch = FetchType.EAGER)
    private RouteEntity route;

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

    public void setDate(@Nonnull LocalDate date) {
        this.date = Date.valueOf(date);
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    @Nullable
    public static Attempt toAttempt(@Nullable AttemptEntity entity) {
        return entity == null ? null : new Attempt(entity.route.toRoute(), entity.date.toLocalDate());
    }
    //</editor-fold>
}
