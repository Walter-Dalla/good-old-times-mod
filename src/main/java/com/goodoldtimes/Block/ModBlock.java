package com.goodoldtimes.Block;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.block.Custom.CompressorBlock;
import com.goodoldtimes.ic2.block.Custom.ElectricFurnaceBlock;
import com.goodoldtimes.ic2.block.Custom.MaceratorBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;


public class ModBlock {
    protected static ArrayList<Block> ListOfBlocks;

    public static void registerModBlocks(){
        ListOfBlocks = new ArrayList<>(
                List.of(CompressorBlock.BLOCK,
                        ElectricFurnaceBlock.BLOCK,
                        MaceratorBlock.BLOCK
                )
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModBlock::addItemsToIngredientTabItemGroup);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        for(var block : ListOfBlocks) {
            entries.add(block);
        }
    }

    public static Block registerBlock(String name, Block block){

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, new Identifier(GoodOldTimesMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(GoodOldTimesMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
