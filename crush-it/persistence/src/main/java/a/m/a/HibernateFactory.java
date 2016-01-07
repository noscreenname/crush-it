package a.m.a;

import a.m.a.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateFactory {

    private static SessionFactory factory;

    private HibernateFactory() {
    }

    public synchronized static SessionFactory getSessionFactory() {
        if (factory == null) {
            try {
                factory = initConfig()
                        .configure()
                        .buildSessionFactory();
            } catch (Throwable e) {
                System.out.println("Oops");
                throw e;
            }
        }
        return factory;
    }

    private static Configuration initConfig() {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(AttemptEntity.class);
        conf.addAnnotatedClass(CragEntity.class);
        conf.addAnnotatedClass(GradeEntity.class);
        conf.addAnnotatedClass(GradeSystemEntity.class);
        conf.addAnnotatedClass(RouteEntity.class);
        return conf;
    }

}
