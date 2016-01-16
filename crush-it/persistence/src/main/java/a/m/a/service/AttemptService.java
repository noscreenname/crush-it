package a.m.a.service;

import a.m.a.Attempt;
import a.m.a.Crag;
import a.m.a.HibernateFactory;
import a.m.a.entity.AttemptEntity;
import a.m.a.entity.CragEntity;
import a.m.a.entity.GradeEntity;
import a.m.a.entity.RouteEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public final class AttemptService {

    @Nonnull
    public Optional<Attempt> get(int routeId) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            AttemptEntity attemptEntity = session.get(AttemptEntity.class, routeId);
            tx.commit();
            return Optional.ofNullable(AttemptEntity.toAttempt(attemptEntity));
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Nonnull
    public List<Attempt> getAll() {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(RouteEntity.class).list();
            tx.commit();
            return convertToAttempts(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Nonnull
    public List<Attempt> getAll(@Nonnull Crag crag) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(RouteEntity.class, "route")
                    .createAlias("route.crag", "crag")
                    .add(Restrictions.eq("crag.name", crag.getName()))
                    .list();
            tx.commit();
            return convertToAttempts(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    public int create(int routeId, @Nonnull LocalDate date) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            RouteEntity routeEntity = session.get(RouteEntity.class, routeId);
            AttemptEntity attemptEntity = new AttemptEntity();
            attemptEntity.setRoute(routeEntity);
            attemptEntity.setDate(date);
            Serializable id = session.save(attemptEntity);
            tx.commit();
            return (int) id;
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Nonnull
    private List<Attempt> convertToAttempts(@Nullable List entities) {
        if (entities == null) {
            return new ArrayList<>(0);
        }
        List<Attempt> routes = new ArrayList<>(entities.size());
        for (Object entity : entities) {
            routes.add((AttemptEntity.toAttempt((AttemptEntity) entity)));
        }
        return routes;
    }
}
