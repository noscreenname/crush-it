package a.m.a.grades;

import javax.annotation.Nonnull;

public class ArrayBasedGradeSystem implements GradeSystem {

    @Nonnull
    private final String name;

    @Nonnull
    private final String[] values;

    ArrayBasedGradeSystem(@Nonnull String name, @Nonnull String[] values) {
        this.name = name;
        this.values = values;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String get(int techValue) {
        assert techValue >= 0;
        return values[techValue];
    }
}
