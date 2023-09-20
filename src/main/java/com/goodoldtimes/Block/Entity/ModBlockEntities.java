package com.goodoldtimes.Block.Entity;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.Block.ModBlock;
import com.goodoldtimes.ic2.block.Custom.MaceratorBlock;
import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModBlockEntities {
    public static BlockEntityType<MaceratorBlockEntity> MACERATOR =
        Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(GoodOldTimesMod.MOD_ID, MaceratorBlock.BLOCK_ID),
            FabricBlockEntityTypeBuilder.create(MaceratorBlockEntity::new,
                    ModBlock.MACERATOR)
                    .build(null)
        );
    public static final Logger LOGGER = LoggerFactory.getLogger(GoodOldTimesMod.MOD_ID);

    public static void registerBlockEntity(){
        LOGGER.info("Registering Block Entities");
    }

}
