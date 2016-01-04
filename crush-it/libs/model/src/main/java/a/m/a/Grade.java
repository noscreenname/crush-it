package a.m.a;

import javax.annotation.Nonnull;

public class Grade {

    @Nonnull
    private final GradeSystem system;

    private final int techValue;

    @Nonnull
    private final String value;

    public Grade(@Nonnull GradeSystem system, int techValue, @Nonnull String value) {
        this.system = system;
        this.techValue = techValue;
        this.value = value;
    }

    //<editor-fold desc="getters">
    @Nonnull
    public GradeSystem getSystem() {
        return system;
    }

    public int getTechValue() {
        return techValue;
    }

    @Nonnull
    public String getValue() {
        return value;
    }
    //</editor-fold>

    //<editor-fold desc="equals, hashCode & toString">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (techValue != grade.techValue) return false;
        if (!system.equals(grade.system)) return false;
        if (!value.equals(grade.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = system.hashCode();
        result = 31 * result + techValue;
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%s - %s:%s]", value, system.getName(), techValue);
    }
    //</editor-fold>
}
