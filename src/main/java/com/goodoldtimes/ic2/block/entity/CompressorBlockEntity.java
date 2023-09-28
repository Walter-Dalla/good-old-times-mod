package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.ic2.Crafts.CompressorCrafts;
import com.goodoldtimes.ic2.Screen.CompressorScreenHandler;
import com.goodoldtimes.ic2.block.Custom.CompressorBlock;
import com.goodoldtimes.ic2.config.MachineBlockEntityProcessData;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class CompressorBlockEntity extends MachineBlockEntity {
    public CompressorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, GetBlockEntityCrafts(), new MachineBlockEntityProcessData(
            0,
                    400,
                    0,
                    800,
                    2),
        CompressorBlock.ENTITY,
        "compressor_block_entity");
}

    protected static HashMap<Item, Item> GetBlockEntityCrafts() {
        return CompressorCrafts.GetCrafts();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CompressorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }


}