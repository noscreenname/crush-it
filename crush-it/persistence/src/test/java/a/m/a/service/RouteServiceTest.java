package a.m.a.service;

import a.m.a.Crag;
import a.m.a.Grade;
import a.m.a.GradeSystem;
import a.m.a.Route;
import a.m.a.common.CommonOperations;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.testng.Assert.assertEquals;

public class RouteServiceTest {

    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
    private RouteService service;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        Operation operation = sequenceOf(
                CommonOperations.DELETE_ALL,
                CommonOperations.INSERT_ARKOSE_GRADES_AND_ROUTES,
                CommonOperations.INSERT_FONT_GRADES_AND_ROUTES
        );
        DbSetup dbSetup = CommonOperations.createDbSetup(operation);
        dbSetup.launch();
        service = new RouteService();
    }

    @Test
    public void when_get_by_unknown_id_should_return_empty() {
        Optional<Route> actualOpt = service.get(11);
        Assert.assertTrue(actualOpt.isPresent());
        assertEquals(actualOpt, Optional.<Route>empty());
    }

    @Test
    public void getAll_should_return_all_routes() {
        dbSetupTracker.skipNextLaunch();
        assertEquals(service.getAll().size(), 7);
    }

    @Test
    public void getAll_by_crag_should_return_all_routes_of_given_crag() {
        dbSetupTracker.skipNextLaunch();
        Crag arkose = new Crag("Arkose");
        assertEquals(service.getAll(arkose).size(), 4);
    }

    @Test
    public void create_should_add_new_route() {
        //-- GIVEN
        //TODO replace this by an actual gets
        Grade red = new Grade(new GradeSystem("FONT"), 12, "6B+"); //id = 12
        Crag arkose = new Crag("Arkose"); // id = 1
        Route expected = new Route("new route", red, arkose, "A darn fun route!");
        //-- WHEN
        int routeId = service.create(expected.getName(), 12, 1, expected.getDescription());
        //-- THEN
        Optional<Route> actualOpt = service.get(routeId);
        Assert.assertTrue(actualOpt.isPresent());
        assertEquals(actualOpt.get(), expected);
    }

}