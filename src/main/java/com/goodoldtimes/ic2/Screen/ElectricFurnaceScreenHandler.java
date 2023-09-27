package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.Screen.ModScreenHandler;
import com.goodoldtimes.ic2.block.entity.ElectricFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class ElectricFurnaceScreenHandler extends ParentMachineScreenHandler {
    public ElectricFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        super(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE),
                new ArrayPropertyDelegate(
                        ElectricFurnaceBlockEntity.PROPERTY_DELEGATE_SIZE),
                ModScreenHandler.ELECTRIC_FURNACE_SCREEN_HANDLER);
    }

    public ElectricFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(syncId, playerInventory, inventory, delegate, ModScreenHandler.ELECTRIC_FURNACE_SCREEN_HANDLER);
    }
}
