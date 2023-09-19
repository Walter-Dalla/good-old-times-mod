package com.goodoldtimes.Block.Entity;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.ic2.block.machine.MaceneratorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static BlockEntityType<MaceneratorBlockEntity> MACENERATOR;

    public static void registerBlockEntity(){
        MACENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(GoodOldTimesMod.MOD_ID),
                FabricEntityTypeBuilder.create(MaceneratorBlockEntity::new, ModBlockEntities.MACENERATOR)
                        .build()
        );
    }

}
