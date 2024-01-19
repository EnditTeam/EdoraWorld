package fr.endit.edoraworld;

import fr.endit.edoraworld.registry.EdoraWorldItems;
import fr.endit.edoraworld.registry.EdoraWorldTabs;

public class EdoraWorld {
    public static final String MOD_ID = "edoraworld";

    public static void init() {
        EdoraWorldTabs.REGISTRY.register();
        EdoraWorldItems.REGISTRY.register();

        SessionFactoryManager.getInstance();
    }
}
