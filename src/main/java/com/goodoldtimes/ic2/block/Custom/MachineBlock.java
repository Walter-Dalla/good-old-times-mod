package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.ic2.block.entity.CompressorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MachineBlock extends ParentMachineBlock  {
    public static final String BLOCK_ID = "machine_block";
    public static final Block BLOCK = registerBlock(BLOCK_ID, new MachineBlock(blockSettings()));
    public MachineBlock(Settings settings) {
        super(settings, BLOCK_ID);
    }
}
