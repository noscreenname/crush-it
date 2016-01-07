package a.m.a.service;

import a.m.a.Crag;
import a.m.a.common.CommonOperations;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    }

}