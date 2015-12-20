package a.m.a;

import a.m.a.grades.Grade;

import javax.annotation.Nonnull;
import java.util.Date;
import java.util.Optional;

public final class Route {

    private int tries;

    @Nonnull
    private Date firstStarted;

    @Nonnull
    private Optional<Date> finished;

    @Nonnull
    private Grade grade;

    @Nonnull
    private Optional<Zone> zone;

    @Nonnull
    private Craig craig;

    @Nonnull
    private String notes;

    public Route(@Nonnull Date firstStarted,
            int tries,
            @Nonnull Optional<Date> finished,
            @Nonnull Grade grade,
            @Nonnull Optional<Zone> zone,
            @Nonnull Craig craig,
            @Nonnull String notes) {
        this.firstStarted = firstStarted;
        this.tries = tries;
        this.finished = finished;
        this.grade = grade;
        this.zone = zone;
        this.craig = craig;
        this.notes = notes;
    }

    public int getTries() {
        return tries;
    }

    @Nonnull
    public Date getFirstStarted() {
        return firstStarted;
    }

    @Nonnull
    public Optional<Date> getFinished() {
        return finished;
    }

    @Nonnull
    public Grade getGrade() {
        return grade;
    }

    @Nonnull
    public Optional<Zone> getZone() {
        return zone;
    }

    @Nonnull
    public Craig getCraig() {
        return craig;
    }

    @Nonnull
    public String getNotes() {
        return notes;
    }
}
