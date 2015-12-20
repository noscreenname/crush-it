package a.m.a;

import javax.annotation.Nonnull;

public final class Craig {

    @Nonnull
    private final String name;

    public Craig(@Nonnull String name) {
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return name;
    }
}
