package de.unhappycodings.redwire.redwirealloys.client.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import de.unhappycodings.redwire.redwirealloys.client.render.WireBlockEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderUtil {


    public static void drawPlane(PoseStack stack, VertexConsumer buffer, ResourceLocation texture, Perspective perspective, float pX, float pY, float pZ, float sX, float sY, float sZ, float pUOffset, float pVOffset, float pWidth, float pHeight, float xOffset, float zOffset) {
        stack.pushPose();
        Matrix4f matrix4f = stack.last().pose();

        TextureAtlasSprite stillTexture = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(texture);

        sX = (sX * 0.0625f) + 0.5f;
        sY = (sY * 0.0625f) - 0.5f;
        sZ = (sZ * 0.0625f) + 0.5f;

        pX = (pX * 0.0625f) + 0.5f;
        pY = (pY * 0.0625f) + 0.5f;
        pZ = (pZ * 0.0625f) + 0.5f;

        float u1 = stillTexture.getU(pUOffset);
        float u2 = stillTexture.getU(pWidth);
        float v1 = stillTexture.getV(pVOffset);
        float v2 = stillTexture.getV(pHeight);

        if (perspective == Perspective.UP) {
            buffer.vertex(matrix4f, -sX + pX - (xOffset * 0.0625f), sY + pY, sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX - (xOffset * 0.0625f), sY + pY, sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX - (xOffset * 0.0625f), sY + pY, -sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX - (xOffset * 0.0625f), sY + pY, -sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        }
        if (perspective == Perspective.DOWN) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
        }
        if (perspective == Perspective.BACK) {
            buffer.vertex(matrix4f, sX + pX, -sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
        }
        if (perspective == Perspective.FRONT) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY - (xOffset * 0.0625f), sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY - (xOffset * 0.0625f), sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY - (xOffset * 0.0625f), -sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, -sY + pY - (xOffset * 0.0625f), -sZ + pZ - (zOffset * 0.0625f)).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
        }
        if (perspective == Perspective.RIGHT) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, -sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        }
        if (perspective == Perspective.LEFT) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, sZ + pZ).color(WireBlockEntityRenderer.getColorForPower(15)).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        }

        stack.popPose();
    }

    public enum Perspective {

        UP, DOWN, RIGHT, LEFT, FRONT, BACK
    }



}
