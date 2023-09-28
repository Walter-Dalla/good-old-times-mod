package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.ic2.block.entity.ExtractorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ExtractorBlock extends ParentMachineBlock  {
    public static final String BLOCK_ID = "extractor_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new ExtractorBlock(blockSettings()));
    public static final BlockEntityType<ExtractorBlockEntity> ENTITY =
            (BlockEntityType<ExtractorBlockEntity>) registerBlockEntity(BLOCK_ID, BLOCK, ExtractorBlockEntity::new);

    public ExtractorBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ExtractorBlock.ENTITY, ExtractorBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ExtractorBlockEntity(pos, state);
    }
}
