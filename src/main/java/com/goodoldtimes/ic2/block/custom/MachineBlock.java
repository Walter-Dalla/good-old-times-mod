package com.goodoldtimes.ic2.block.custom;

import com.goodoldtimes.block.ParentBlock;
import net.minecraft.block.Block;

public class MachineBlock extends ParentBlock {
    public static final String BLOCK_ID = "machine_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new MachineBlock(blockSettings()));
    public MachineBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }
}
