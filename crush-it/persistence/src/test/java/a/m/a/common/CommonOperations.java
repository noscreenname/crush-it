package a.m.a.common;

import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

public final class CommonOperations {

    public static final Operation DELETE_ALL = deleteAllFrom(
            "ATTEMPT", "ROUTE", "GRADE", "GRADE_SYSTEM", "ZONE", "CRAIG");

    public static final Operation INSERT_FONT_GRADES = sequenceOf(
            insertInto("GRADE_SYSTEM").columns("ID", "NAME").values(1, "FONT").build(),
            insertInto("GRADE").columns("NAME", "GRADESYSTEM_ID")
                    .withGeneratedValue("ID", ValueGenerators.sequence())
                    .withGeneratedValue("TECH_VALUE", ValueGenerators.sequence())
                    .values("2", 1)
                    .values("3", 1)
                    .values("4-", 1)
                    .values("4", 1)
                    .values("4+", 1)
                    .values("5-", 1)
                    .values("5", 1)
                    .values("5+", 1)
                    .values("6A", 1)
                    .values("6A+", 1)
                    .values("6B", 1)
                    .values("6B+", 1)
                    .values("6C", 1)
                    .values("6C+", 1)
                    .values("7A", 1)
                    .values("7A+", 1)
                    .values("7B", 1)
                    .values("7B+", 1)
                    .values("7C", 1)
                    .values("7C+", 1)
                    .values("8A", 1)
                    .values("8A+", 1)
                    .values("8B", 1)
                    .values("8B+", 1)
                    .values("8C", 1)
                    .values("8C+", 1)
                    .build());

    public static final Operation INSERT_COLOR_GRADES = sequenceOf(
//            insertInto("GRADE_SYSTEM").columns("ID", "NAME").values(2, "COLOR").build());
            insertInto("GRADE_SYSTEM").columns("ID", "NAME").values(2, "COLOR").build(),
            insertInto("GRADE").columns("NAME", "GRADESYSTEM_ID")
                    .withGeneratedValue("ID", ValueGenerators.sequence().startingAt(100))
                    .withGeneratedValue("TECH_VALUE", ValueGenerators.sequence())
                    .values("yellow", 2)
                    .values("green", 2)
                    .values("blue", 2)
                    .values("red", 2)
                    .values("black", 2)
                    .values("purple", 2)
                    .build());
}

