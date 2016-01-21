package a.m.a;

import a.m.a.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateFactory {

    private final static Logger LOGGER = Logger.getLogger(HibernateFactory.class);

    private static SessionFactory factory;

    private HibernateFactory() {
    }

    public synchronized static SessionFactory getSessionFactory() {
        if (factory == null) {
            try {
                LOGGER.info("Initiating session factory");
                factory = initConfig()
                        .configure()
                        .buildSessionFactory();
            } catch (HibernateException e) {
                LOGGER.error("Failed to initiate session factory");
                throw e;
            }
        }
        return factory;
    }

    private static Configuration initConfig() {
        Configuration conf = new Configuration();
        //TODO do this automatically
        conf.addAnnotatedClass(AttemptEntity.class);
        conf.addAnnotatedClass(CragEntity.class);
        conf.addAnnotatedClass(GradeEntity.class);
        conf.addAnnotatedClass(GradeSystemEntity.class);
        conf.addAnnotatedClass(RouteEntity.class);
        return conf;
    }

}
