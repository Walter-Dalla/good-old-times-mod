package com.goodoldtimes.ic2.Crafts;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ElectricFurnaceCrafts {

    private static final HashMap<Item, Item> CRAFTS = new HashMap<Item, Item>();

    public static HashMap<Item, Item> GetCrafts(){
        AddCrafts();

        VALID_CRAFT_INGREDIENT = new ArrayList<>(
            CRAFTS.keySet()
        );

        return CRAFTS;
    }

    public static List<Item> VALID_CRAFT_INGREDIENT = new ArrayList<>();

    public static void AddCrafts() {
        CRAFTS.put(Items.RAW_IRON, Items.IRON_INGOT);
        CRAFTS.put(Items.RAW_GOLD, Items.GOLD_INGOT);
    }

}
