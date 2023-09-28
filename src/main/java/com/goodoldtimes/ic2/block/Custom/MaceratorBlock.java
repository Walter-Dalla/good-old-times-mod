package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MaceratorBlock extends ParentMachineBlock {
    public static final String BLOCK_ID = "macerator_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new MaceratorBlock(blockSettings()));
    public static final BlockEntityType<MaceratorBlockEntity> ENTITY =
            (BlockEntityType<MaceratorBlockEntity>) registerBlockEntity(BLOCK_ID, BLOCK, MaceratorBlockEntity::new);
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
        return checkType(type, ENTITY, MaceratorBlockEntity::tick);
    }
}
