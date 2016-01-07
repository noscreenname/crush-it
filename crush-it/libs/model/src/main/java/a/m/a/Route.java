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
}
