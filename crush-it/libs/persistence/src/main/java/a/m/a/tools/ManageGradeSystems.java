package a.m.a.tools;

import a.m.a.entity.GradeSystemEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public final class ManageGradeSystems {

    @Nonnull
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure()
                    //addPackage("com.xyz") //add package if used.
                    //                    .addAnnotatedClass(GradeSystemEntity.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Oops");
            throw e;
        }

        ManageGradeSystems manager = new ManageGradeSystems();
        // add FONT
        Integer fontId = manager.add("FONT");

        manager.showAll();
    }

    private void showAll() {
        Session session = factory.openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            List entities = session.createQuery("FROM GradeSystemEntity").list();
            for (Object entity : entities) {
                GradeSystemEntity gs = (GradeSystemEntity) entity;
                System.out.println("Grade System : " + gs.getName());
            }
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Oops !");
            throw e;
        } finally {
            session.close();
        }
    }

    @Nullable
    public Integer add(@Nonnull String name) {
        Session session = factory.openSession();
        Transaction tx;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            GradeSystemEntity entity = new GradeSystemEntity();
            entity.setName(name);
            id = (Integer) session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("oops");
            throw e;
        } finally {
            session.close();
        }
        return id;
    }
}
