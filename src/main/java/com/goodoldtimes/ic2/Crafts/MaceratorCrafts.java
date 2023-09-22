package com.goodoldtimes.ic2.Crafts;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.*;

public class MaceratorCrafts {

    private static final HashMap<Item, Item> CRAFTS = new HashMap<Item, Item>();

    public static final List<Item> VALID_CRAFT_INGREDIENT = new ArrayList<>(CRAFTS.keySet());;

    public static final List<Item> VALID_ENERGY_INGREDIENT = new ArrayList<>(
            Collections.singletonList(Items.REDSTONE.asItem())
    );

    public MaceratorCrafts() {
        CRAFTS.put(Items.IRON_ORE, Items.RAW_IRON);
        CRAFTS.put(Items.GOLD_ORE, Items.RAW_GOLD);
    }

    public static HashMap<Item, Item> GetCrafts(){
        return CRAFTS;
    }

}
