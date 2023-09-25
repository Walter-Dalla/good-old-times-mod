package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class MaceratorScreenHandler extends ParentMachineScreenHandler {
    public MaceratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        super(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE), new ArrayPropertyDelegate(MaceratorBlockEntity.PROPERTY_DELEGATE_SIZE), ModScreenHandler.MACERATOR_SCREEN_HANDLER);
    }

    public MaceratorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(syncId, playerInventory, inventory, delegate, ModScreenHandler.MACERATOR_SCREEN_HANDLER);
    }
}
