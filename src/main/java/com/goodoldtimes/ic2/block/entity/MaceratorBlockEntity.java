package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.Block.Entity.ImplementedInventory;
import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.Crafts.MaceratorCrafts;
import com.goodoldtimes.ic2.Screen.MaceratorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceManager;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MaceratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    public static final int PROPERTY_DELEGATE_SIZE = 4;
    private int progress_nbt = 0;
    private int maxProgress = 20;
    private int energy_nbt = 0;
    private int maxEnergy = 100;


    protected final int INPUT_SLOT = 0;
    protected final int OUTPUT_SLOT = 1;
    protected final int ENERGY_SLOT = 2;

    public static final int PROGRESS_INDEX_PROPERTY_DELEGATE = 0;
    public static final int MAX_PROGRESS_INDEX_PROPERTY_DELEGATE = 1;
    public static final int ENERGY_INDEX_PROPERTY_DELEGATE = 2;
    public static final int MAX_ENERGY_INDEX_PROPERTY_DELEGATE = 3;

    public static final String BLOCK_ID = "macerator_block_entity";

    public static final List<Item> VALID_CRAFT_INGREDIENT = MaceratorCrafts.VALID_CRAFT_INGREDIENT;
    public static final List<Item> VALID_ENERGY_INGREDIENT = MaceratorCrafts.VALID_ENERGY_INGREDIENT;

    public MaceratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MACERATOR, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case PROGRESS_INDEX_PROPERTY_DELEGATE -> MaceratorBlockEntity.this.progress_nbt;
                    case MAX_PROGRESS_INDEX_PROPERTY_DELEGATE -> MaceratorBlockEntity.this.maxProgress;
                    case ENERGY_INDEX_PROPERTY_DELEGATE -> MaceratorBlockEntity.this.energy_nbt;
                    case MAX_ENERGY_INDEX_PROPERTY_DELEGATE -> MaceratorBlockEntity.this.maxEnergy;
                    default -> throw new IndexOutOfBoundsException(BLOCK_ID + ":propertyDelegate");
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_INDEX_PROPERTY_DELEGATE:
                        MaceratorBlockEntity.this.progress_nbt = value;
                        break;
                    case MAX_PROGRESS_INDEX_PROPERTY_DELEGATE:
                        MaceratorBlockEntity.this.maxProgress = value;
                        break;
                    case ENERGY_INDEX_PROPERTY_DELEGATE:
                        MaceratorBlockEntity.this.energy_nbt = value;
                        break;
                    case MAX_ENERGY_INDEX_PROPERTY_DELEGATE:
                        MaceratorBlockEntity.this.maxEnergy = value;
                        break;
                    default:
                        throw new IndexOutOfBoundsException(BLOCK_ID + ":propertyDelegate");
                }
            }

            public int size() {
                return PROPERTY_DELEGATE_SIZE;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MaceratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, MaceratorBlockEntity entity) {
        if(world.isClient()){
            return;
        }

        tickBlock(world, blockPos, blockState, entity);
    }

    private static void tickBlock(World world, BlockPos blockPos, BlockState blockState, MaceratorBlockEntity entity){
        var maskDirtyFlag = false;

        if(hasNewFuel(entity)){
            addFuel(entity);
            maskDirtyFlag = true;
        }

        var outputItem = hasRecipe(entity);

        if(outputItem != null){
            if(entity.progress_nbt >= entity.maxProgress){
                craftItem(entity, outputItem);
                entity.resetProgress();
            }
            else {
                if(HasEnergy(entity)){
                    return;
                }

                MakeProgress(entity);
                ConsumeEnergy(entity);
            }

            maskDirtyFlag = true;
        }

        if(maskDirtyFlag){
            markDirty(world, blockPos, blockState);
        }
    }
    private static boolean HasEnergy(MaceratorBlockEntity entity){
        return entity.energy_nbt <= 0;
    }
    private static void MakeProgress(MaceratorBlockEntity entity){
        entity.progress_nbt++;
    }

    private static void ConsumeEnergy(MaceratorBlockEntity entity){
        entity.energy_nbt--;
    }



    private static void addFuel(MaceratorBlockEntity entity){
        entity.removeStack(entity.ENERGY_SLOT, 1);
        entity.energy_nbt++;
    }

    private void resetProgress(){
        progress_nbt = 0;
    }
    private static void craftItem(MaceratorBlockEntity entity, Item outputItem){

        entity.removeStack(entity.INPUT_SLOT, 1);
        entity.setStack(entity.OUTPUT_SLOT, new ItemStack(outputItem, entity.getStack(1).getCount()+1));

    }
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("MOD_ID");
    private static Item hasRecipe(MaceratorBlockEntity entity){
        var inputItem = hasCraftIngredientItemInSlot(entity, entity.INPUT_SLOT);

        var outputItem = MaceratorCrafts.GetCrafts().getOrDefault(inputItem, null);

        if(outputItem == null &&
                canInsertAmountIntoOutputSlot(entity) && canInsertItemIntoOutputSlot(entity, outputItem)){
            return null;
        }

        return outputItem;
    }

    private static boolean hasNewFuel(MaceratorBlockEntity entity){
        var needFuel = entity.energy_nbt < entity.maxEnergy;
        if(!needFuel){
            return false;
        }

        var hasValidFuel = false;
        for(var energyItem: entity.VALID_ENERGY_INGREDIENT){
            if(energyItem == entity.getStack(entity.ENERGY_SLOT).getItem()){
                hasValidFuel = true;
                break;
            }
        }

        return hasValidFuel;
    }

    private static Item hasCraftIngredientItemInSlot(MaceratorBlockEntity entity, int craftSlotIndex){
        Item outputItem = null;

        for(var validItem : entity.VALID_CRAFT_INGREDIENT){
            if(entity.getStack(craftSlotIndex).getItem() == validItem){
                outputItem = validItem;
                break;
            }
        }

        return outputItem;
    }

    private static boolean canInsertAmountIntoOutputSlot(MaceratorBlockEntity entity) {

        return entity.getStack(entity.OUTPUT_SLOT).getMaxCount() > entity.getStack(entity.OUTPUT_SLOT).getCount();
    }

    private static boolean canInsertItemIntoOutputSlot(MaceratorBlockEntity entity, Item output) {
        return entity.getStack(entity.OUTPUT_SLOT).getItem() == output || entity.getStack(entity.OUTPUT_SLOT).isEmpty();
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("macerator_block.progress", progress_nbt);
        nbt.putInt("macerator_block.energy", energy_nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress_nbt = nbt.getInt("macerator_block.progress");
        energy_nbt = nbt.getInt("macerator_block.energy");

    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}