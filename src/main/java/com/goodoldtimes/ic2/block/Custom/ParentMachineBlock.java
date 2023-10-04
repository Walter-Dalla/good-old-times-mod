package com.goodoldtimes.ic2.block.Custom;

import com.goodoldtimes.Block.ModBlock;
import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.block.entity.MachineBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ParentMachineBlock extends BlockWithEntity implements BlockEntityProvider {

    public ParentMachineBlock(Settings settings, String blockId) {
        super(settings);
    }

    protected static<T extends BlockEntity> BlockEntityType<?> registerBlockEntity(String blockId, Block block, FabricBlockEntityTypeBuilder.Factory<? extends T> factory){
        return Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier(GoodOldTimesMod.MOD_ID, blockId+"_entity"),
                    FabricBlockEntityTypeBuilder.create(factory,
                            block)
                        .build(null)
        );
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    /* BLOCK ENTITY */

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved){
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MachineBlockEntity) {
                ItemScatterer.spawn(world, pos, (MachineBlockEntity)blockEntity);
                // update comparators
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }



    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((MachineBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    protected static FabricBlockSettings blockSettings(){
        return FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque();
    }

    public static Block registerBlock(String blockId, Block block){
        return ModBlock.registerBlock(blockId, block);
    }
}
