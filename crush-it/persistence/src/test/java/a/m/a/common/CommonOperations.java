package a.m.a.common;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

public final class CommonOperations {

    public static final int FONT_SYSTEM_ID = 1;

    private static final int COLOR_SYSTEM_ID = 2;

    private static final int FIRST_COLOR_GRADE_ID = 100;

    public static final int ARKOSE_ID = 1;

    private static final int FONTAINEBLEAU_ID = 2;

    public static final int FONT_ROUTES_START = 100;

    public static DbSetup createDbSetup(Operation operation) {
        return new DbSetup(
                new DriverManagerDestination(
                        "jdbc:postgresql://localhost:5432/crushit-test", "postgres", "root"), operation);
    }
    public static final Operation DELETE_ALL = deleteAllFrom(
            "ATTEMPT", "ROUTE", "GRADE", "GRADE_SYSTEM", "CRAG");

    public static final Operation INSERT_FONT_GRADES = sequenceOf(
            insertInto("GRADE_SYSTEM").columns("ID", "NAME").values(FONT_SYSTEM_ID, "FONT").build(),
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
            insertInto("GRADE_SYSTEM")
                    .columns("ID", "NAME")
                    .values(COLOR_SYSTEM_ID, "COLOR")
                    .build(),
            insertInto("GRADE").columns("NAME", "GRADESYSTEM_ID")
                    .withGeneratedValue("ID", ValueGenerators.sequence().startingAt(FIRST_COLOR_GRADE_ID))
                    .withGeneratedValue("TECH_VALUE", ValueGenerators.sequence())
                    .values("yellow", 2)
                    .values("green", 2)
                    .values("blue", 2)
                    .values("red", 2)
                    .values("black", 2)
                    .values("purple", 2)
                    .build());

    public static Operation INSERT_ARKOSE_GRADES_AND_ROUTES = Operations.sequenceOf(
            INSERT_COLOR_GRADES,
            insertInto("CRAG")
                    .columns("ID", "NAME")
                    .values(ARKOSE_ID, "Arkose")
                    .build(),
            insertInto("ROUTE")
                    .columns("NAME", "GRADE_ID", "CRAG_ID", "DESCRIPTION")
                    .withGeneratedValue("ID", ValueGenerators.sequence())
                    .values("A1", FIRST_COLOR_GRADE_ID, ARKOSE_ID, "easy yellow")
                    .values("B2", FIRST_COLOR_GRADE_ID + 1, ARKOSE_ID, "bla bla")
                    .values("C2", FIRST_COLOR_GRADE_ID + 1, ARKOSE_ID, "some more bla")
                    .values("C2", FIRST_COLOR_GRADE_ID + 2, ARKOSE_ID, "overhanging with crimps")
                    .build()
    );
    public static Operation INSERT_FONT_GRADES_AND_ROUTES = Operations.sequenceOf(
            INSERT_FONT_GRADES,
            insertInto("CRAG")
                    .columns("ID", "NAME")
                    .values(FONTAINEBLEAU_ID, "Fontainebleau")
                    .build(),
            insertInto("ROUTE")
                    .columns("NAME", "GRADE_ID", "CRAG_ID", "DESCRIPTION")
                    .withGeneratedValue("ID", ValueGenerators.sequence().startingAt(FONT_ROUTES_START))
                    .values("Le dé", 10, ARKOSE_ID, "worm-up")
                    .values("Astragale", 11, ARKOSE_ID, "some words")
                    .values("La Théorie du Chaos", 11, ARKOSE_ID, "another easy one")
                    .build()
    );

}

