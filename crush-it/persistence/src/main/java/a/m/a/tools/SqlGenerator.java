package a.m.a.tools;

import a.m.a.entity.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.io.IOException;
import java.util.Properties;

public final class SqlGenerator {

    private final Properties properties = new Properties();

    private Configuration conf;

    public SqlGenerator() {
    }

    public static void main(String[] args) throws IOException {
        try {
            SqlGenerator generator = new SqlGenerator();
            generator.loadProperties("./hibernate.properties");
            generator.initConfig();
            generator.generate();
        } catch (IOException e) {
            System.out.println("Oops failed loading properties");
            throw e;
        }
    }

    private void loadProperties(String filePath) throws IOException {
        properties.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
    }

    private void initConfig() {
        conf = new Configuration();
        conf.addAnnotatedClass(AttemptEntity.class);
        conf.addAnnotatedClass(CragEntity.class);
        conf.addAnnotatedClass(GradeEntity.class);
        conf.addAnnotatedClass(GradeSystemEntity.class);
        conf.addAnnotatedClass(RouteEntity.class);

    }

    private void generate() {
        // <!> this doesn't work with hibernate 5
        SchemaExport schemaExport = new SchemaExport(conf);
        schemaExport.setDelimiter(";");
        schemaExport.setOutputFile("schema-export.sql");
        schemaExport.create(true, false);
    }

}
