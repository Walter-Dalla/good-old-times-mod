package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ParentMachineScreen<E extends ScreenHandler> extends HandledScreen<E>  {
    protected Identifier TEXTURE =
            new Identifier(GoodOldTimesMod.MOD_ID, "textures/gui/electric_furnace_gui.png");
    public ParentMachineScreen(E handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        ScreenHelper.DrawBackgroundGeneric(context, width, backgroundWidth, height, backgroundHeight, TEXTURE, (ParentMachineScreenHandler) handler);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        titleX = ScreenHelper.AddCenterTitle(backgroundWidth, textRenderer, title);
    }
}
