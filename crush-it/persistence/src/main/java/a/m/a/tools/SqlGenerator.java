package a.m.a.tools;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.Properties;

public final class SqlGenerator {

    public static void main(String[] args) {
        Configuration config = new Configuration();

        Properties properties = new Properties();

        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:2101/crushit-dev");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.show_sql", "true");
        config.setProperties(properties);

//        config.addAnnotatedClass(MyMappedPojo1.class);
//        config.addAnnotatedClass(MyMappedPojo2.class);

        SchemaExport schemaExport = new SchemaExport(config);
        schemaExport.setDelimiter(";");

        /**Just dump the schema SQLs to the console , but not execute them ***/
        schemaExport.create(true, false);
    }
}
