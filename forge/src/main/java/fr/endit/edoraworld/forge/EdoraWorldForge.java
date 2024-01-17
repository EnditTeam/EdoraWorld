package fr.endit.edoraworld.forge;

import dev.architectury.platform.forge.EventBuses;
import fr.endit.edoraworld.ConfigurationHandler;
import fr.endit.edoraworld.EdoraWorld;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EdoraWorld.MOD_ID)
public class EdoraWorldForge {
    public EdoraWorldForge() {
        EventBuses.registerModEventBus(EdoraWorld.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        ModLoadingContext.get().registerConfig(Type.SERVER, ConfigurationHandler.spec);

        EdoraWorld.init();
    }
}
