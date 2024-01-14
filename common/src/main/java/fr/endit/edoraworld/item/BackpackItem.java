package fr.endit.edoraworld.item;

import fr.endit.edoraworld.item.properties.BackpackProperties;
import fr.endit.edoraworld.menu.BackpackMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BackpackItem extends Item {
    private BackpackProperties bProperties;
    private ItemStack backpackItemStack;

    public BackpackItem(Properties properties, BackpackProperties bProperties) {
        super(properties);
        this.bProperties = bProperties;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        backpackItemStack = player.getItemInHand(interactionHand);

        if (!level.isClientSide) {
            player.openMenu(new MenuProvider() {
                @Override
                public AbstractContainerMenu createMenu(int i, Inventory inventory, Player arg2) {
                    return new BackpackMenu(i, inventory);
                }

                @Override
                public Component getDisplayName() {
                    return Component.translatable("meow");
                }
            });
        } else {
            player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
        }

        return InteractionResultHolder.pass(player.getMainHandItem());
    }

}
