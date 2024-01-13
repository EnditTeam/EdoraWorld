package fr.endit.edoraworld.fabric;

import fr.endit.edoraworld.EdoraWorld;
import net.fabricmc.api.ModInitializer;

public class EdoraWorldFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        EdoraWorld.init();
    }
}
