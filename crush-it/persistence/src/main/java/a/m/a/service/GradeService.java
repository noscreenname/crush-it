package a.m.a.service;

import a.m.a.HibernateFactory;
import a.m.a.entity.GradeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GradeService extends BasicServiceImpl<Long, GradeEntity> {

    public GradeService() {
        super(GradeEntity.class);
    }

    @Nonnull
    public List<GradeEntity> getAll(@Nonnull String systemName) {
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(GradeEntity.class, "grade")
                    .createAlias("grade.gradeSystem", "system")
                    .add(Restrictions.eq("system.name", systemName))
                    .addOrder(Order.asc("techValue"))
                    .list();
            tx.commit();
            return castAllOrEmptyList(entities);
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }

    @Nonnull
    public Map<String, List<GradeEntity>> getAllOrdered() {
        Map<String, List<GradeEntity>> grades = new HashMap<>();
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(GradeEntity.class, "grade")
                    .addOrder(Order.asc("gradeSystem"))
                    .addOrder(Order.asc("techValue"))
                    .list();
            tx.commit();
            if (entities == null) {
                return grades;
            }
            for (Object entity : entities) {
                GradeEntity grade = (GradeEntity) entity;
                if (!grades.containsKey(grade.getGradeSystem().getName())) {
                    grades.put(grade.getGradeSystem().getName(), new ArrayList<>());
                }
                grades.get(grade.getGradeSystem().getName()).add(grade);
            }
            return grades;
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }
}
