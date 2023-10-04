package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.ic2.block.entity.GeneratorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GeneratorBlock extends ParentMachineBlock  {
    public static final String BLOCK_ID = "generator_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new GeneratorBlock(blockSettings()));
    public static final BlockEntityType<GeneratorBlockEntity> ENTITY =
            (BlockEntityType<GeneratorBlockEntity>) registerBlockEntity(BLOCK_ID, BLOCK, GeneratorBlockEntity::new);

    public GeneratorBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, GeneratorBlock.ENTITY, GeneratorBlockEntity::tickGenerator);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GeneratorBlockEntity(pos, state);
    }
}
