package a.m.a;

import javax.annotation.Nonnull;

public final class Zone {

    @Nonnull
    private final String name;

    public Zone(@Nonnull String name) {
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return name;
    }
}
