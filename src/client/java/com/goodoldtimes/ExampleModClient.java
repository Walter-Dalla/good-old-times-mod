package com.goodoldtimes;

import com.goodoldtimes.ic2.Screen.MaceratorScreen;
import com.goodoldtimes.ic2.Screen.ModScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ExampleModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		HandledScreens.register(ModScreenHandler.MACERATOR_SCREEN_HANDLER, MaceratorScreen::new);
	}
}