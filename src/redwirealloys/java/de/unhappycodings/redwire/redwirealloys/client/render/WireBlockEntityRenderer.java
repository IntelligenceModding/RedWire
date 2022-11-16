package de.unhappycodings.redwire.redwirealloys.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.client.util.RenderUtil;
import de.unhappycodings.redwire.redwirealloys.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirealloys.common.block.WireBlock;
import de.unhappycodings.redwire.redwirealloys.common.blockentity.WireBlockEntity;
import de.unhappycodings.redwire.redwirealloys.common.item.WireBlockItem;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WireBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<WireBlockEntity> {

    public WireBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    private static final Vec3[] COLORS = Util.make(new Vec3[16], (p_154319_) -> {
        for(int i = 0; i <= 15; ++i) {
            float f = (float)i / 15.0F;
            float f1 = f * 0.6F + (f > 0.0F ? 0.4F : 0.3F);
            float f2 = Mth.clamp(f * f * 0.7F - 0.5F, 0.0F, 1.0F);
            float f3 = Mth.clamp(f * f * 0.6F - 0.7F, 0.0F, 1.0F);
            p_154319_[i] = new Vec3((double)f1, (double)f2, (double)f3);
        }
    });

    @Override
    public void render(@NotNull WireBlockEntity entity, float pPartialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay) {
        ArrayList<String> sides = WireBlockItem.getSides(entity.getSides());
        VertexConsumer boxVertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(TextureAtlas.LOCATION_BLOCKS));
        Direction[] directions = {Direction.UP, Direction.DOWN, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

        if (sides.contains("down")) {
            drawBox(poseStack, boxVertexConsumer, getColorForPower(0), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),8, 1, 8, 2, 2, 2, 0, 0, 2, 2);

            for (Direction direction : directions) {
                if (entity.getLevel().getBlockState(entity.getBlockPos().relative(direction)).canRedstoneConnectTo(entity.getLevel(), entity.getBlockPos(), direction)) {
                    if (direction == Direction.NORTH) drawBox(poseStack, boxVertexConsumer, getColorForPower(0), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),8, 1, 3.5f, 2, 2, 7, 0, 0, 7, 2);
                    if (direction == Direction.EAST) drawBox(poseStack, boxVertexConsumer, getColorForPower(0), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),12.5f, 1, 8, 7, 2, 2, 0, 0, 2, 7);
                    if (direction == Direction.SOUTH) drawBox(poseStack, boxVertexConsumer, getColorForPower(0), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),8, 1, 12.5f, 2, 2, 7, 0, 0, 7, 2);
                    if (direction == Direction.WEST) drawBox(poseStack, boxVertexConsumer, getColorForPower(0), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),3.5f, 1, 8, 7, 2, 2, 0, 0, 2, 7);
                }
            }
        }
    }

    public static void drawBox(PoseStack stack, VertexConsumer buffer, int color, ResourceLocation texture, float pX, float pY, float pZ, float sX, float sY, float sZ, float pUOffset, float pVOffset, float pWidth, float pHeight) {
        stack.pushPose();
        sX = sX / 16;
        sY = sY / 16;
        sZ = sZ / 16;
        pX = pX / 16;
        pY = pY / 16;
        pZ = pZ / 16;

        drawPlane(stack, buffer, color, texture, RenderUtil.Perspective.UP, pX, pY, pZ, sX, sY, sZ, pUOffset, pVOffset, pWidth, pHeight);
        drawPlane(stack, buffer, color, texture, RenderUtil.Perspective.DOWN, pX, pY, pZ, sX, sY, sZ, pUOffset, pVOffset, pWidth, pHeight);
        drawPlane(stack, buffer, color, texture, RenderUtil.Perspective.RIGHT, pX, pY, pZ, sX, sY, sZ, pUOffset, pVOffset, pWidth, pHeight);
        drawPlane(stack, buffer, color, texture, RenderUtil.Perspective.LEFT, pX, pY, pZ, sX, sY, sZ, pUOffset, pVOffset, pWidth, pHeight);
        drawPlane(stack, buffer, color, texture, RenderUtil.Perspective.FRONT, pX, pY, pZ, sX, sY, sZ, pUOffset, pVOffset, pWidth, pHeight);
        drawPlane(stack, buffer, color, texture, RenderUtil.Perspective.BACK, pX, pY, pZ, sX, sY, sZ, pUOffset, pVOffset, pWidth, pHeight);
        stack.popPose();
    }

    public static void drawPlane(PoseStack stack, VertexConsumer buffer, int color, ResourceLocation texture, RenderUtil.Perspective perspective, float pX, float pY, float pZ, float sX, float sY, float sZ, float pUOffset, float pVOffset, float pWidth, float pHeight) {
        stack.pushPose();
        Matrix4f matrix4f = stack.last().pose();

        TextureAtlasSprite stillTexture = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(texture);

        sX = sX / 2;
        sY = sY / 2;
        sZ = sZ / 2;

        float u1 = stillTexture.getU(pUOffset);
        float u2 = stillTexture.getU(pWidth);
        float v1 = stillTexture.getV(pVOffset);
        float v2 = stillTexture.getV(pHeight);

        if (perspective == RenderUtil.Perspective.UP) {
            buffer.vertex(matrix4f, -sX + pX, sY + pY, sZ + pZ).color(color).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, sZ + pZ).color(color).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, -sZ + pZ).color(color).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, -sZ + pZ).color(color).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        }
        if (perspective == RenderUtil.Perspective.DOWN) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, sZ + pZ).color(color).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, -sZ + pZ).color(color).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, -sZ + pZ).color(color).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, sZ + pZ).color(color).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, -1f, 0f).endVertex();
        }
        if (perspective == RenderUtil.Perspective.BACK) {
            buffer.vertex(matrix4f, sX + pX, -sY + pY, sZ + pZ).color(color).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, -sZ + pZ).color(color).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, -sZ + pZ).color(color).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, sZ + pZ).color(color).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
        }
        if (perspective == RenderUtil.Perspective.FRONT) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, sZ + pZ).color(color).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, sZ + pZ).color(color).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, -sZ + pZ).color(color).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, -sZ + pZ).color(color).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(1f, 0f, 0f).endVertex();
        }
        if (perspective == RenderUtil.Perspective.RIGHT) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, -sZ + pZ).color(color).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, -sZ + pZ).color(color).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, -sZ + pZ).color(color).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, -sZ + pZ).color(color).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        }
        if (perspective == RenderUtil.Perspective.LEFT) {
            buffer.vertex(matrix4f, -sX + pX, -sY + pY, sZ + pZ).color(color).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, -sY + pY, sZ + pZ).color(color).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, sX + pX, sY + pY, sZ + pZ).color(color).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
            buffer.vertex(matrix4f, -sX + pX, sY + pY, sZ + pZ).color(color).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        }


        /*
        buffer.vertex(matrix4f, pX, -pY, pZ).cocolor).uv(u1, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        buffer.vertex(matrix4f, pX, pY, pZ).cocolor).uv(u1, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        buffer.vertex(matrix4f, pX, pY, -pZ).cocolor).uv(u2, v1).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        buffer.vertex(matrix4f, pX, -pY, -pZ).cocolor).uv(u2, v2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(0f, 1f, 0f).endVertex();
        */
        stack.popPose();
    }

    public static int getColorForPower(int pPower) {
        Vec3 vec3 = COLORS[pPower];
        return Mth.color((float)vec3.x(), (float)vec3.y(), (float)vec3.z());
    }

}
