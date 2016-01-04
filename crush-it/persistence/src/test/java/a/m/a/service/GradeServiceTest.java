package a.m.a.service;

import a.m.a.Grade;
import a.m.a.GradeSystem;
import a.m.a.common.CommonOperations;
import com.google.common.collect.Lists;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GradeServiceTest {

    @Nonnull
    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
    private GradeService service;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Operation operation = sequenceOf(
                CommonOperations.DELETE_ALL,
                CommonOperations.INSERT_COLOR_GRADES,
                CommonOperations.INSERT_FONT_GRADES);
        DbSetup dbSetup = new DbSetup(
                new DriverManagerDestination(
                        "jdbc:postgresql://localhost:5432/crushit-test", "postgres", "root"), operation);
        dbSetup.launch();
        service = new GradeService();
    }

    @Test
    public void getAll_should_return_all_grades() {
        dbSetupTracker.skipNextLaunch();
        Map<String, List<Grade>> actual = service.getAllGrades();
        assertNotNull(actual);
        assertEquals(actual.size(), 2);
        assertEquals(actual.get("FONT").size(), 26);
        //TODO AMA check order
    }

    @Test
    public void getAll_with_str_param_should_return_all_grades_of_a_system() {
        dbSetupTracker.skipNextLaunch();
        List<Grade> actual = service.getAllGrades("COLOR");
        GradeSystem system = new GradeSystem("COLOR");
        assertEquals(actual, Lists.newArrayList(
                new Grade(system, 1, "yellow"),
                new Grade(system, 2, "green"),
                new Grade(system, 3, "blue"),
                new Grade(system, 4, "red"),
                new Grade(system, 5, "black"),
                new Grade(system, 6, "purple")
        ));
    }

}