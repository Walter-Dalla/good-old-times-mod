package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.Crafts.ElectricFurnaceCrafts;
import com.goodoldtimes.ic2.Screen.ElectricFurnaceScreenHandler;
import com.goodoldtimes.ic2.config.MachineBlockEntityProcessData;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class ElectricFurnaceBlockEntity extends MachineBlockEntity {
    public ElectricFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, GetBlockEntityCrafts(),
            new MachineBlockEntityProcessData(0,
                400,
                0,
                800,
            2),
            ModBlockEntities.ELECTRIC_FURNACE);
    }

    protected static HashMap<Item, Item> GetBlockEntityCrafts() {
        return ElectricFurnaceCrafts.GetCrafts();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ElectricFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }


}