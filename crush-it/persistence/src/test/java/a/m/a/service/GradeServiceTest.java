package a.m.a.service;

import a.m.a.common.CommonOperations;
import a.m.a.entity.GradeEntity;
import a.m.a.entity.GradeSystemEntity;
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
        GradeSystemEntity font = new GradeSystemEntity("FONT");
        Map<String, List<GradeEntity>> actual = service.getAllOrdered();
        assertNotNull(actual);
        assertEquals(actual.size(), 2);
        assertEquals(actual.get(font.getName()).size(), 26);
        assertEquals(actual.get(font.getName()), Lists.newArrayList(
                new GradeEntity(font, 1, "2"),
                new GradeEntity(font, 2, "3"),
                new GradeEntity(font, 3, "4-"),
                new GradeEntity(font, 4, "4"),
                new GradeEntity(font, 5, "4+"),
                new GradeEntity(font, 6, "5-"),
                new GradeEntity(font, 7, "5"),
                new GradeEntity(font, 8, "5+"),
                new GradeEntity(font, 9, "6A"),
                new GradeEntity(font, 10, "6A+"),
                new GradeEntity(font, 11, "6B"),
                new GradeEntity(font, 12, "6B+"),
                new GradeEntity(font, 13, "6C"),
                new GradeEntity(font, 14, "6C+"),
                new GradeEntity(font, 15, "7A"),
                new GradeEntity(font, 16, "7A+"),
                new GradeEntity(font, 17, "7B"),
                new GradeEntity(font, 18, "7B+"),
                new GradeEntity(font, 19, "7C"),
                new GradeEntity(font, 20, "7C+"),
                new GradeEntity(font, 21, "8A"),
                new GradeEntity(font, 22, "8A+"),
                new GradeEntity(font, 23, "8B"),
                new GradeEntity(font, 24, "8B+"),
                new GradeEntity(font, 25, "8C"),
                new GradeEntity(font, 26, "8C+")
        ));
    }

    @Test
    public void getAll_with_str_param_should_return_all_grades_of_a_system() {
        dbSetupTracker.skipNextLaunch();
        List<GradeEntity> actual = service.getAll("COLOR");
        GradeSystemEntity system = new GradeSystemEntity("COLOR");
        assertEquals(actual, Lists.newArrayList(
                new GradeEntity(system, 1, "yellow"),
                new GradeEntity(system, 2, "green"),
                new GradeEntity(system, 3, "blue"),
                new GradeEntity(system, 4, "red"),
                new GradeEntity(system, 5, "black"),
                new GradeEntity(system, 6, "purple")
        ));
    }

}