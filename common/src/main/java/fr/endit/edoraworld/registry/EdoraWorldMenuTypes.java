package fr.endit.edoraworld.registry;

import dev.architectury.registry.registries.DeferredRegister;
import fr.endit.edoraworld.EdoraWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

public class EdoraWorldMenuTypes {
        public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(EdoraWorld.MOD_ID,
                        Registries.MENU);
}
