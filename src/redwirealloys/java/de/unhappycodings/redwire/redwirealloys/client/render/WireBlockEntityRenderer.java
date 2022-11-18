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
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
        int power = 0;
        BlockState state = entity.getLevel().getBlockState(entity.getBlockPos());
        if (state.is(ModBlocks.RED_ALLOY_WIRE.get()) && entity.getLevel().getBlockState(entity.getBlockPos()).getValue(BlockStateProperties.POWERED))
            power = 7;

        for (Direction direction : directions) {
            if (sides.contains("down")) {
                renderConnections(poseStack, boxVertexConsumer, direction, entity, "down", power);
                drawBox(poseStack, boxVertexConsumer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 1, 8, 2, 2, 2, 0, 0, 2, 2);
            }
            if (sides.contains("up")) {
                renderConnections(poseStack, boxVertexConsumer, direction, entity, "up", power);
                drawBox(poseStack, boxVertexConsumer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 15, 8, 2, 2, 2, 0, 0, 2, 2);
            }
            if (sides.contains("north")) {
                renderConnections(poseStack, boxVertexConsumer, direction, entity, "north", power);
                drawBox(poseStack, boxVertexConsumer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 8, 1, 2, 2, 2, 0, 0, 2, 2);
            }
            if (sides.contains("east")) {
                renderConnections(poseStack, boxVertexConsumer, direction, entity, "east", power);
                drawBox(poseStack, boxVertexConsumer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15, 8, 8, 2, 2, 2, 0, 0, 2, 2);
            }
            if (sides.contains("south")) {
                renderConnections(poseStack, boxVertexConsumer, direction, entity, "south", power);
                drawBox(poseStack, boxVertexConsumer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 8, 15, 2, 2, 2, 0, 0, 2, 2);
            }
            if (sides.contains("west")) {
                renderConnections(poseStack, boxVertexConsumer, direction, entity, "west", power);
                drawBox(poseStack, boxVertexConsumer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1, 8, 8, 2, 2, 2, 0, 0, 2, 2);
            }
        }


    }

    public static void renderConnections(PoseStack stack, VertexConsumer buffer, Direction direction, WireBlockEntity entity, String side, int power) {
        BlockState currentBlockState = entity.getLevel().getBlockState(entity.getBlockPos().relative(direction));
        ArrayList<String> mainSides = WireBlockItem.getSides(entity.getSides());
        ArrayList<String> currentSides = new ArrayList<>();
        if (currentBlockState.is(ModBlocks.RED_ALLOY_WIRE.get())) {
            currentSides = WireBlockItem.getSides(((WireBlockEntity) entity.getLevel().getBlockEntity(entity.getBlockPos().relative(direction))).getSides());
        }
        // Get Connectability for edges
        BlockPos pos = entity.getBlockPos();
        BlockPos[] positions = {pos.north(), pos.east(), pos.south(), pos.west()};
        Direction[] directions = {Direction.SOUTH, Direction.WEST, Direction.NORTH, Direction.EAST};
        ArrayList<String> edges = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            BlockPos position = positions[i];
            boolean isThere = entity.getLevel().getBlockState(position.below()).is(ModBlocks.RED_ALLOY_WIRE.get());
            boolean isOccupied = !entity.getLevel().getBlockState(position).isAir();
            if (isThere && !isOccupied) {
                edges.add(directions[i].getName());
            }
        }

        // Connections to nearby blocks
        if (currentBlockState.canRedstoneConnectTo(entity.getLevel(), entity.getBlockPos(), direction) && (!currentSides.isEmpty() && currentSides.contains(side))) {
            if (side.contains("up") || side.contains("down")) {
                if (direction == Direction.NORTH) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, side.contains("up") ? 15f : 1f, 3.5f, 2, 2, 7, 0, 0, 7, 2);
                if (direction == Direction.EAST) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 12.5f, side.contains("up") ? 15f : 1f, 8, 7, 2, 2, 0, 0, 2, 7);
                if (direction == Direction.SOUTH) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, side.contains("up") ? 15f : 1f, 12.5f, 2, 2, 7, 0, 0, 7, 2);
                if (direction == Direction.WEST) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 3.5f, side.contains("up") ? 15f : 1f, 8, 7, 2, 2, 0, 0, 2, 7);
            }
            if (side.contains("south") || side.contains("north")) {
                if (direction == Direction.UP) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),8f, 12.5f, side.contains("south") ? 15f : 1f, 2, 7, 2, 0, 0, 7, 2);
                if (direction == Direction.DOWN) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),8f, 3.5f, side.contains("south") ? 15f : 1f, 2, 7, 2, 0, 0, 7, 2);
                if (direction == Direction.EAST) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),12.5f, 8, side.contains("south") ? 15f : 1f, 7, 2, 2, 0, 0, 2, 7);
                if (direction == Direction.WEST) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"),3.5f, 8, side.contains("south") ? 15f : 1f, 7, 2, 2, 0, 0, 2, 7);
            }
            if (side.contains("east") || side.contains("west")) {
                if (direction == Direction.UP) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 12.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
                if (direction == Direction.DOWN) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 3.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
                if (direction == Direction.NORTH) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 8, 3.5f, 2, 2, 7, 0, 0, 7, 2);
                if (direction == Direction.SOUTH) drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 8, 12.5f, 2, 2, 7, 0, 0, 7, 2);
            }
        }

        // Connections inside one Block
        if (mainSides.contains("west") && mainSides.contains("south")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1f, 8, 12.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 4.5f, 8, 15f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (mainSides.contains("west") && mainSides.contains("north")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1f, 8, 3.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 4.5f, 8, 1f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (mainSides.contains("east") && mainSides.contains("north")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15f, 8, 3.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 11.5f, 8, 1f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (mainSides.contains("east") && mainSides.contains("south")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15f, 8, 12.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 11.5f, 8, 15f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (mainSides.contains("north") && (mainSides.contains("up") || mainSides.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, mainSides.contains("up") ? 12.5f : 3.5f, 1f, 2, 7, 2, 0, 0, 5, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, mainSides.contains("up") ? 15f : 1f, 4.5f, 2, 2, 5, 0, 0, 5, 2);
        }
        if (mainSides.contains("east") && (mainSides.contains("up") || mainSides.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15f, mainSides.contains("up") ? 12.5f : 3.5f, 8f, 2, 7, 2, 0, 0, 2, 5);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 11.5f, mainSides.contains("up") ? 15f : 1f, 8f, 5, 2, 2, 0, 0, 5, 2);
        }
        if (mainSides.contains("south") && (mainSides.contains("up") || mainSides.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, mainSides.contains("up") ? 12.5f : 3.5f, 15f, 2, 7, 2, 0, 0, 5, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, mainSides.contains("up") ? 15f : 1f, 11.5f, 2, 2, 5, 0, 0, 5, 2);
        }
        if (mainSides.contains("west") && (mainSides.contains("up") || mainSides.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1f, mainSides.contains("up") ? 12.5f : 3.5f, 8f, 2, 7, 2, 0, 0, 2, 5);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 4.5f, mainSides.contains("up") ? 15f : 1f, 8f, 5, 2, 2, 0, 0, 5, 2);
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
        stack.popPose();
    }

    public static int getColorForPower(int pPower) {
        Vec3 vec3 = COLORS[pPower];
        return Mth.color((float)vec3.x(), (float)vec3.y(), (float)vec3.z());
    }

}
