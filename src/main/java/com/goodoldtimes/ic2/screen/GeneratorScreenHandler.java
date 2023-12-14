package com.goodoldtimes.ic2.screen;

import com.goodoldtimes.screen.ModScreenHandler;
import com.goodoldtimes.ic2.block.entity.GeneratorBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class GeneratorScreenHandler extends ParentMachineScreenHandler {
    public GeneratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        super(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE),
                new ArrayPropertyDelegate(
                        GeneratorBlockEntity.PROPERTY_DELEGATE_SIZE),
                ModScreenHandler.GENERATOR_SCREEN_HANDLER);
    }

    public GeneratorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(syncId, playerInventory, inventory, delegate, ModScreenHandler.GENERATOR_SCREEN_HANDLER);
    }

    @Override
    protected void addItemSlots(Inventory inventory){
        this.addSlot(new Slot(inventory, 0, 65, 17));
        this.addSlot(new Slot(inventory, 1, 125, 35));
        this.addSlot(new Slot(inventory, 2, 65, 53));
    }
}
