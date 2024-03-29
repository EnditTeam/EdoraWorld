package fr.endit.edoraworld.menu;

import org.apache.commons.lang3.NotImplementedException;

import fr.endit.edoraworld.item.BackpackItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BackpackMenu extends AbstractContainerMenu {
    private final ItemStack backpackItemStack;
    private SimpleContainer container;

    public BackpackMenu(int i, Inventory inventory, ItemStack backpackItemStack) {
        super(((BackpackItem) backpackItemStack.getItem()).getBProperties().getMenuType(), i);

        this.backpackItemStack = backpackItemStack;

        if (backpackItemStack.getItem() instanceof BackpackItem) {
            setupBackpack(inventory);
        } else {
            this.removed(inventory.player);
        }
    }

    private void setupBackpack(Inventory playerInventory) {
        ListTag tag = this.backpackItemStack.getOrCreateTag().getList("Inventory", 10);
        this.container = new SimpleContainer(27) {
            @Override
            public void setChanged() {
                backpackItemStack.getOrCreateTag().put("Inventory", toTag(this));
                super.setChanged();
            }
        };

        fromTag(tag, container);

        var menuType = ((BackpackItem) backpackItemStack.getItem()).getBProperties().getMenuType();

        if (menuType == MenuType.GENERIC_9x1) {
            int l;
            int c;
            // Backpack inventory
            for (l = 0; l < 3; ++l) {
                for (c = 0; c < 3; ++c) {
                    this.addSlot(new BackpackSlot(container, c + l * 3, 62 + c * 18, 17 + l * 18));
                }
            }
            // Player inventory
            for (l = 0; l < 3; ++l) {
                for (c = 0; c < 9; ++c) {
                    this.addSlot(new Slot(playerInventory, c + l * 9 + 9, 8 + c * 18, 84 + l * 18));
                }
            }
            // Player Hotbar
            for (c = 0; c < 9; ++c) {
                this.addSlot(new Slot(playerInventory, c, 8 + c * 18, 142));
            }
        } else if (menuType == MenuType.GENERIC_9x3) {
            int l;
            int c;
            // Backpack inventory
            for (l = 0; l < 3; ++l) {
                for (c = 0; c < 9; ++c) {
                    this.addSlot(new BackpackSlot(container, c + l * 9, 8 + c * 18, 18 + l * 18));
                }
            }
            // Player inventory
            for (l = 0; l < 3; ++l) {
                for (c = 0; c < 9; ++c) {
                    this.addSlot(new Slot(playerInventory, c + l * 9 + 9, 8 + c * 18, 84 + l * 18));
                }
            }
            // Player Hotbar
            for (c = 0; c < 9; ++c) {
                this.addSlot(new Slot(playerInventory, c, 8 + c * 18, 142));
            }
        } else if (menuType == MenuType.GENERIC_9x6) {
            int l;
            int c;
            // Backpack inventory
            for (l = 0; l < 6; ++l) {
                for (c = 0; c < 9; ++c) {
                    this.addSlot(new BackpackSlot(container, c + l * 9, 8 + c * 18, 18 + l * 18));
                }
            }
            // Player Hotbar
            for (l = 0; l < 3; ++l) {
                for (c = 0; c < 9; ++c) {
                    this.addSlot(new Slot(playerInventory, c + l * 9 + 9, 8 + c * 18, 140 + l * 18));
                }
            }
            // Player Hotbar
            for (c = 0; c < 9; ++c) {
                this.addSlot(new Slot(playerInventory, c, 8 + c * 18, 198));
            }
        } else {
            throw new NotImplementedException("Backpack menu for " + menuType.toString() + " menuType not implemented");
        }
    };

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(i);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();

            if (i < this.container.getContainerSize()) {
                if (!moveItemStackTo(itemStack2, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(itemStack2, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    public ListTag toTag(SimpleContainer inventory) {
        System.out.println("toTag");
        ListTag tag = new ListTag();

        for (int i = 0; i < container.getContainerSize(); i++) {
            CompoundTag stackTag = new CompoundTag();
            stackTag.putInt("Slot", i);
            stackTag.put("Stack", container.getItem(i).save(new CompoundTag()));
            tag.add(stackTag);
        }

        return tag;
    }

    public void fromTag(ListTag tag, SimpleContainer inventory) {
        System.out.println("fromTag");
        inventory.clearContent();

        tag.forEach(element -> {
            CompoundTag stackTag = (CompoundTag) element;
            int slot = stackTag.getInt("Slot");
            ItemStack stack = ItemStack.of(stackTag.getCompound("Stack"));
            inventory.setItem(slot, stack);
        });
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    private class BackpackSlot extends Slot {
        public BackpackSlot(Container container, int i, int j, int k) {
            super(container, i, j, k);
        }

        @Override
        public boolean mayPlace(ItemStack itemStack) {
            return !(itemStack.getItem() instanceof BackpackItem);
        }
    }

}
