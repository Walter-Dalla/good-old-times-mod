package com.goodoldtimes;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.Screen.ModScreenHandler;
import com.goodoldtimes.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodOldTimesMod implements ModInitializer {

	public static final String MOD_ID = "good-old-times";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModBlockEntities.registerBlockEntity();
		ModScreenHandler.registerAllScreenHandler();

		LOGGER.info("Hello Fabric world!");
	}
}