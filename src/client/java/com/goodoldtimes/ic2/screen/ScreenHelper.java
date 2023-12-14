package com.goodoldtimes.ic2.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ScreenHelper {
    public static void DrawBackgroundGeneric(DrawContext context, int width, int backgroundWidth,
            int height, int backgroundHeight, Identifier texture) {

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(texture, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    public static int AddCenterTitle(int backgroundWidth, TextRenderer textRenderer, Text title) {
        return (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
