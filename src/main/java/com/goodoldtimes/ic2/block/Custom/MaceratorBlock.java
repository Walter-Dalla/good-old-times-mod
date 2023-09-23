package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaceratorBlock extends MachineParentBlock  {
    public static final String BLOCK_ID = "macerator_block";

    public MaceratorBlock(Settings settings) {
        super(settings, ModBlockEntities.MACERATOR, "macerator_block");
    }
}
