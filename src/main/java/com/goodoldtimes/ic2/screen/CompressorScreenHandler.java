package com.goodoldtimes.ic2.screen;

import com.goodoldtimes.screen.ModScreenHandler;
import com.goodoldtimes.ic2.block.entity.CompressorBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class CompressorScreenHandler extends ParentMachineScreenHandler {
    public CompressorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        super(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE),
                new ArrayPropertyDelegate(
                        CompressorBlockEntity.PROPERTY_DELEGATE_SIZE),
                ModScreenHandler.COMPRESSOR_SCREEN_HANDLER);
    }

    public CompressorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(syncId, playerInventory, inventory, delegate, ModScreenHandler.COMPRESSOR_SCREEN_HANDLER);

        PROGRESS_BOLT_SIZE_DEFAULT = 17;
    }
}
