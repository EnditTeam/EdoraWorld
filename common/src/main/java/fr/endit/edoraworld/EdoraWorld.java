package fr.endit.edoraworld;

import fr.endit.edoraworld.dao.AnimalDao;
import fr.endit.edoraworld.dao.SpeciesDao;
import fr.endit.edoraworld.model.Species;
import fr.endit.edoraworld.registry.EdoraWorldItems;
import fr.endit.edoraworld.registry.EdoraWorldTabs;

public class EdoraWorld {
    public static final String MOD_ID = "edoraworld";

    public static void init() {
        EdoraWorldTabs.REGISTRY.register();
        EdoraWorldItems.REGISTRY.register();

        SessionFactoryManager.getInstance();

        System.out.println("BITE COUILLE CACA");

        var speciesDao = new SpeciesDao();

        speciesDao.create(new Species("Chat"));
    }
}
