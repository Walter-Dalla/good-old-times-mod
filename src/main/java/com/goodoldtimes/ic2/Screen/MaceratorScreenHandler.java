package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class MaceratorScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public static final int PROGRESS_ARROW_SIZE_DEFAULT = 26;
    public static final int PROGRESS_BOLT_SIZE_DEFAULT = 14;
    public MaceratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(MaceratorBlockEntity.PROPERTY_DELEGATE_SIZE));
    }

    public MaceratorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandler.MACERATOR_SCREEN_HANDLER, syncId);
        checkSize(inventory, 3);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        this.addSlot(new Slot(inventory, 0, 56, 17));
        this.addSlot(new Slot(inventory, 1, 116, 35));
        this.addSlot(new Slot(inventory, 2, 56, 53));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(MaceratorBlockEntity.PROGRESS_INDEX_PROPERTY_DELEGATE);
        int maxProgress = this.propertyDelegate.get(MaceratorBlockEntity.MAX_PROGRESS_INDEX_PROPERTY_DELEGATE);


        return scaleProperty(progress, maxProgress, PROGRESS_ARROW_SIZE_DEFAULT);
    }


    public int getScaledEnergy() {
        int energy = this.propertyDelegate.get(MaceratorBlockEntity.ENERGY_INDEX_PROPERTY_DELEGATE);
        int maxEnergy = this.propertyDelegate.get(MaceratorBlockEntity.MAX_ENERGY_INDEX_PROPERTY_DELEGATE);

        return scaleProperty(energy, maxEnergy, PROGRESS_BOLT_SIZE_DEFAULT);
    }

    private int scaleProperty(int propertyValue, int maxPropertyValue, int size){
        return maxPropertyValue != 0 && propertyValue != 0 ? propertyValue * size / maxPropertyValue : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }


    // Helpers
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
