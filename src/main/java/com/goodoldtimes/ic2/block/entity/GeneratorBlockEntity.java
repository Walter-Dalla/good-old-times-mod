package com.goodoldtimes.ic2.block.entity;

import com.goodoldtimes.ic2.screen.GeneratorScreenHandler;
import com.goodoldtimes.ic2.block.custom.cable.ParentCableBlock;
import com.goodoldtimes.ic2.block.custom.GeneratorBlock;
import com.goodoldtimes.ic2.block.custom.ParentMachineBlock;
import com.goodoldtimes.ic2.config.MachineBlockEntityProcessData;
import com.goodoldtimes.utils.dijkstra.Dijkstra;
import com.goodoldtimes.utils.dijkstra.Graph;
import com.goodoldtimes.utils.dijkstra.Node;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GeneratorBlockEntity extends MachineBlockEntity {
    public GeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, null, new MachineBlockEntityProcessData(
            0,
            400,
            0,
            400000,
            2), GeneratorBlock.ENTITY,
        "generator_block_entity");
    }

    public static void tickGenerator(World world, BlockPos blockPos, BlockState blockState, MachineBlockEntity entity){
        var maskDirtyFlag = false;

        var energyValue = HasNewFuel(entity);
        var canAddFuel = CanAddFuel(entity, energyValue);
        if(canAddFuel){
            addFuel(entity, energyValue);
            maskDirtyFlag = true;
        }

        if(entity.machineBlockEntityProcessData.hasEnergy()){
            var machineNodes = new ArrayList<Node>();
            var blocksChecked = new ArrayList<BlockPos>();

            Graph graph = new Graph();
            var parentNode = new Node(blockPos);
            calculateAdjacentBlocks(world, parentNode, graph, machineNodes, blockPos, blocksChecked);
            graph.addNode(parentNode);

            Dijkstra.calculateShortestPathFromSource(graph, parentNode);

            for (var machineNode: machineNodes){
                var blockEntity = (MachineBlockEntity) world.getBlockEntity(machineNode.getName());
                if (blockEntity == null) continue;

                var energy = entity.machineBlockEntityProcessData.getEnergyNbt();
                if(energy >= 32) energy = 32;

                if(!blockEntity.machineBlockEntityProcessData.hasEnergySpace(energy)){
                    continue;
                }

                blockEntity.machineBlockEntityProcessData.increaseEnergy(energy);
                entity.machineBlockEntityProcessData.increaseEnergy(-energy);

                markDirty(world, machineNode.getName(), blockState);
                maskDirtyFlag = true;

            }
        }

        if(maskDirtyFlag){
            markDirty(world, blockPos, blockState);
        }
    }

    private static void calculateAdjacentBlocks(World world, Node actualNode, Graph graph, ArrayList<Node> machineNodes, BlockPos blockPos, ArrayList<BlockPos> blocksChecked) {
        var upPos = new BlockPos(blockPos.getX(), blockPos.getY()+1, blockPos.getZ());
        var downPos = new BlockPos(blockPos.getX(), blockPos.getY()-1, blockPos.getZ());
        var eastPos = new BlockPos(blockPos.getX()+1, blockPos.getY(), blockPos.getZ());
        var westPos = new BlockPos(blockPos.getX()-1, blockPos.getY(), blockPos.getZ());
        var southPos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()+1);
        var northPos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()-1);

        var adjacentPositions = Arrays.asList(upPos, downPos, eastPos, westPos, northPos, southPos) ;

        for(var pos : adjacentPositions){
            if(blockPosEquals(blocksChecked, pos)) {
                continue;
            }

            blocksChecked.add(pos);

            var block = world.getBlockState(pos).getBlock();
            if(block instanceof ParentCableBlock){
                Node cableChildNode = new Node(pos);
                actualNode.addDestination(cableChildNode, 1);

                calculateAdjacentBlocks(world, cableChildNode, graph, machineNodes, pos, blocksChecked);

                graph.addNode(cableChildNode);
            }
            if(block instanceof ParentMachineBlock){
                var blockEntity = world.getBlockEntity(pos);
                if(blockEntity instanceof MachineBlockEntity){
                    Node machineChildNode = new Node(pos);
                    actualNode.addDestination(machineChildNode, 1);
                    machineNodes.add(machineChildNode);
                    graph.addNode(machineChildNode);
                }
            }
        }
    }

    private static boolean blockPosEquals(List<BlockPos> posList, BlockPos pos) {
        var found = false;

        for(var posInArr : posList){
            if(blockPosEquals(posInArr, pos)){
                found = true;
                break;
            }
        }

        return found;
    }

    private static boolean blockPosEquals(BlockPos parentPos, BlockPos pos) {
        return parentPos != null
                && pos.getX() == parentPos.getX()
                && pos.getY() == parentPos.getY()
                && pos.getZ() == parentPos.getZ();
    }


    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GeneratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}