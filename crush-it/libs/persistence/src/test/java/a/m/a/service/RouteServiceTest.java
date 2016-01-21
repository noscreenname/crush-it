package a.m.a.service;

import a.m.a.common.CommonOperations;
import a.m.a.entity.CragEntity;
import a.m.a.entity.GradeEntity;
import a.m.a.entity.RouteEntity;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.operation.Operation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        Optional<RouteEntity> actualOpt = service.get(11L);
        Assert.assertFalse(actualOpt.isPresent());
    }

    @Test
    public void getAll_should_return_all_routes() {
        dbSetupTracker.skipNextLaunch();
        assertEquals(service.getAll().size(), 7);
    }

    @Test
    public void getAll_by_crag_should_return_all_routes_of_given_crag() {
        dbSetupTracker.skipNextLaunch();
        CragEntity arkose = new CragEntity("Arkose");
        assertEquals(service.getAll(arkose).size(), 4);
    }

    @Test
    public void create_should_add_new_route() {
        //-- GIVEN
        Optional<GradeEntity> gradeOpt = new GradeService().get(12L);
        assertTrue(gradeOpt.isPresent());
        Optional<CragEntity> cragOpt = new CragService().get(1L);
        assertTrue(cragOpt.isPresent());
        RouteEntity expected = new RouteEntity("new route", gradeOpt.get(), cragOpt.get(), "A darn fun route!");
        //-- WHEN
        Long routeId = service.create(expected);
        //-- THEN
        Optional<RouteEntity> actualOpt = service.get(routeId);
        Assert.assertTrue(actualOpt.isPresent());
        assertEquals(actualOpt.get(), expected);
    }

}