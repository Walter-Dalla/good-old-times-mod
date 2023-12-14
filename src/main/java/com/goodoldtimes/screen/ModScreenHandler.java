package com.goodoldtimes.screen;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.screen.*;
import com.goodoldtimes.ic2.block.custom.*;
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

    public static final ScreenHandlerType<GeneratorScreenHandler> GENERATOR_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, GeneratorBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(GeneratorScreenHandler::new));
    public static final ScreenHandlerType<MaceratorScreenHandler> MACERATOR_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, MaceratorBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(MaceratorScreenHandler::new));
    public static final ScreenHandlerType<ElectricFurnaceScreenHandler> ELECTRIC_FURNACE_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, ElectricFurnaceBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(ElectricFurnaceScreenHandler::new));
    public static void registerAllScreenHandler(){
        GoodOldTimesMod.LOGGER.info("Registering Screen Handlers for " + GoodOldTimesMod.MOD_ID);
    }
}
