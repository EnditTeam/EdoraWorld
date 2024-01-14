package fr.endit.edoraworld.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import fr.endit.edoraworld.EdoraWorld;
import fr.endit.edoraworld.item.BackpackItem;
import fr.endit.edoraworld.item.properties.BackpackProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class EdoraWorldItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(EdoraWorld.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> POUCH = REGISTRY.register("pouch",
            () -> new BackpackItem(new Item.Properties().arch$tab(EdoraWorldTabs.ECONOMY).stacksTo(1),
                    new BackpackProperties(9)));

}
