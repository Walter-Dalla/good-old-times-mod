package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.Screen.ModScreenHandler;
import com.goodoldtimes.ic2.block.entity.CompressorBlockEntity;
import com.goodoldtimes.ic2.block.entity.GeneratorBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class GeneratorScreenHandler extends ParentMachineScreenHandler {
    public GeneratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        super(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE),
                new ArrayPropertyDelegate(
                        GeneratorBlockEntity.PROPERTY_DELEGATE_SIZE),
                ModScreenHandler.GENERATOR_SCREEN_HANDLER);
    }

    public GeneratorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(syncId, playerInventory, inventory, delegate, ModScreenHandler.COMPRESSOR_SCREEN_HANDLER);
    }
}
