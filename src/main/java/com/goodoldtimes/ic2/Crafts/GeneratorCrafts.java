package com.goodoldtimes.ic2.Crafts;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GeneratorCrafts {

    private static final HashMap<Item, Object> CRAFTS = new HashMap<>();

    public static HashMap<Item, Object> GetCrafts(){
        AddCrafts();

        VALID_CRAFT_INGREDIENT = new ArrayList<>(
            CRAFTS.keySet()
        );

        return CRAFTS;
    }

    public static List<Item> VALID_CRAFT_INGREDIENT = new ArrayList<>();

    public static void AddCrafts() {
        CRAFTS.put(Items.COAL, 500);
        CRAFTS.put(Items.COAL_BLOCK, 4500);
    }
}
