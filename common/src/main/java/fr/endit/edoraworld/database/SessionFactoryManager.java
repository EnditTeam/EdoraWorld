package fr.endit.edoraworld.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import dev.architectury.platform.Platform;
import fr.endit.edoraworld.EdoraWorld;
import fr.endit.edoraworld.database.entity.Player;

public class SessionFactoryManager {
    private static SessionFactoryManager instance;

    private SessionFactory sessionFactory;

    private SessionFactoryManager() {

        try {
            sessionFactory = new Configuration()
                    .setProperty(AvailableSettings.URL,
                            "jdbc:h2:file:" + Platform.getConfigFolder().toString()
                                    + EdoraWorld.MOD_ID + ".db")
                    .setProperty(AvailableSettings.DRIVER, org.h2.Driver.class.getTypeName())
                    .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
                    .setProperty(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread")

                    .addAnnotatedClass(Player.class)

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