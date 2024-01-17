package fr.endit.edoraworld.item;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.architectury.registry.menu.MenuRegistry;
import fr.endit.edoraworld.item.properties.BackpackProperties;
import fr.endit.edoraworld.menu.BackpackMenu;
import fr.endit.edoraworld.registry.EdoraWorldMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
            MenuRegistry.openMenu((ServerPlayer) player, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return backpackItemStack.getDisplayName();
                }

                @Override
                public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
                    return new BackpackMenu(i, inventory, backpackItemStack);
                }
            });
        } else {
            player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
        }

        return InteractionResultHolder.pass(player.getMainHandItem());
    }

}
