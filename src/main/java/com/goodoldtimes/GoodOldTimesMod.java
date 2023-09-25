package com.goodoldtimes;

import com.goodoldtimes.Block.Entity.ModBlockEntities;
import com.goodoldtimes.ic2.Screen.ModScreenHandler;
import com.goodoldtimes.Block.ModBlock;
import com.goodoldtimes.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodOldTimesMod implements ModInitializer {

	public static final String MOD_ID = "good-old-times";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Start loading...");

		ModItems.registerModItems();

		ModBlockEntities.registerBlockEntity();

		ModBlock.registerModBlocks();

		ModScreenHandler.registerAllScreenHandler();

		LOGGER.info("Finish loading...");
	}
}