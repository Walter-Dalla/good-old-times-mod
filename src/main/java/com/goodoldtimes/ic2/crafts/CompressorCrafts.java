package com.goodoldtimes.ic2.crafts;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompressorCrafts {

    private static final HashMap<Item, Item> CRAFTS = new HashMap<>();

    public static HashMap<Item, Item> GetCrafts(){
        AddCrafts();

        VALID_CRAFT_INGREDIENT = new ArrayList<>(
            CRAFTS.keySet()
        );

        return CRAFTS;
    }

    public static List<Item> VALID_CRAFT_INGREDIENT = new ArrayList<>();

    public static void AddCrafts() {
        CRAFTS.put(Items.SNOWBALL, Items.SNOW_BLOCK);
    }

}
