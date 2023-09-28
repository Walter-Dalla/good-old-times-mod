package com.goodoldtimes.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.Screen.CompressorScreenHandler;
import com.goodoldtimes.ic2.Screen.ElectricFurnaceScreenHandler;
import com.goodoldtimes.ic2.Screen.ExtractorScreenHandler;
import com.goodoldtimes.ic2.Screen.MaceratorScreenHandler;
import com.goodoldtimes.ic2.block.Custom.CompressorBlock;
import com.goodoldtimes.ic2.block.Custom.ElectricFurnaceBlock;
import com.goodoldtimes.ic2.block.Custom.ExtractorBlock;
import com.goodoldtimes.ic2.block.Custom.MaceratorBlock;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler
{

    public static final ScreenHandlerType<ExtractorScreenHandler> EXTRACTOR_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, ExtractorBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(ExtractorScreenHandler::new));

    public static final ScreenHandlerType<CompressorScreenHandler> COMPRESSOR_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, CompressorBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(CompressorScreenHandler::new));
    public static ScreenHandlerType<MaceratorScreenHandler> MACERATOR_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, MaceratorBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(MaceratorScreenHandler::new));
    public static ScreenHandlerType<ElectricFurnaceScreenHandler> ELECTRIC_FURNACE_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, ElectricFurnaceBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(ElectricFurnaceScreenHandler::new));
    public static void registerAllScreenHandler(){
        GoodOldTimesMod.LOGGER.info("Registering Screen Handlers for " + GoodOldTimesMod.MOD_ID);
    }
}
