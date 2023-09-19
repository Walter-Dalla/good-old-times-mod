package com.goodoldtimes.ic2.Screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandler
{

    public static ScreenHandlerType<MaceneratorScreenHandler> MACENERATOR_SCREEN_HANDLER;

    public static void registerAllScreenHandler(){
        MACENERATOR_SCREEN_HANDLER = new ScreenHandlerType<>(MaceneratorScreenHandler::new);
    }
}
