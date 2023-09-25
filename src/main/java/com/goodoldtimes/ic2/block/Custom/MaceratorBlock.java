package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MaceratorBlock extends ParentMachineBlock  {
    public static final String BLOCK_ID = "macerator_block";

    public MaceratorBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MaceratorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.MACERATOR, MaceratorBlockEntity::tick);
    }
}
