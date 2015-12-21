package a.m.a;

import javax.annotation.Nonnull;
import java.util.Date;

public final class Attempt {

    @Nonnull
    private final Route route;

    @Nonnull
    private final Date date;

    @Nonnull
    private int tries;

    public Attempt(@Nonnull Route route, @Nonnull Date date) {
        this.route = route;
        this.date = date;
        this.tries = 0;
    }

    public void addTry() {
        tries++;
    }

    //<editor-fold desc="Description">
    @Nonnull
    public Route getRoute() {
        return route;
    }

    @Nonnull
    public Date getDate() {
        return date;
    }

    @Nonnull
    public int getTries() {
        return tries;
    }
    //</editor-fold>
}
