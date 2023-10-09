package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GeneratorScreen extends ParentMachineScreen<GeneratorScreenHandler> {
    public GeneratorScreen(GeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        TEXTURE = new Identifier(GoodOldTimesMod.MOD_ID, "textures/gui/generator_gui.png");

        handler.PROGRESS_BOLT_SIZE_DEFAULT = 24;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        ScreenHelper.DrawBackgroundGeneric(context, width, backgroundWidth, height, backgroundHeight, TEXTURE);
        drawBackgroundGenerator(context, handler);
    }

    protected void drawBackgroundGenerator(DrawContext context, ParentMachineScreenHandler handler){
        context.drawTexture(TEXTURE, x + 66, y + 36, 176, 0, 14, handler.getScaledProgress());
        context.drawTexture(TEXTURE, x + 94, y + 35, 176, 14,  handler.getScaledEnergy(),17);
    }
}
