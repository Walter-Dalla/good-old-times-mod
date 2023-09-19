package com.goodoldtimes.Block;

import com.goodoldtimes.GoodOldTimesMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlock {
    public static final Block MACERATOR = registerBlock("macerator_block",
        new Block(FabricBlockSettings.create()),
        null);

    public static void registerModBlocks(){

    }

    private static Block registerBlock(String name, Block block, ItemGroup tab){

        registerBlockItem(name, block, tab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModBlock::addItemsToIngredientTabItemGroup);

        return Registry.register(Registries.BLOCK, new Identifier(GoodOldTimesMod.MOD_ID, name), block);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MACERATOR);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registries.ITEM, new Identifier(GoodOldTimesMod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }
}
