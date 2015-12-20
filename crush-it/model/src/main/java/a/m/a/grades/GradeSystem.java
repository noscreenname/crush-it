package a.m.a.grades;

import javax.annotation.Nonnull;

public interface GradeSystem {

    //<editor-fold desc="Implementations">
    public static final GradeSystem FONT = new ArrayBasedGradeSystem(
            "FONT", new String[]{
            "1",
            "2",
            "3",
            "4-",
            "4",
            "4+",
            "5-",
            "5",
            "5+",
            "6A",
            "6A+",
            "6B",
            "6B+",
            "6C",
            "6C+",
            "7A",
            "7A+",
            "7B",
            "7B+",
            "7C",
            "7C+",
            "8A",
            "8A+",
            "8B",
            "8B+",
            "8C",
            "8C+"});
    //</editor-fold>

    @Nonnull
    String getName();

    String get(int techValue);
}
