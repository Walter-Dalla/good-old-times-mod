package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.ic2.Crafts.MaceratorCrafts;
import com.goodoldtimes.ic2.Screen.MaceratorScreenHandler;
import com.goodoldtimes.ic2.config.MachineBlockEntityProcessData;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;


public class MaceratorBlockEntity extends MachineBlockEntity {

    public static final List<Item> VALID_CRAFT_INGREDIENT = MaceratorCrafts.VALID_CRAFT_INGREDIENT;

    public MaceratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, GetBlockEntityCrafts(), new MachineBlockEntityProcessData(0, 1200, 0, 800, 2));
    }

    protected static HashMap<Item, Item> GetBlockEntityCrafts() {
        return MaceratorCrafts.GetCrafts();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MaceratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

}