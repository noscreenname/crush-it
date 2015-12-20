package a.m.a.grades;

import javax.annotation.Nonnull;

public abstract class Grade {

    @Nonnull
    private final GradeSystem system;

    @Nonnull
    private final int techValue;

    protected Grade(@Nonnull GradeSystem system, int techValue) {
        this.system = system;
        this.techValue = techValue;
    }

    @Nonnull
    public GradeSystem getSystem() {
        return system;
    }

    @Nonnull
    public int getTechValue() {
        return techValue;
    }

    public String stringValue() {
        return system.get(techValue);
    }
}
