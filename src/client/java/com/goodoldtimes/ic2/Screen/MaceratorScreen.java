package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MaceratorScreen extends ParentMachineScreen<MaceratorScreenHandler> {

    public MaceratorScreen(MaceratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        TEXTURE = new Identifier(GoodOldTimesMod.MOD_ID, "textures/gui/macerator_gui.png");
    }
}
