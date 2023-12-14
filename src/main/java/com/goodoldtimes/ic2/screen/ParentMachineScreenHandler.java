package com.goodoldtimes.ic2.screen;

import com.goodoldtimes.ic2.block.entity.MachineBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class ParentMachineScreenHandler  extends ScreenHandler {
    protected final Inventory inventory;
    protected final PropertyDelegate propertyDelegate;
    public final int PROGRESS_ARROW_SIZE_DEFAULT = 26;
    public int PROGRESS_BOLT_SIZE_DEFAULT = 14;
    public static final int INVENTORY_SIZE = 3;



    public ParentMachineScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate,
          ScreenHandlerType<?> screenHandler) {
        super(screenHandler, syncId);
        checkSize(inventory, INVENTORY_SIZE);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        addItemSlots(this.inventory);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    protected void addItemSlots(Inventory inventory){
        this.addSlot(new Slot(inventory, 0, 56, 17));
        this.addSlot(new Slot(inventory, 1, 116, 35));
        this.addSlot(new Slot(inventory, 2, 56, 53));
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

    protected int scaleProperty(int propertyValue, int maxPropertyValue, int size){
        return maxPropertyValue != 0 && propertyValue != 0 ? propertyValue * size / maxPropertyValue : 0;
    }

    protected void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    protected void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(MachineBlockEntity.PROGRESS_INDEX_PROPERTY_DELEGATE);
        int maxProgress = this.propertyDelegate.get(MachineBlockEntity.MAX_PROGRESS_INDEX_PROPERTY_DELEGATE);

        return scaleProperty(progress, maxProgress, PROGRESS_ARROW_SIZE_DEFAULT);
    }

    public int getScaledEnergy() {
        int energy = this.propertyDelegate.get(MachineBlockEntity.ENERGY_INDEX_PROPERTY_DELEGATE);
        int maxEnergy = this.propertyDelegate.get(MachineBlockEntity.MAX_ENERGY_INDEX_PROPERTY_DELEGATE);

        return scaleProperty(energy, maxEnergy, PROGRESS_BOLT_SIZE_DEFAULT);
    }
}
