package a.m.a.service;

import a.m.a.common.CommonOperations;
import a.m.a.entity.AttemptEntity;
import a.m.a.entity.RouteEntity;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Optional;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.testng.Assert.*;

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
        Optional<AttemptEntity> actualOpt = service.get(11L);
        assertFalse(actualOpt.isPresent());
    }

    @Test
    public void getAll_should_return_all_attempts() {
        dbSetupTracker.skipNextLaunch();
        assertEquals(service.getAll().size(), 3);
    }

    @Test
    public void create_new_attempt_on_exiting_route_should_add_new_attempt() {
        Long routeId = 1L;
        Optional<RouteEntity> routeOpt = new RouteService().get(routeId);
        assertTrue(routeOpt.isPresent());
        AttemptEntity expected = new AttemptEntity(routeOpt.get(), LocalDate.now());
        //-- WHEN
        Long attemptId = service.create(expected);
        //-- THEN
        Optional<AttemptEntity> actualOpt = service.get(attemptId);
        assertTrue(actualOpt.isPresent());
        assertEquals(actualOpt.get(), expected);
    }
}