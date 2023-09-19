package com.goodoldtimes.ic2.block.machine;

import com.goodoldtimes.Block.Entity.ImplementedInventory;
import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.Screen.MaceneratorScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.inventory.Inventories;


public class MaceneratorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 0;
    private int fuelTime = 0;
    private int maxFuelTime = 0;




    public MaceneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MACENERATOR, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return MaceneratorBlockEntity.this.progress;
                    case 1:
                        return MaceneratorBlockEntity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        MaceneratorBlockEntity.this.progress = value;
                        break;
                    case 1:
                        MaceneratorBlockEntity.this.maxProgress = value;
                        break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Macenerator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MaceneratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, MaceneratorBlockEntity entity) {
        if(world.isClient()){
            return;
        }

        if(hasRecipe(entity)){
            entity.progress++;
            markDirty(world, blockPos, blockState);

            if(entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
            else {
                entity.resetProgress();
                markDirty(world, blockPos, blockState);
            }
        }

    }

    private void resetProgress(){
        progress = 0;
    }
    private static void craftItem(MaceneratorBlockEntity entity){
        SimpleInventory inventory = new SimpleInventory(entity.size());

        for(int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(1));
        }

        if(hasRecipe(entity)){
            entity.removeStack(1, 1);
            entity.setStack(2, new ItemStack(Items.RAW_IRON, entity.getStack(2).getCount()+1));
        }
    }

    private static boolean hasRecipe(MaceneratorBlockEntity entity){
        SimpleInventory inventory = new SimpleInventory(entity.size());

        for(int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(1));
        }

        boolean hasMacenerableItemInFirstSlot = entity.getStack(1).getItem() == Items.IRON_ORE.asItem();

        return hasMacenerableItemInFirstSlot && canInsertAmountIntoOutputSlot(inventory, 1)
                && canInsertItemIntoOutputSlot(inventory, Items.IRON_ORE.asItem());
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(2).getItem().getMaxCount() > inventory.getStack(2).getCount() + count;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("macenerator.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("macenerator.progress");

    }
}