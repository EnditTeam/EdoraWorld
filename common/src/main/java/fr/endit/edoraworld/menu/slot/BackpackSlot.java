package fr.endit.edoraworld.menu.slot;

import fr.endit.edoraworld.item.BackpackItem;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BackpackSlot extends Slot {
    public BackpackSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return !(itemStack.getItem() instanceof BackpackItem);
    }
}
