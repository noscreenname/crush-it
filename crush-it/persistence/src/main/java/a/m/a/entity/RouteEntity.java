package a.m.a.entity;

import javax.annotation.Nonnull;

public final class RouteEntity {

    int id;

    @Nonnull
    private String grade;

    @Nonnull
    private String zone;

    @Nonnull
    private String craig;

    @Nonnull
    private String notes;

    public RouteEntity() {

    }

    //<editor-fold desc="Getters & setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nonnull
    public String getGrade() {
        return grade;
    }

    public void setGrade(@Nonnull String grade) {
        this.grade = grade;
    }

    @Nonnull
    public String getZone() {
        return zone;
    }

    public void setZone(@Nonnull String zone) {
        this.zone = zone;
    }

    @Nonnull
    public String getCraig() {
        return craig;
    }

    public void setCraig(@Nonnull String craig) {
        this.craig = craig;
    }

    @Nonnull
    public String getNotes() {
        return notes;
    }

    public void setNotes(@Nonnull String notes) {
        this.notes = notes;
    }
    //</editor-fold>
}
