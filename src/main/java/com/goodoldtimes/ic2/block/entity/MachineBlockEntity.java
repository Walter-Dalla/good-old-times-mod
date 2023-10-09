package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.Block.Entity.ImplementedInventory;
import com.goodoldtimes.ic2.Crafts.ParentMachineCrafts;
import com.goodoldtimes.ic2.config.MachineBlockEntityProcessData;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MachineBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    public static final int PROPERTY_DELEGATE_SIZE = 4;

    protected MachineBlockEntityProcessData machineBlockEntityProcessData;

    protected final int INPUT_SLOT = 0;
    protected final int OUTPUT_SLOT = 1;
    protected final int ENERGY_SLOT = 2;

    public static final int PROGRESS_INDEX_PROPERTY_DELEGATE = 0;
    public static final int MAX_PROGRESS_INDEX_PROPERTY_DELEGATE = 1;
    public static final int ENERGY_INDEX_PROPERTY_DELEGATE = 2;
    public static final int MAX_ENERGY_INDEX_PROPERTY_DELEGATE = 3;

    public String BLOCK_ID = "machine_block_entity";

    private static List<Item> GetValidCraftIngredients(MachineBlockEntity entity){

        var craftsForEntity = CRAFTS.get(entity.BLOCK_ID);

        return new ArrayList<>(
                craftsForEntity.keySet()
        );
    }
    public static HashMap<String, HashMap<Item, Item>> CRAFTS = new HashMap<>();

    public MachineBlockEntity(BlockPos pos, BlockState state, HashMap<Item, Item> crafts, MachineBlockEntityProcessData processData,
                              BlockEntityType<?> modBlockEntity, String blockId) {
        super(modBlockEntity, pos, state);

        machineBlockEntityProcessData = processData;
        BLOCK_ID = blockId;
        CRAFTS.put(blockId, crafts);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case PROGRESS_INDEX_PROPERTY_DELEGATE -> MachineBlockEntity.this.machineBlockEntityProcessData.getProgressNbt();
                    case MAX_PROGRESS_INDEX_PROPERTY_DELEGATE -> MachineBlockEntity.this.machineBlockEntityProcessData.getMaxProgress();
                    case ENERGY_INDEX_PROPERTY_DELEGATE -> MachineBlockEntity.this.machineBlockEntityProcessData.getEnergyNbt();
                    case MAX_ENERGY_INDEX_PROPERTY_DELEGATE -> MachineBlockEntity.this.machineBlockEntityProcessData.getMaxEnergy();
                    default -> throw new IndexOutOfBoundsException(BLOCK_ID + ":propertyDelegate");
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_INDEX_PROPERTY_DELEGATE:
                        MachineBlockEntity.this.machineBlockEntityProcessData.setProgressNbt(value);
                        break;
                    case MAX_PROGRESS_INDEX_PROPERTY_DELEGATE:
                        MachineBlockEntity.this.machineBlockEntityProcessData.setMaxProgress(value);
                        break;
                    case ENERGY_INDEX_PROPERTY_DELEGATE:
                        MachineBlockEntity.this.machineBlockEntityProcessData.setEnergyNbt(value);
                        break;
                    case MAX_ENERGY_INDEX_PROPERTY_DELEGATE:
                        MachineBlockEntity.this.machineBlockEntityProcessData.setMaxEnergy(value);
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

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return null;
    }
    public static void tick(World world, BlockPos blockPos, BlockState blockState, MachineBlockEntity entity) {
        if(world.isClient()){
            return;
        }

        tickBlock(world, blockPos, blockState, entity);
    }

    protected static void tickBlock(World world, BlockPos blockPos, BlockState blockState, MachineBlockEntity entity){
        var maskDirtyFlag = false;

        var energyValue = HasNewFuel(entity);
        var canAddFuel = CanAddFuel(entity, energyValue);
        if(canAddFuel){
            addFuel(entity, energyValue);
            maskDirtyFlag = true;
        }

        var outputItem = HasRecipe(entity);

        if(outputItem != null){
            if(entity.machineBlockEntityProcessData.getProgressNbt() >= entity.machineBlockEntityProcessData.getMaxProgress()){
                craftItem(entity, outputItem);
                entity.resetProgress(entity);
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

    protected static boolean CanAddFuel(MachineBlockEntity entity, Integer energyValue) {
        if(energyValue == null){
            return false;
        }

        return entity.machineBlockEntityProcessData.getMaxEnergy() >= entity.machineBlockEntityProcessData.getEnergyNbt() + energyValue;
    }

    protected static Integer HasNewFuel(MachineBlockEntity entity){
        var needFuel = entity.machineBlockEntityProcessData.getEnergyNbt() < entity.machineBlockEntityProcessData.getMaxEnergy();

        if(!needFuel) {
            return null;
        }

        var itemOnEnergySlot = entity.getStack(entity.ENERGY_SLOT).getItem();

        for(var energyItem: ParentMachineCrafts.GetValidEnergyIngredient()){
            if(itemOnEnergySlot == energyItem){
                return ParentMachineCrafts.GetItemToEnergyConvertor(itemOnEnergySlot);
            }
        }

        return null;
    }

    private static boolean HasEnergy(MachineBlockEntity entity){
        return entity.machineBlockEntityProcessData.getEnergyNbt() <= 0;
    }
    private static void MakeProgress(MachineBlockEntity entity){
        entity.machineBlockEntityProcessData.increaseProgress(1);

    }

    private static void ConsumeEnergy(MachineBlockEntity entity){
        entity.machineBlockEntityProcessData.increaseEnergy(
            -entity.machineBlockEntityProcessData.getEnergyPerTickOnCrafting()
        );
    }



    protected static void addFuel(MachineBlockEntity entity, Integer energyValue){
        entity.removeStack(entity.ENERGY_SLOT, 1);
        entity.machineBlockEntityProcessData.increaseEnergy(energyValue);
    }

    private void resetProgress(MachineBlockEntity entity){
        entity.machineBlockEntityProcessData.setProgressNbt(0);
    }
    private static void craftItem(MachineBlockEntity entity, Item outputItem) {

        entity.removeStack(entity.INPUT_SLOT, 1);
        entity.setStack(entity.OUTPUT_SLOT, new ItemStack(outputItem, entity.getStack(1).getCount() + 1));

    }

    private static Item HasRecipe(MachineBlockEntity entity){
        var inputItem = HasCraftIngredientItemInSlot(entity, entity.INPUT_SLOT);

        var crafts = entity.CRAFTS.getOrDefault(entity.BLOCK_ID, null);
        if(crafts == null){
            return null;
        }

        var outputItem = crafts.getOrDefault(inputItem, null);

        var canInsertAmountIntoOutputSlot = CanInsertAmountIntoOutputSlot(entity);
        var canInsertItemIntoOutputSlot = CanInsertItemIntoOutputSlot(entity, outputItem);

        if(outputItem != null
                && canInsertAmountIntoOutputSlot
                && canInsertItemIntoOutputSlot){

            return outputItem;
        }

        return null;
    }

    private static Item HasCraftIngredientItemInSlot(MachineBlockEntity entity, int craftSlotIndex){
        Item inputItem = null;
        for(var validItem : entity.GetValidCraftIngredients(entity)){

            if(entity.getStack(craftSlotIndex).getItem() == validItem){
                inputItem = validItem;
                break;
            }
        }

        return inputItem;
    }

    private static boolean CanInsertAmountIntoOutputSlot(MachineBlockEntity entity) {

        return entity.getStack(entity.OUTPUT_SLOT).getMaxCount() > entity.getStack(entity.OUTPUT_SLOT).getCount();
    }

    private static boolean CanInsertItemIntoOutputSlot(MachineBlockEntity entity, Item output) {
        var itemOnOutputStack = entity.getStack(entity.OUTPUT_SLOT).getItem() ;
        return itemOnOutputStack == output || entity.getStack(entity.OUTPUT_SLOT).isEmpty();
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        var progress_nbt = 0;
        nbt.putInt("machine_block.progress", machineBlockEntityProcessData.getProgressNbt());
        var energy_nbt = 0;
        nbt.putInt("machine_block.energy", machineBlockEntityProcessData.getEnergyNbt());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        Inventories.readNbt(nbt, inventory);

        machineBlockEntityProcessData.setProgressNbt(nbt.getInt("machine_block.progress"));
        machineBlockEntityProcessData.setEnergyNbt(nbt.getInt("machine_block.energy"));
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
