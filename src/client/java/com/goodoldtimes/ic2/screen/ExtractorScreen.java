package com.goodoldtimes.ic2.screen;

import com.goodoldtimes.GoodOldTimesMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ExtractorScreen extends ParentMachineScreen<ExtractorScreenHandler> {
    public ExtractorScreen(ExtractorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        TEXTURE = new Identifier(GoodOldTimesMod.MOD_ID, "textures/gui/extractor_gui.png");
    }
}
