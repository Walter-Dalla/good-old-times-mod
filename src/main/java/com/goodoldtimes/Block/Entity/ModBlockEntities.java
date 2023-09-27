package com.goodoldtimes.Block.Entity;

import com.goodoldtimes.Block.ModBlock;
import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.block.Custom.ElectricFurnaceBlock;
import com.goodoldtimes.ic2.block.Custom.MaceratorBlock;
import com.goodoldtimes.ic2.block.entity.ElectricFurnaceBlockEntity;
import com.goodoldtimes.ic2.block.entity.MaceratorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static BlockEntityType<MaceratorBlockEntity> MACERATOR =
        Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(GoodOldTimesMod.MOD_ID, MaceratorBlock.BLOCK_ID+"_entity"),
            FabricBlockEntityTypeBuilder.create(MaceratorBlockEntity::new,
                    ModBlock.MACERATOR)
                    .build(null)
        );
    public static BlockEntityType<ElectricFurnaceBlockEntity> ELECTRIC_FURNACE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(GoodOldTimesMod.MOD_ID, ElectricFurnaceBlock.BLOCK_ID+"_entity"),
            FabricBlockEntityTypeBuilder.create(ElectricFurnaceBlockEntity::new,
                    ModBlock.ELECTRIC_FURNACE)
                    .build(null)
    );

    public static void registerBlockEntity(){
        GoodOldTimesMod.LOGGER.info("Registering Block Entities");
    }

}
