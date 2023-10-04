package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.ic2.Crafts.CompressorCrafts;
import com.goodoldtimes.ic2.Crafts.GeneratorCrafts;
import com.goodoldtimes.ic2.Screen.CompressorScreenHandler;
import com.goodoldtimes.ic2.Screen.GeneratorScreenHandler;
import com.goodoldtimes.ic2.Screen.MaceratorScreenHandler;
import com.goodoldtimes.ic2.block.Custom.CompressorBlock;
import com.goodoldtimes.ic2.block.Custom.GeneratorBlock;
import com.goodoldtimes.ic2.block.entity.Cable.ParentCableBlockEntity;
import com.goodoldtimes.ic2.config.MachineBlockEntityProcessData;
import com.goodoldtimes.utils.dijkstra.Dijkstra;
import com.goodoldtimes.utils.dijkstra.Graph;
import com.goodoldtimes.utils.dijkstra.Node;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class GeneratorBlockEntity extends MachineBlockEntity {
    public GeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, null, new MachineBlockEntityProcessData(
            0,
            400,
            0,
            2000,
            2), GeneratorBlock.ENTITY,
        "generator_block_entity");
    }

    public static void tickGenerator(World world, BlockPos blockPos, BlockState blockState, MachineBlockEntity entity){
        var maskDirtyFlag = false;

        entity.machineBlockEntityProcessData.increaseEnergy(200);

        var machineNodes = new ArrayList<Node>();

        Graph graph = new Graph();
        var parentNode = new Node(blockPos);
        calculateAdjacentBlocks(world, parentNode, graph, machineNodes, blockPos, null);
        graph.addNode(parentNode);

        Dijkstra.calculateShortestPathFromSource(graph, parentNode);

        for (var machineNode: machineNodes){
            var blockEntity =  world.getBlockEntity(machineNode.getName());

            if (blockEntity == null) continue;

            ((MachineBlockEntity) blockEntity).machineBlockEntityProcessData.increaseEnergy(200);
            entity.machineBlockEntityProcessData.increaseEnergy(-200);
            markDirty(world, machineNode.getName(), blockState);
            maskDirtyFlag = true;
        }

        if(maskDirtyFlag){
            markDirty(world, blockPos, blockState);
        }
    }

    private static void calculateAdjacentBlocks(World world, Node actualNode, Graph graph, ArrayList<Node> machineNodes, BlockPos blockPos, BlockPos parentPos) {
        var upPos = new BlockPos(blockPos.getX(), blockPos.getY()+1, blockPos.getZ());
        var downPos = new BlockPos(blockPos.getX(), blockPos.getY()-1, blockPos.getZ());
        var eastPos = new BlockPos(blockPos.getX()+1, blockPos.getY(), blockPos.getZ());
        var westPos = new BlockPos(blockPos.getX()-1, blockPos.getY(), blockPos.getZ());
        var southPos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()+1);
        var northPos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()-1);

        var adjacentPositions = Arrays.asList(upPos, downPos, eastPos, westPos, northPos, southPos) ;

        for(var pos : adjacentPositions){
            if(parentPos != null
                &&  pos.getX() == parentPos.getX()
                && pos.getY() == parentPos.getY()
                && pos.getZ() == parentPos.getZ()) {
                continue;
            }


            var blockEntity = world.getBlockEntity(pos);

            if(blockEntity instanceof ParentCableBlockEntity){
                Node cableChildNode = new Node(pos);
                actualNode.addDestination(cableChildNode, 1);

                calculateAdjacentBlocks(world, cableChildNode, graph, machineNodes, pos, blockPos);

                graph.addNode(cableChildNode);
            }

            if(blockEntity instanceof MachineBlockEntity){
                Node machineChildNode = new Node(pos);
                actualNode.addDestination(machineChildNode, 1);
                machineNodes.add(machineChildNode);
                graph.addNode(machineChildNode);
            }

        }
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GeneratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}