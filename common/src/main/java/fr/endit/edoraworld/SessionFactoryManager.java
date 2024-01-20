package fr.endit.edoraworld;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import dev.architectury.platform.Platform;

public class SessionFactoryManager {
    private static SessionFactoryManager instance;

    private SessionFactory sessionFactory;

    private SessionFactoryManager() {

        System.out.println(org.h2.Driver.class.getTypeName());

        try {
            sessionFactory = new Configuration()
                    .setProperty(AvailableSettings.URL,
                            "jdbc:h2:file:" + Platform.getConfigFolder().toString()
                                    + EdoraWorld.MOD_ID + ".db")
                    .setProperty(AvailableSettings.DRIVER, org.h2.Driver.class.getTypeName())
                    .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
                    .setProperty(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread")

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
