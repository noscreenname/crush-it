package a.m.a.service;

import a.m.a.common.CommonOperations;
import a.m.a.Grade;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.List;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

public class GradeServiceTest {

    @Nonnull
    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();

    @BeforeMethod
    public void prepare() throws Exception {
        Operation operation = sequenceOf(
                CommonOperations.DELETE_ALL, CommonOperations.INSERT_COLOR_GRADES);
        DbSetup dbSetup = new DbSetup(
                new DriverManagerDestination(
                        "jdbc:postgresql://localhost:5432/crushit-test", "postgres", "root"), operation);
        dbSetup.launch();
    }

    @Test
    public void testGetAll() {
        dbSetupTracker.skipNextLaunch();
        GradeService service = new GradeService();
        List<Grade> actual = service.getAllGrades("COLOR");
        Assert.assertEquals(actual.size(), 6);
    }
}