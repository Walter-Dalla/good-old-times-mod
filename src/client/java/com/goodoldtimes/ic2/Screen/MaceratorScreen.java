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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaceratorScreen extends HandledScreen<MaceratorScreenHandler> {

    private static final Identifier TEXTURE =
            new Identifier(GoodOldTimesMod.MOD_ID, "textures/gui/macerator_gui.png");

    public static final String BLOCK_ID = "macerator_screen";
    public static final Logger LOGGER = LoggerFactory.getLogger(GoodOldTimesMod.MOD_ID + "_" + BLOCK_ID);

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

        LOGGER.info((x + 59) +"-"+ (y + 37));
        context.drawTexture(TEXTURE, x + 56, y + 36, 176, 0, 14, handler.getScaledEnergy());
        context.drawTexture(TEXTURE, x + 79, y + 34, 176, 14,  handler.getScaledProgress(),14);


        //renderProgressArrow(matrices, x, y);
        //energyInfoArea.draw(matrices);
    }

    /*private void (MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            //context.drawTexture(matrices, x + 105, y + 33, 176, 0, 8, handler.getScaledProgress());
        }
    }

     */


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
