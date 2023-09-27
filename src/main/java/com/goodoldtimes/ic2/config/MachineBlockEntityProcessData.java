package com.goodoldtimes.ic2.config;

public class MachineBlockEntityProcessData {
    private int progressNbt;
    private int maxProgress;
    private int energyNbt;
    private int maxEnergy;
    private int energyPerTickOnCrafting;

    public MachineBlockEntityProcessData(int progressNbt, int maxProgress, int energyNbt, int maxEnergy, int energyPerTickOnCrafting) {

        this.progressNbt = progressNbt;
        this.maxProgress = maxProgress;
        this.energyNbt = energyNbt;
        this.maxEnergy = maxEnergy;
        this.energyPerTickOnCrafting = energyPerTickOnCrafting;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }
    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getProgressNbt() {
        return progressNbt;
    }

    public void setProgressNbt(int progressNbt) {
        this.progressNbt = progressNbt;
    }

    public int getEnergyNbt() {
        return energyNbt;
    }

    public void setEnergyNbt(int energyNbt) {
        this.energyNbt = energyNbt;
    }

    public void increaseEnergy(int increase){
        this.energyNbt += increase;
    }
    public void increaseProgress(int increase){
        this.progressNbt += increase;
    }

    public int getEnergyPerTickOnCrafting() {
        return energyPerTickOnCrafting;
    }

    public void setEnergyPerTickOnCrafting(int energyPerTickOnCrafting) {
        this.energyPerTickOnCrafting = energyPerTickOnCrafting;
    }
}
