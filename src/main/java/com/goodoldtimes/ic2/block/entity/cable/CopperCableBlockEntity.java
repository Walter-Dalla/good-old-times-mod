package com.goodoldtimes.ic2.block.entity.cable;

import com.goodoldtimes.ic2.block.custom.cable.CopperCableBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;


public class CopperCableBlockEntity extends ParentCableBlockEntity {
    public CopperCableBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state,
        CopperCableBlock.ENTITY,
        "copper_block_entity");
    }
}