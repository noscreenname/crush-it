package a.m.a.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "ATTEMPT")
public final class AttemptEntity implements BasicEntity<Long> {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "DATE", nullable = false, unique = false)
    private Date date;

    @Column(name = "TRIES", nullable = false, unique = false)
    private int tries;

    @ManyToOne(targetEntity = RouteEntity.class, fetch = FetchType.EAGER)
    private RouteEntity route;

    public AttemptEntity() {
    }

    public AttemptEntity(@Nonnull RouteEntity route, @Nonnull LocalDate localDate) {
        super();
        setRoute(route);
        setDate(Date.valueOf(localDate));
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

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }
    //</editor-fold>


    //<editor-fold desc="equals, hashCode & toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttemptEntity that = (AttemptEntity) o;

        if (tries != that.tries) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (route != null ? !route.equals(that.route) : that.route != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + tries;
        result = 31 * result + (route != null ? route.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AttemptEntity{" +
                "id=" + id +
                ", date=" + date +
                ", tries=" + tries +
                ", route=" + route +
                '}';
    }
    //</editor-fold>
}
