package com.goodoldtimes.item;

import com.goodoldtimes.GoodOldTimesMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems extends ItemList {
    public static final RegistryKey<ItemGroup> IC2_ITEM_GROUP_REGISTRY =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(GoodOldTimesMod.MOD_ID, "ic2_group"));

    public static void registerModItems(){
        GoodOldTimesMod.LOGGER.info("Registering mod itens for: " + GoodOldTimesMod.MOD_ID);

        registerItemGroup();

        ItemGroupEvents.modifyEntriesEvent(IC2_ITEM_GROUP_REGISTRY).register(ModItems::addItemsToIngredientTabItemGroup);
    }

    public static void registerItemGroup(){

        var ic2ItemGroup = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ItemList.ELECTRONIC_CIRCUIT))
                .displayName(Text.translatable("IC2"))
                .build();

        Registry.register(Registries.ITEM_GROUP, IC2_ITEM_GROUP_REGISTRY, ic2ItemGroup);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        for(var item : getListOfItems()){
            entries.add(item);
        }
    }
}

