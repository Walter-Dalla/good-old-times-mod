package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.block.Custom.MaceratorBlock;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModScreenHandler
{

    public static ScreenHandlerType<MaceratorScreenHandler> MACERATOR_SCREEN_HANDLER
            = Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, MaceratorBlock.BLOCK_ID+"_screen_handler"),
            new ExtendedScreenHandlerType<>(MaceratorScreenHandler::new));
    public static final Logger LOGGER = LoggerFactory.getLogger(GoodOldTimesMod.MOD_ID + "_mod_screen_handler");

    public static void registerAllScreenHandler(){
        LOGGER.info("Registering Screen Handlers for " + GoodOldTimesMod.MOD_ID);
    }
}
