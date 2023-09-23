package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.Crafts.MaceratorCrafts;
import com.goodoldtimes.ic2.Screen.MaceratorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MaceratorBlockEntity extends MachineBlockEntity {
    public static final String BLOCK_ID = "macerator_block_entity";

    public static final List<Item> VALID_CRAFT_INGREDIENT = MaceratorCrafts.VALID_CRAFT_INGREDIENT;
    public static final List<Item> VALID_ENERGY_INGREDIENT = MaceratorCrafts.VALID_ENERGY_INGREDIENT;

    public MaceratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, ModBlockEntities.MACERATOR, BLOCK_ID);
    }
}