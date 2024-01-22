package fr.endit.edoraworld;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import fr.endit.edoraworld.dependencyinjection.EdoraWorldBinderModule;
import fr.endit.edoraworld.registry.EdoraWorldItems;
import fr.endit.edoraworld.registry.EdoraWorldTabs;

public class EdoraWorld {
    public static final String MOD_ID = "edoraworld";

    @Inject
    private static EdoraWorldEventListener eventListener;

    public static void init() {
        var module = new EdoraWorldBinderModule();
        module.createInjector();

        EdoraWorldTabs.REGISTRY.register();
        EdoraWorldItems.REGISTRY.register();

        eventListener.register();
    }
}
