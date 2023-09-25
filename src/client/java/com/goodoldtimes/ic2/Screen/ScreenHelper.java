package com.goodoldtimes.ic2.Screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ScreenHelper {
    public static void DrawBackgroundGeneric(DrawContext context, int width, int backgroundWidth,
            int height, int backgroundHeight, Identifier texture, ParentMachineScreenHandler handler) {;
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        MatrixStack matrices = context.getMatrices();
        context.drawTexture(texture, x, y, 0, 0, backgroundWidth, backgroundHeight);

        context.drawTexture(texture, x + 56, y + 36, 176, 0, 14, handler.getScaledEnergy());
        context.drawTexture(texture, x + 79, y + 34, 176, 14,  handler.getScaledProgress(),14);
    }

    public static int AddCenterTitle(int backgroundWidth, TextRenderer textRenderer, Text title) {
        return (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
