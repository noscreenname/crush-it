package a.m.a.service;

import a.m.a.Grade;
import a.m.a.HibernateFactory;
import a.m.a.entity.GradeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public final class GradeService {

    public GradeService() {
    }

    @Nonnull
    public List<Grade> getAllGrades(@Nonnull String systemName) {
        List<Grade> result = new ArrayList<>();
        try (Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List entities = session.createCriteria(GradeEntity.class, "grade")
                    .createAlias("grade.gradeSystem", "system")
                    .add(Restrictions.eq("system.name", systemName))
                    .addOrder(Order.desc("techValue"))
                    .list();
            tx.commit();
            for (Object entity : entities) {
                result.add(GradeEntity.toGrade(entity));
            }
            return result;
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        }
    }
}
