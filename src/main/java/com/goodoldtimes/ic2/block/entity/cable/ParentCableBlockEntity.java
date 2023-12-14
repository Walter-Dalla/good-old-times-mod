package com.goodoldtimes.ic2.block.entity.cable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParentCableBlockEntity extends BlockEntity {
    public String BLOCK_ID;

    public ParentCableBlockEntity(BlockPos pos, BlockState state,
                              BlockEntityType<?> modBlockEntity, String blockId) {
        super(modBlockEntity, pos, state);

        BLOCK_ID = blockId;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, ParentCableBlockEntity entity) {
        if(world.isClient()){
            return;
        }

        tickBlock(world, blockPos, blockState, entity);
    }

    private static void tickBlock(World world, BlockPos blockPos, BlockState blockState, ParentCableBlockEntity entity) {
        var maskDirtyFlag = false;

         if(maskDirtyFlag) {
             markDirty(world, blockPos, blockState);
         }
    }
}
