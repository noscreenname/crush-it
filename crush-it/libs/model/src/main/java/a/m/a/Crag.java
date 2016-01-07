package a.m.a;

import javax.annotation.Nonnull;

public final class Crag {

    @Nonnull
    private final String name;

    public Crag(@Nonnull String name) {
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return name;
    }
}
