package fr.endit.edoraworld.neoforge;

import fr.endit.edoraworld.ConfigurationHandler;
import fr.endit.edoraworld.EdoraWorld;
import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(EdoraWorld.MOD_ID)
public class EdoraWorldNeoForge {
    public EdoraWorldNeoForge() {
        ForgeConfigRegistry.INSTANCE.register(EdoraWorld.MOD_ID, ModConfig.Type.SERVER, ConfigurationHandler.spec);

        EdoraWorld.init();
    }
}
