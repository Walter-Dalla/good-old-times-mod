package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.block.entity.CompressorBlockEntity;
import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CompressorBlock extends ParentMachineBlock  {
    public static final String BLOCK_ID = "compressor_block";

    public CompressorBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.COMPRESSOR, CompressorBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CompressorBlockEntity(pos, state);
    }
}
