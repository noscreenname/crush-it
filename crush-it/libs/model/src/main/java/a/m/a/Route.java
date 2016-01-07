package a.m.a;

import javax.annotation.Nonnull;

public final class Route {

    @Nonnull
    private String name;

    @Nonnull
    private Grade grade;

    @Nonnull
    private Crag crag;

    @Nonnull
    private String description;

    public Route(@Nonnull String name,
                 @Nonnull Grade grade,
                 @Nonnull Crag crag,
                 @Nonnull String description) {
        this.name = name;
        this.grade = grade;
        this.crag = crag;
        this.description = description;
    }

    //<editor-fold desc="getters">
    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public Grade getGrade() {
        return grade;
    }

    @Nonnull
    public Crag getCrag() {
        return crag;
    }

    @Nonnull
    public String getDescription() {
        return description;
    }
    //</editor-fold>

    //<editor-fold desc="equals, hashCode, toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route = (Route) o;
        return crag.equals(route.crag) &&
                description.equals(route.description) &&
                grade.equals(route.grade) &&
                name.equals(route.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + grade.hashCode();
        result = 31 * result + crag.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", crag=" + crag +
                ", description='" + description + '\'' +
                '}';
    }

    //</editor-fold>
}
