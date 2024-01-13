package fr.endit.edoraworld.forge;

import dev.architectury.platform.forge.EventBuses;
import fr.endit.edoraworld.EdoraWorld;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EdoraWorld.MOD_ID)
public class EdoraWorldForge {
    public EdoraWorldForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(EdoraWorld.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        EdoraWorld.init();
    }
}
