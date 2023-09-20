package com.goodoldtimes.ic2.Screen;

import com.goodoldtimes.GoodOldTimesMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MaceratorScreen extends HandledScreen<MaceratorScreenHandler> {

    private static final Identifier TEXTURE =
            new Identifier(GoodOldTimesMod.MOD_ID, "textures/gui/macerator_gui.png");

    public MaceratorScreen(MaceratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        MatrixStack matrices = context.getMatrices();
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(matrices, x, y);
        //energyInfoArea.draw(matrices);
    }

    private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            //drawTexture(matrices, x + 105, y + 33, 176, 0, 8, handler.getScaledProgress());
        }
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
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
