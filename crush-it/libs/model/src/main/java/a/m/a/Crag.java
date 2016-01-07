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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crag crag = (Crag) o;

        if (!name.equals(crag.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Crag{" + name + '}';
    }
}
