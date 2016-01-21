package a.m.a.service;

import a.m.a.HibernateFactory;
import a.m.a.entity.CragEntity;
import a.m.a.entity.RouteEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Nonnull;
import java.util.List;

public final class RouteService extends BasicServiceImpl<Long, RouteEntity> {

    public RouteService() {
        super(RouteEntity.class);
    }

    @Nonnull
    public List<RouteEntity> getAll(@Nonnull CragEntity crag) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(RouteEntity.class, "route")
                    .createAlias("route.crag", "crag")
                    .add(Restrictions.eq("crag.name", crag.getName()))
                    .list();
            tx.commit();
            return castAllOrEmptyList(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }


}
