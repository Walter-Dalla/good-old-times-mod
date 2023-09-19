package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler
{

    public static ScreenHandlerType<MaceratorScreenHandler> macerator_SCREEN_HANDLER
            = new ExtendedScreenHandlerType<>(MaceratorScreenHandler::new);

    public static void registerAllScreenHandler(){
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(GoodOldTimesMod.MOD_ID, "macerator_block"),
                macerator_SCREEN_HANDLER);
    }
}
