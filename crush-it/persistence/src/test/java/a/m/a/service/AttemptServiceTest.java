package a.m.a.service;

import a.m.a.*;
import a.m.a.common.CommonOperations;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AttemptServiceTest {

    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
    private AttemptService service;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Operation operation = sequenceOf(
                CommonOperations.DELETE_ALL,
                CommonOperations.INSERT_ARKOSE_ATTEMPTS
        );
        DbSetup dbSetup = CommonOperations.createDbSetup(operation);
        dbSetup.launch();
        service = new AttemptService();
    }

    @Test
    public void when_get_by_unknown_id_should_return_empty() {
        dbSetupTracker.skipNextLaunch();
        Optional<Attempt> actualOpt = service.get(11);
        assertFalse(actualOpt.isPresent());
    }

    @Test
    public void getAll_should_return_all_attempts() {
        dbSetupTracker.skipNextLaunch();
        assertEquals(service.getAll().size(), 3);
    }

    @Test
    public void create_new_attempt_on_exiting_route_should_add_new_attempt() {
        //-- GIVEN
//        Grade red = new Grade(new GradeSystem("FONT"), 12, "6B+"); //id = 12
//        Crag arkose = new Crag("Arkose"); // id = 1
//        Route route = new Route("new route", red, arkose, "A darn fun route!");
        LocalDate date = LocalDate.now();
        int routeId = 1;
        Optional<Route> routeOpt = new RouteService().get(routeId);
        assertTrue(routeOpt.isPresent());
        Attempt expected = new Attempt(routeOpt.get(), date);
        //-- WHEN
        int attemptId = service.create(routeId, date);
        //-- THEN
        Optional<Attempt> actualOpt = service.get(attemptId);
        assertEquals(expected, actualOpt.get());
    }
}