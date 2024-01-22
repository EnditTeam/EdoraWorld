package fr.endit.edoraworld.dependencyinjection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.endit.edoraworld.EdoraWorld;

public class EdoraWorldBinderModule extends AbstractModule {
    public EdoraWorldBinderModule() {

    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        requestStaticInjection(EdoraWorld.class);
    }
}
