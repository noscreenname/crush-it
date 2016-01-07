package a.m.a.service;

import a.m.a.Grade;
import a.m.a.GradeSystem;
import a.m.a.common.CommonOperations;
import com.google.common.collect.Lists;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GradeServiceTest {

    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
    private GradeService service;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Operation operation = sequenceOf(
                CommonOperations.DELETE_ALL,
                CommonOperations.INSERT_COLOR_GRADES,
                CommonOperations.INSERT_FONT_GRADES);
        DbSetup dbSetup = CommonOperations.createDbSetup(operation);
        dbSetup.launch();
        service = new GradeService();
    }

    @Test
    public void getAll_should_return_all_grades() {
        dbSetupTracker.skipNextLaunch();
        GradeSystem font = new GradeSystem("FONT");
        Map<String, List<Grade>> actual = service.getAll();
        assertNotNull(actual);
        assertEquals(actual.size(), 2);
        assertEquals(actual.get(font.getName()).size(), 26);
        assertEquals(actual.get(font.getName()), Lists.newArrayList(
                new Grade(font, 1, "2"),
                new Grade(font, 2, "3"),
                new Grade(font, 3, "4-"),
                new Grade(font, 4, "4"),
                new Grade(font, 5, "4+"),
                new Grade(font, 6, "5-"),
                new Grade(font, 7, "5"),
                new Grade(font, 8, "5+"),
                new Grade(font, 9, "6A"),
                new Grade(font, 10, "6A+"),
                new Grade(font, 11, "6B"),
                new Grade(font, 12, "6B+"),
                new Grade(font, 13, "6C"),
                new Grade(font, 14, "6C+"),
                new Grade(font, 15, "7A"),
                new Grade(font, 16, "7A+"),
                new Grade(font, 17, "7B"),
                new Grade(font, 18, "7B+"),
                new Grade(font, 19, "7C"),
                new Grade(font, 20, "7C+"),
                new Grade(font, 21, "8A"),
                new Grade(font, 22, "8A+"),
                new Grade(font, 23, "8B"),
                new Grade(font, 24, "8B+"),
                new Grade(font, 25, "8C"),
                new Grade(font, 26, "8C+")
        ));
    }

    @Test
    public void getAll_with_str_param_should_return_all_grades_of_a_system() {
        dbSetupTracker.skipNextLaunch();
        List<Grade> actual = service.getAll("COLOR");
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