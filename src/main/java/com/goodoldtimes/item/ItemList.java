package com.goodoldtimes.item;

import com.goodoldtimes.GoodOldTimesMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(GoodOldTimesMod.MOD_ID, name), item);
    }

    public static ArrayList<Item> getListOfItems(){
        return new ArrayList<>(
            List.of(
        TWO_X_INSULATED_GOLD_CABLE,
                TWO_X_INSULATED_HV_CABLE,
                FOUR_X_INSULATED_HV_CABLE,
                ADVANCED_ALLOY,
                ADVANCED_CIRCUIT,
                BATPACK,
                BIOFUEL_CELL,
                BRONZE,
                BRONZE_DUST,
                CARBON_PLATE,
                CF_BACKPACK,
                CF_PELLET,
                CF_SPRAYER,
                CHAINSAW,
                COALFUEL_CELL,
                COAL_BALL,
                COAL_CHUNK,
                COAL_DUST,
                COFFEE,
                COFFEE_BEANS,
                COFFEE_POWDER,
                COLD_COFFEE,
                COMPOSITE_VEST,
                COMPRESSED_COAL_BALL,
                COMPRESSED_PLANTS,
                COPPER_AXE,
                COPPER_BOOTS,
                COPPER_CHESTPLATE,
                COPPER_DUST,
                COPPER_HELMET,
                COPPER_HOE,
                COPPER_INGOT,
                COPPER_LEGS,
                COPPER_PICKAXE,
                COPPER_SHOVEL,
                COPPER_SWIKRD,
                CROPNALIZER,
                DARK_COFFEE,
                DEPLETED_ISOTOPE_CELL,
                DIAMOND_DRILL,
                DYNAMITE,
                DYNAMITE_O_MOTE,
                ELECTRIC_HOE,
                ELECTRIC_JETPACK,
                ELECTRIC_TREETAP,
                ELECTRIC_WRENCH,
                ELECTROLYZED_WALTER_CELL,
                ELECTRONIC_CIRCUIT,
                EMPTY_BOOZE_BARREL,
                EMPTY_CELL,
                ENERGY_CRYSTAL_1,
                ENERGY_CRYSTAL_2,
                ENERGY_CRYSTAL_3,
                ENERGY_CRYSTAL_4,
                ENERGY_CRYSTAL_5,
                ENERGY_STORAGE_UPGRADE,
                EU_DETECTOR_CABLE,
                EU_READER,
                EU_SPLITTER_CABLE,
                FERTILIZER,
                FREQUENCY_TRANSMITTER,
                FUEL_CAN_EMPTY,
                FUEL_CAN_FILLED,
                GLASS_FIBRE_CABLE,
                GOLD_CABLE,
                GOLD_DUST,
                HOPS,
                HV_CABLE,
                HYDRATED_COAL_DUST,
                HYDRATION_CELL,
                H_COAL,
                H_COAL_CELL,
                INDUSTRIAL_CREDIT,
                INDUSTRIAL_DIAMOND,
                INSULATED_GOLD_CABLE,
                INSULATED_HV_CABLE,
                INSULATION_CUTTER,
                INTEGRATED_HEAT_DISPERSER,
                INTEGRATED_REACTOR_PLATING,
                IRIDIUM_ORE,
                IRIDIUM_PLATE,
                IRON_DUST,
                JETPACK,
                LAPOTRON_CRYSTAL_1,
                LAPOTRON_CRYSTAL_2,
                LAPOTRON_CRYSTAL_3,
                LAPOTRON_CRYSTAL_4,
                LAPOTRON_CRYSTAL_5,
                LAPPACK,
                LAVA_CELL,
                MINING_DRILL,
                MINING_LASER,
                MIXED_METAL_INGOT,
                NANOSUIT_BODYARMOR,
                NANOSUIT_BOOTS,
                NANOSUIT_HELMET,
                NANOSUIT_LEGGINGS,
                NANO_SABER_OFF,
                NANO_SABER_ON,
                NANO_SABER_ON_2,
                NEAR_DEPLETED_URANIUM_CELL,
                OD_SCANNER,
                OVERCLOCKER_UPGRADE,
                OV_SCANNER,
                PLANTBALL,
                QUANTUMSUIT_BODYARMOR,
                QUANTUMSUIT_BOOTS,
                QUANTUMSUIT_HELMET,
                QUANTUMSUIT_LEGGINS,
                RAW_CARBON_FIBRE,
                RAW_CARBON_MESH,
                REFINED_URANIUM,
                REINFORCED_DOOR,
                RE_BATTERY_1,
                RE_BATTERY_2,
                RE_BATTERY_3,
                RE_BATTERY_4,
                RE_BATTERY_5,
                RE_ENRICHED_URANIUM_CELL,
                RUBBER,
                RUBBER_BOOTS,
                SCRAP,
                SCRAP_BOX,
                SINGLE_USE_BATTERY,
                SMALL_PILE_OF_IRON_DUST,
                SOLAR_HELMET,
                STEEL_INGOT,
                STICKY_DYNAMITE,
                STICKY_RESIN,
                STONE_MUG,
                TERRA_WART,
                TIN_CAN,
                TIN_CAN_EMPTY,
                TIN_DUST,
                TIN_INGOT,
                TOOL_BOX_CLOSED,
                TOOL_BOX_OPEN,
                TREETAP,
                ULTRA_LOW_CURRENT_CABLE,
                UNINSULATED_COPPER_CABLE,
                URANIUM_CELL,
                URANIUM_ORE,
                UU_MATTER,
                WATER_CELL,
                WRENCH,


                PE_QUEIMADO
            )
        );
    }

    public static final Item PE_QUEIMADO = registerItem("pe_queimado", new Item(new FabricItemSettings()));
    public static final Item TWO_X_INSULATED_GOLD_CABLE = registerItem("two_x_insulated_gold_cable", new Item(new FabricItemSettings()));
    public static final Item TWO_X_INSULATED_HV_CABLE = registerItem("two_x_insulated_hv_cable", new Item(new FabricItemSettings()));
    public static final Item FOUR_X_INSULATED_HV_CABLE = registerItem("four_x_insulated_hv_cable", new Item(new FabricItemSettings()));
    public static final Item ADVANCED_ALLOY = registerItem("advanced_alloy", new Item(new FabricItemSettings()));
    public static final Item ADVANCED_CIRCUIT = registerItem("advanced_circuit", new Item(new FabricItemSettings()));
    public static final Item BATPACK = registerItem("batpack", new Item(new FabricItemSettings()));
    public static final Item BIOFUEL_CELL = registerItem("biofuel_cell", new Item(new FabricItemSettings()));
    public static final Item BRONZE = registerItem("bronze", new Item(new FabricItemSettings()));
    public static final Item BRONZE_DUST = registerItem("bronze_dust", new Item(new FabricItemSettings()));
    public static final Item CARBON_PLATE = registerItem("carbon_plate", new Item(new FabricItemSettings()));
    public static final Item CF_BACKPACK = registerItem("cf_backpack", new Item(new FabricItemSettings()));
    public static final Item CF_PELLET = registerItem("cf_pellet", new Item(new FabricItemSettings()));
    public static final Item CF_SPRAYER = registerItem("cf_sprayer", new Item(new FabricItemSettings()));
    public static final Item CHAINSAW = registerItem("chainsaw", new Item(new FabricItemSettings()));
    public static final Item COALFUEL_CELL = registerItem("coalfuel_cell", new Item(new FabricItemSettings()));
    public static final Item COAL_BALL = registerItem("coal_ball", new Item(new FabricItemSettings()));
    public static final Item COAL_CHUNK = registerItem("coal_chunk", new Item(new FabricItemSettings()));
    public static final Item COAL_DUST = registerItem("coal_dust", new Item(new FabricItemSettings()));
    public static final Item COFFEE = registerItem("coffee", new Item(new FabricItemSettings()));
    public static final Item COFFEE_BEANS = registerItem("coffee_beans", new Item(new FabricItemSettings()));
    public static final Item COFFEE_POWDER = registerItem("coffee_powder", new Item(new FabricItemSettings()));
    public static final Item COLD_COFFEE = registerItem("cold_coffee", new Item(new FabricItemSettings()));
    public static final Item COMPOSITE_VEST = registerItem("composite_vest", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_COAL_BALL = registerItem("compressed_coal_ball", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_PLANTS = registerItem("compressed_plants", new Item(new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe", new Item(new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new Item(new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new Item(new FabricItemSettings()));
    public static final Item COPPER_DUST = registerItem("copper_dust", new Item(new FabricItemSettings()));
    public static final Item COPPER_HELMET = registerItem("copper_helmet", new Item(new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe", new Item(new FabricItemSettings()));
    public static final Item COPPER_INGOT = registerItem("copper_ingot", new Item(new FabricItemSettings()));
    public static final Item COPPER_LEGS = registerItem("copper_legs", new Item(new FabricItemSettings()));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new Item(new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new Item(new FabricItemSettings()));
    public static final Item COPPER_SWIKRD = registerItem("copper_swikrd", new Item(new FabricItemSettings()));
    public static final Item CROPNALIZER = registerItem("cropnalizer", new Item(new FabricItemSettings()));
    public static final Item DARK_COFFEE = registerItem("dark_coffee", new Item(new FabricItemSettings()));
    public static final Item DEPLETED_ISOTOPE_CELL = registerItem("depleted_isotope_cell", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_DRILL = registerItem("diamond_drill", new Item(new FabricItemSettings()));
    public static final Item DYNAMITE = registerItem("dynamite", new Item(new FabricItemSettings()));
    public static final Item DYNAMITE_O_MOTE = registerItem("dynamite_o_mote", new Item(new FabricItemSettings()));
    public static final Item ELECTRIC_HOE = registerItem("electric_hoe", new Item(new FabricItemSettings()));
    public static final Item ELECTRIC_JETPACK = registerItem("electric_jetpack", new Item(new FabricItemSettings()));
    public static final Item ELECTRIC_TREETAP = registerItem("electric_treetap", new Item(new FabricItemSettings()));
    public static final Item ELECTRIC_WRENCH = registerItem("electric_wrench", new Item(new FabricItemSettings()));
    public static final Item ELECTROLYZED_WALTER_CELL = registerItem("electrolyzed_walter_cell", new Item(new FabricItemSettings()));
    public static final Item ELECTRONIC_CIRCUIT = registerItem("electronic_circuit", new Item(new FabricItemSettings()));
    public static final Item EMPTY_BOOZE_BARREL = registerItem("empty_booze_barrel", new Item(new FabricItemSettings()));
    public static final Item EMPTY_CELL = registerItem("empty_cell", new Item(new FabricItemSettings()));
    public static final Item ENERGY_CRYSTAL_1 = registerItem("energy_crystal_1", new Item(new FabricItemSettings()));
    public static final Item ENERGY_CRYSTAL_2 = registerItem("energy_crystal_2", new Item(new FabricItemSettings()));
    public static final Item ENERGY_CRYSTAL_3 = registerItem("energy_crystal_3", new Item(new FabricItemSettings()));
    public static final Item ENERGY_CRYSTAL_4 = registerItem("energy_crystal_4", new Item(new FabricItemSettings()));
    public static final Item ENERGY_CRYSTAL_5 = registerItem("energy_crystal_5", new Item(new FabricItemSettings()));
    public static final Item ENERGY_STORAGE_UPGRADE = registerItem("energy_storage_upgrade", new Item(new FabricItemSettings()));
    public static final Item EU_DETECTOR_CABLE = registerItem("eu_detector_cable", new Item(new FabricItemSettings()));
    public static final Item EU_READER = registerItem("eu_reader", new Item(new FabricItemSettings()));
    public static final Item EU_SPLITTER_CABLE = registerItem("eu_splitter_cable", new Item(new FabricItemSettings()));
    public static final Item FERTILIZER = registerItem("fertilizer", new Item(new FabricItemSettings()));
    public static final Item FREQUENCY_TRANSMITTER = registerItem("frequency_transmitter", new Item(new FabricItemSettings()));
    public static final Item FUEL_CAN_EMPTY = registerItem("fuel_can_empty", new Item(new FabricItemSettings()));
    public static final Item FUEL_CAN_FILLED = registerItem("fuel_can_filled", new Item(new FabricItemSettings()));
    public static final Item GLASS_FIBRE_CABLE = registerItem("glass_fibre_cable", new Item(new FabricItemSettings()));
    public static final Item GOLD_CABLE = registerItem("gold_cable", new Item(new FabricItemSettings()));
    public static final Item GOLD_DUST = registerItem("gold_dust", new Item(new FabricItemSettings()));
    public static final Item HOPS = registerItem("hops", new Item(new FabricItemSettings()));
    public static final Item HV_CABLE = registerItem("hv_cable", new Item(new FabricItemSettings()));
    public static final Item HYDRATED_COAL_DUST = registerItem("hydrated_coal_dust", new Item(new FabricItemSettings()));
    public static final Item HYDRATION_CELL = registerItem("hydration_cell", new Item(new FabricItemSettings()));
    public static final Item H_COAL = registerItem("h_coal", new Item(new FabricItemSettings()));
    public static final Item H_COAL_CELL = registerItem("h_coal_cell", new Item(new FabricItemSettings()));
    public static final Item INDUSTRIAL_CREDIT = registerItem("industrial_credit", new Item(new FabricItemSettings()));
    public static final Item INDUSTRIAL_DIAMOND = registerItem("industrial_diamond", new Item(new FabricItemSettings()));
    public static final Item INSULATED_GOLD_CABLE = registerItem("insulated_gold_cable", new Item(new FabricItemSettings()));
    public static final Item INSULATED_HV_CABLE = registerItem("insulated_hv_cable", new Item(new FabricItemSettings()));
    public static final Item INSULATION_CUTTER = registerItem("insulation_cutter", new Item(new FabricItemSettings()));
    public static final Item INTEGRATED_HEAT_DISPERSER = registerItem("integrated_heat_disperser", new Item(new FabricItemSettings()));
    public static final Item INTEGRATED_REACTOR_PLATING = registerItem("integrated_reactor_plating", new Item(new FabricItemSettings()));
    public static final Item IRIDIUM_ORE = registerItem("iridium_ore", new Item(new FabricItemSettings()));
    public static final Item IRIDIUM_PLATE = registerItem("iridium_plate", new Item(new FabricItemSettings()));
    public static final Item IRON_DUST = registerItem("iron_dust", new Item(new FabricItemSettings()));
    public static final Item JETPACK = registerItem("jetpack", new Item(new FabricItemSettings()));
    public static final Item LAPOTRON_CRYSTAL_1 = registerItem("lapotron_crystal_1", new Item(new FabricItemSettings()));
    public static final Item LAPOTRON_CRYSTAL_2 = registerItem("lapotron_crystal_2", new Item(new FabricItemSettings()));
    public static final Item LAPOTRON_CRYSTAL_3 = registerItem("lapotron_crystal_3", new Item(new FabricItemSettings()));
    public static final Item LAPOTRON_CRYSTAL_4 = registerItem("lapotron_crystal_4", new Item(new FabricItemSettings()));
    public static final Item LAPOTRON_CRYSTAL_5 = registerItem("lapotron_crystal_5", new Item(new FabricItemSettings()));
    public static final Item LAPPACK = registerItem("lappack", new Item(new FabricItemSettings()));
    public static final Item LAVA_CELL = registerItem("lava_cell", new Item(new FabricItemSettings()));
    public static final Item MINING_DRILL = registerItem("mining_drill", new Item(new FabricItemSettings()));
    public static final Item MINING_LASER = registerItem("mining_laser", new Item(new FabricItemSettings()));
    public static final Item MIXED_METAL_INGOT = registerItem("mixed_metal_ingot", new Item(new FabricItemSettings()));
    public static final Item NANOSUIT_BODYARMOR = registerItem("nanosuit_bodyarmor", new Item(new FabricItemSettings()));
    public static final Item NANOSUIT_BOOTS = registerItem("nanosuit_boots", new Item(new FabricItemSettings()));
    public static final Item NANOSUIT_HELMET = registerItem("nanosuit_helmet", new Item(new FabricItemSettings()));
    public static final Item NANOSUIT_LEGGINGS = registerItem("nanosuit_leggings", new Item(new FabricItemSettings()));
    public static final Item NANO_SABER_OFF = registerItem("nano_saber_off", new Item(new FabricItemSettings()));
    public static final Item NANO_SABER_ON = registerItem("nano_saber_on", new Item(new FabricItemSettings()));
    public static final Item NANO_SABER_ON_2 = registerItem("nano_saber_on_2", new Item(new FabricItemSettings()));
    public static final Item NEAR_DEPLETED_URANIUM_CELL = registerItem("near_depleted_uranium_cell", new Item(new FabricItemSettings()));
    public static final Item OD_SCANNER = registerItem("od_scanner", new Item(new FabricItemSettings()));
    public static final Item OVERCLOCKER_UPGRADE = registerItem("overclocker_upgrade", new Item(new FabricItemSettings()));
    public static final Item OV_SCANNER = registerItem("ov_scanner", new Item(new FabricItemSettings()));
    public static final Item PLANTBALL = registerItem("plantball", new Item(new FabricItemSettings()));
    public static final Item QUANTUMSUIT_BODYARMOR = registerItem("quantumsuit_bodyarmor", new Item(new FabricItemSettings()));
    public static final Item QUANTUMSUIT_BOOTS = registerItem("quantumsuit_boots", new Item(new FabricItemSettings()));
    public static final Item QUANTUMSUIT_HELMET = registerItem("quantumsuit_helmet", new Item(new FabricItemSettings()));
    public static final Item QUANTUMSUIT_LEGGINS = registerItem("quantumsuit_leggins", new Item(new FabricItemSettings()));
    public static final Item RAW_CARBON_FIBRE = registerItem("raw_carbon_fibre", new Item(new FabricItemSettings()));
    public static final Item RAW_CARBON_MESH = registerItem("raw_carbon_mesh", new Item(new FabricItemSettings()));
    public static final Item REFINED_URANIUM = registerItem("refined_uranium", new Item(new FabricItemSettings()));
    public static final Item REINFORCED_DOOR = registerItem("reinforced_door", new Item(new FabricItemSettings()));
    public static final Item RE_BATTERY_1 = registerItem("re_battery_1", new Item(new FabricItemSettings()));
    public static final Item RE_BATTERY_2 = registerItem("re_battery_2", new Item(new FabricItemSettings()));
    public static final Item RE_BATTERY_3 = registerItem("re_battery_3", new Item(new FabricItemSettings()));
    public static final Item RE_BATTERY_4 = registerItem("re_battery_4", new Item(new FabricItemSettings()));
    public static final Item RE_BATTERY_5 = registerItem("re_battery_5", new Item(new FabricItemSettings()));
    public static final Item RE_ENRICHED_URANIUM_CELL = registerItem("re_enriched_uranium_cell", new Item(new FabricItemSettings()));
    public static final Item RUBBER = registerItem("rubber", new Item(new FabricItemSettings()));
    public static final Item RUBBER_BOOTS = registerItem("rubber_boots", new Item(new FabricItemSettings()));
    public static final Item SCRAP = registerItem("scrap", new Item(new FabricItemSettings()));
    public static final Item SCRAP_BOX = registerItem("scrap_box", new Item(new FabricItemSettings()));
    public static final Item SINGLE_USE_BATTERY = registerItem("single_use_battery", new Item(new FabricItemSettings()));
    public static final Item SMALL_PILE_OF_IRON_DUST = registerItem("small_pile_of_iron_dust", new Item(new FabricItemSettings()));
    public static final Item SOLAR_HELMET = registerItem("solar_helmet", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STICKY_DYNAMITE = registerItem("sticky_dynamite", new Item(new FabricItemSettings()));
    public static final Item STICKY_RESIN = registerItem("sticky_resin", new Item(new FabricItemSettings()));
    public static final Item STONE_MUG = registerItem("stone_mug", new Item(new FabricItemSettings()));
    public static final Item TERRA_WART = registerItem("terra_wart", new Item(new FabricItemSettings()));
    public static final Item TIN_CAN = registerItem("tin_can", new Item(new FabricItemSettings()));
    public static final Item TIN_CAN_EMPTY = registerItem("tin_can_empty", new Item(new FabricItemSettings()));
    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new FabricItemSettings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item TOOL_BOX_CLOSED = registerItem("tool_box_closed", new Item(new FabricItemSettings()));
    public static final Item TOOL_BOX_OPEN = registerItem("tool_box_open", new Item(new FabricItemSettings()));
    public static final Item TREETAP = registerItem("treetap", new Item(new FabricItemSettings()));
    public static final Item ULTRA_LOW_CURRENT_CABLE = registerItem("ultra_low_current_cable", new Item(new FabricItemSettings()));
    public static final Item UNINSULATED_COPPER_CABLE = registerItem("uninsulated_copper_cable", new Item(new FabricItemSettings()));
    public static final Item URANIUM_CELL = registerItem("uranium_cell", new Item(new FabricItemSettings()));
    public static final Item URANIUM_ORE = registerItem("uranium_ore", new Item(new FabricItemSettings()));
    public static final Item UU_MATTER = registerItem("uu_matter", new Item(new FabricItemSettings()));
    public static final Item WATER_CELL = registerItem("water_cell", new Item(new FabricItemSettings()));
    public static final Item WRENCH = registerItem("wrench", new Item(new FabricItemSettings()));



}
