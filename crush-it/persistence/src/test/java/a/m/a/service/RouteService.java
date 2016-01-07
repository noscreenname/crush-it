package a.m.a.service;

import a.m.a.Crag;
import a.m.a.HibernateFactory;
import a.m.a.Route;
import a.m.a.entity.RouteEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public final class RouteService {

    public List<Route> getAll() {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(RouteEntity.class).list();
            tx.commit();
            return convertToRoutes(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    public List<Route> getAll(@Nonnull Crag crag) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(RouteEntity.class, "route")
                    .createAlias("route.crag", "crag")
                    .add(Restrictions.eq("crag.name", crag.getName()))
                    .list();
            tx.commit();
            return convertToRoutes(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Nonnull
    private List<Route> convertToRoutes(@Nonnull List entities) {
        List<Route> routes = new ArrayList<>(entities.size());
        for (Object entity : entities) {
            routes.add(RouteEntity.toRoute(entity));
        }
        return routes;
    }
}
