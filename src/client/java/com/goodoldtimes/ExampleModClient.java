package com.goodoldtimes;

import com.goodoldtimes.ic2.Screen.*;
import com.goodoldtimes.Screen.ModScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ExampleModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		HandledScreens.register(ModScreenHandler.MACERATOR_SCREEN_HANDLER, MaceratorScreen::new);
		HandledScreens.register(ModScreenHandler.ELECTRIC_FURNACE_SCREEN_HANDLER, ElectricFurnaceScreen::new);
		HandledScreens.register(ModScreenHandler.COMPRESSOR_SCREEN_HANDLER, CompressorScreen::new);
		HandledScreens.register(ModScreenHandler.EXTRACTOR_SCREEN_HANDLER, ExtractorScreen::new);
	}
}