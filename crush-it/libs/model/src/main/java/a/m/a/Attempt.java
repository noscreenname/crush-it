package a.m.a;

import javax.annotation.Nonnull;
import java.time.LocalDate;

public final class Attempt {

    @Nonnull
    private final Route route;

    @Nonnull
    private final LocalDate date;

    @Nonnull
    private int tries;

    public Attempt(@Nonnull Route route, @Nonnull LocalDate date) {
        this.route = route;
        this.date = date;
        this.tries = 0;
    }

    //<editor-fold desc="getters">
    @Nonnull
    public Route getRoute() {
        return route;
    }

    @Nonnull
    public LocalDate getDate() {
        return date;
    }

    @Nonnull
    public int getTries() {
        return tries;
    }
    //</editor-fold>


    //<editor-fold desc="equals, hashCode & toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attempt attempt = (Attempt) o;

        if (tries != attempt.tries) return false;
        if (!date.equals(attempt.date)) return false;
        if (!route.equals(attempt.route)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = route.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + tries;
        return result;
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "route=" + route +
                ", date=" + date +
                ", tries=" + tries +
                '}';
    }
    //</editor-fold>
}
