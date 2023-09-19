package com.goodoldtimes.Block.Entity;

import com.goodoldtimes.GoodOldTimesMod;
import com.goodoldtimes.Block.ModBlock;
import com.goodoldtimes.ic2.block.machine.MaceratorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static BlockEntityType<MaceratorBlockEntity> macerator;

    public static void registerBlockEntity(){
        macerator = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(GoodOldTimesMod.MOD_ID, "macerator"),
            FabricBlockEntityTypeBuilder.create(MaceratorBlockEntity::new, ModBlock.MACERATOR)
                .build()
        );
    }

}
