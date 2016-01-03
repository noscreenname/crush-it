package a.m.a;

import javax.annotation.Nonnull;

public class Grade {

    @Nonnull
    private final GradeSystem system;

    @Nonnull
    private final int techValue;

    @Nonnull
    private final String value;

    public Grade(@Nonnull GradeSystem system, int techValue, @Nonnull String value) {
        this.system = system;
        this.techValue = techValue;
        this.value = value;
    }

    @Nonnull
    public GradeSystem getSystem() {
        return system;
    }

    @Nonnull
    public int getTechValue() {
        return techValue;
    }

    @Nonnull
    public String getValue() {
        return value;
    }
}
