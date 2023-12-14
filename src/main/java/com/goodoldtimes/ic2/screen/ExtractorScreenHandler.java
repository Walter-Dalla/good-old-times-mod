package com.goodoldtimes.ic2.screen;

import com.goodoldtimes.screen.ModScreenHandler;
import com.goodoldtimes.ic2.block.entity.ExtractorBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class ExtractorScreenHandler extends ParentMachineScreenHandler {
    public ExtractorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        super(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE),
                new ArrayPropertyDelegate(
                        ExtractorBlockEntity.PROPERTY_DELEGATE_SIZE),
                ModScreenHandler.EXTRACTOR_SCREEN_HANDLER);
    }

    public ExtractorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(syncId, playerInventory, inventory, delegate, ModScreenHandler.EXTRACTOR_SCREEN_HANDLER);
    }
}
