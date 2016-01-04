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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeSystem system = (GradeSystem) o;
        return name.equals(system.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return String.format("[%s]", name);
    }
}
