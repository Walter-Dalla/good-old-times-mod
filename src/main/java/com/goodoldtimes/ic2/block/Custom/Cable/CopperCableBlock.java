package com.goodoldtimes.ic2.block.Custom.Cable;

import com.goodoldtimes.ic2.block.Custom.ParentMachineBlock;
import com.goodoldtimes.ic2.block.entity.Cable.CopperCableBlockEntity;
import com.goodoldtimes.ic2.block.entity.MachineBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CopperCableBlock extends ParentMachineBlock {
    public static final String BLOCK_ID = "copper_cable_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new CopperCableBlock(blockSettings()));
    public static final BlockEntityType<CopperCableBlockEntity> ENTITY =
            (BlockEntityType<CopperCableBlockEntity>) registerBlockEntity(BLOCK_ID, BLOCK, CopperCableBlockEntity::new);

    public CopperCableBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, CopperCableBlock.ENTITY, CopperCableBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperCableBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }
}
