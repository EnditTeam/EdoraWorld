package fr.endit.edoraworld;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

import dev.architectury.platform.Platform;
import fr.endit.edoraworld.model.Animal;
import fr.endit.edoraworld.model.Species;

public class SessionFactoryManager {
    private static SessionFactoryManager instance;

    private SessionFactory sessionFactory;

    private SessionFactoryManager() {

        try {
            sessionFactory = new Configuration()
                    /*
                     * .setProperty(AvailableSettings.JAKARTA_JDBC_DRIVER,
                     * org.h2.Driver.class.getTypeName())
                     * .setProperty(AvailableSettings.JAKARTA_JDBC_URL,
                     * "jdbc:h2:file:" + Platform.getConfigFolder().toString() +
                     * EdoraWorld.MOD_ID +
                     * ".db;DB_CLOSE_DELAY=-1")
                     */
                    .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/databasetable")
                    .setProperty(AvailableSettings.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver")
                    .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
                    .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "miaou")
                    .setProperty(AvailableSettings.HBM2DDL_AUTO, Action.UPDATE.name())
                    .setProperty(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread")

                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(Species.class)

                    .buildSessionFactory();

        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    public static SessionFactoryManager getInstance() {
        if (instance == null) {
            instance = new SessionFactoryManager();
        }

        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
