package fr.endit.edoraworld.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import fr.endit.edoraworld.EdoraWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EdoraWorldTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(EdoraWorld.MOD_ID,
            Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> ECONOMY = REGISTRY.register("economy_tab",
            () -> CreativeTabRegistry.create(Component.translatable("itemGroup." + EdoraWorld.MOD_ID + ".economy_tab"),
                    () -> new ItemStack(Items.DIAMOND.asItem())));
}
