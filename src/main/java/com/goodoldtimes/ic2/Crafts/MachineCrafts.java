package com.goodoldtimes.ic2.Crafts;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class MachineCrafts {

    public static ArrayList<Item> GetValidEnergyIngredient (){
        return new ArrayList<>(GetItemToEnergyConvertor().keySet());
    }

    public static HashMap<Item, Integer> GetItemToEnergyConvertor(){
        HashMap<Item, Integer> itemToEnergyConvertor = new HashMap<>();
        AddItemToEnergyConvertor(itemToEnergyConvertor);

        return itemToEnergyConvertor;
    }
    public static void AddItemToEnergyConvertor(HashMap<Item, Integer> itemToEnergyConvertor) {
        itemToEnergyConvertor.put(Items.REDSTONE, 500);
        itemToEnergyConvertor.put(Items.REDSTONE_BLOCK, 9*500);
    }

    public static Integer GetItemToEnergyConvertor(Item energyItem) {
        return GetItemToEnergyConvertor().getOrDefault(energyItem, null);
    }
}
