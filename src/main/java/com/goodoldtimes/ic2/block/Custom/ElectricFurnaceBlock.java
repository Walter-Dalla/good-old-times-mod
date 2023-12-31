package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.ic2.block.entity.ElectricFurnaceBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ElectricFurnaceBlock extends ParentMachineBlock  {
    public static final String BLOCK_ID = "electric_furnace_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new ElectricFurnaceBlock(blockSettings()));
    public static final BlockEntityType<ElectricFurnaceBlockEntity> ENTITY =
            (BlockEntityType<ElectricFurnaceBlockEntity>) registerBlockEntity(BLOCK_ID, BLOCK, ElectricFurnaceBlockEntity::new);
    public ElectricFurnaceBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ENTITY, ElectricFurnaceBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ElectricFurnaceBlockEntity(pos, state);
    }
}
