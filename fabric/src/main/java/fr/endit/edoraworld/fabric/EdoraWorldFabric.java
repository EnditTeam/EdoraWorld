package fr.endit.edoraworld.fabric;

import fr.endit.edoraworld.ConfigurationHandler;
import fr.endit.edoraworld.EdoraWorld;
import fuzs.forgeconfigapiport.fabric.api.forge.v4.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;

public class EdoraWorldFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(EdoraWorld.MOD_ID, ModConfig.Type.SERVER, ConfigurationHandler.spec);

        EdoraWorld.init();
    }
}
