package a.m.a;

import a.m.a.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public final class HibernateFactory {

    private static SessionFactory factory;

//    private final Properties properties = new Properties();

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

//    private void loadProperties(String filePath) throws IOException {
//        properties.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
//    }

    private static Configuration initConfig() {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(AttemptEntity.class);
        conf.addAnnotatedClass(CraigEntity.class);
        conf.addAnnotatedClass(GradeEntity.class);
        conf.addAnnotatedClass(GradeSystemEntity.class);
        conf.addAnnotatedClass(RouteEntity.class);
        conf.addAnnotatedClass(ZoneEntity.class);
        return conf;
    }

}
