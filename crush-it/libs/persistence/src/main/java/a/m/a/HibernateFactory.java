package a.m.a;

import a.m.a.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateFactory {

    private final static Logger logger = Logger.getLogger(HibernateFactory.class);

    // Initialization-on-demand holder pattern
    private static class Holder {
        private static SessionFactory factory = createSessionFactory();
    }

    private HibernateFactory() {
    }


    public synchronized static SessionFactory getSessionFactory() {
        return Holder.factory;
    }

    public static SessionFactory createSessionFactory() {
        try {
            logger.info("Creating session factory");
            Configuration conf = new Configuration();
            //TODO do this automatically
            conf.addAnnotatedClass(AttemptEntity.class);
            conf.addAnnotatedClass(CragEntity.class);
            conf.addAnnotatedClass(GradeEntity.class);
            conf.addAnnotatedClass(GradeSystemEntity.class);
            conf.addAnnotatedClass(RouteEntity.class);
            return conf.configure().buildSessionFactory();
        } catch (HibernateException e) {
            logger.error("Failed to create session factory");
            throw e;
        }
    }

}
