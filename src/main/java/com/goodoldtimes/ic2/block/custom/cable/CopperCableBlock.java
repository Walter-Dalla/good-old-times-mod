package com.goodoldtimes.ic2.block.custom.cable;

import com.goodoldtimes.ic2.block.entity.cable.CopperCableBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperCableBlock extends ParentCableBlock {
    public static final String BLOCK_ID = "copper_cable_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new CopperCableBlock(blockSettings()));
    public static final BlockEntityType<CopperCableBlockEntity> ENTITY =
            (BlockEntityType<CopperCableBlockEntity>) registerBlockEntity(BLOCK_ID, BLOCK, CopperCableBlockEntity::new);

    public CopperCableBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }
}
