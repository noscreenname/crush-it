package a.m.a.service;

import a.m.a.Attempt;
import a.m.a.common.CommonOperations;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
//        dbSetupTracker.skipNextLaunch();
//        assertEquals(service.getAll().size(), 7);
    }

    @Test
    public void getTotalTries_for_route_should_return_sum_of_all_attempt_tries() {
//        dbSetupTracker.skipNextLaunch();
//        Crag arkose = new Crag("Arkose");
//        assertEquals(service.getAll(arkose).size(), 4);
    }

    @Test
    public void create_one_existing_route_should_add_new_attempt() {
//        //-- GIVEN
//        Optional<Route> routeOpt = new RouteService().get(1);
//        assertTrue(routeOpt.isPresent());
//        //-- WHEN
//        int routeId = service.create(expected.getName(), 12, 1, expected.getDescription());
//        //-- THEN
//        Optional<Route> actualOpt = service.get(routeId);
//        Assert.assertTrue(actualOpt.isPresent());
//        assertEquals(actualOpt.get(), expected);
    }
}