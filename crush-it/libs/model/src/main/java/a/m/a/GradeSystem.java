package a.m.a;

import javax.annotation.Nonnull;

public final class GradeSystem {

    @Nonnull
    private final String name;

    public GradeSystem(@Nonnull String name) {
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return name;
    }
}
