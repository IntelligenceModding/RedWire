package de.unhappycodings.redwire.redwirealloys.client.render;

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
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WireBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<WireBlockEntity> {

    private static final Vec3[] COLORS = Util.make(new Vec3[16], (p_154319_) -> {
        for (int i = 0; i <= 15; ++i) {
            float f = (float) i / 15.0F;
            float f1 = f * 0.6F + (f > 0.0F ? 0.4F : 0.3F);
            float f2 = Mth.clamp(f * f * 0.7F - 0.5F, 0.0F, 1.0F);
            float f3 = Mth.clamp(f * f * 0.6F - 0.7F, 0.0F, 1.0F);
            p_154319_[i] = new Vec3(f1, f2, f3);
        }
    });

    public WireBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

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
        ArrayList<String> edgesBelow = new ArrayList<>();
        ArrayList<String> edgesAbove = new ArrayList<>();
        ArrayList<String> edgesNorth = new ArrayList<>();
        ArrayList<String> edgesSouth = new ArrayList<>();
        if (mainSides.contains("down") || mainSides.contains("up") || mainSides.contains("north") || mainSides.contains("south")) {
            for (int i = 0; i < positions.length; i++) {
                BlockPos position = positions[i];
                boolean isThereBelow = entity.getLevel().getBlockState(position.below()).is(ModBlocks.RED_ALLOY_WIRE.get());
                boolean isThereAbove = entity.getLevel().getBlockState(position.above()).is(ModBlocks.RED_ALLOY_WIRE.get());
                boolean isOccupied = !entity.getLevel().getBlockState(position).isAir();
                WireBlockEntity mainEntity = ((WireBlockEntity) entity.getLevel().getBlockEntity(pos));
                if (isThereBelow) {
                    WireBlockEntity currentEntity = (WireBlockEntity) entity.getLevel().getBlockEntity(position.below());
                    if (mainEntity == null) return;
                    if ((!isOccupied || entity.getLevel().getBlockState(position).is(ModBlocks.RED_ALLOY_WIRE.get())) && WireBlockItem.getSides(currentEntity.getSides()).contains(directions[i].getName())
                            && WireBlockItem.getSides(mainEntity.getSides()).contains("down"))
                        edgesBelow.add(directions[i].getName());
                }
                if (isThereAbove) {
                    WireBlockEntity currentEntity = (WireBlockEntity) entity.getLevel().getBlockEntity(position.above());
                    if (mainEntity == null) return;
                    if ((!isOccupied || entity.getLevel().getBlockState(position).is(ModBlocks.RED_ALLOY_WIRE.get())) && WireBlockItem.getSides(currentEntity.getSides()).contains(directions[i].getName())
                            && WireBlockItem.getSides(mainEntity.getSides()).contains("up"))
                        edgesAbove.add(directions[i].getName());
                }
            }
            positions = new BlockPos[]{pos.east(), pos.west()};
            directions = new Direction[]{Direction.WEST, Direction.EAST};
            for (int i = 0; i < positions.length; i++) {
                BlockPos position = positions[i];
                boolean isThereNorth = entity.getLevel().getBlockState(position.north()).is(ModBlocks.RED_ALLOY_WIRE.get());
                boolean isThereSouth = entity.getLevel().getBlockState(position.south()).is(ModBlocks.RED_ALLOY_WIRE.get());
                boolean isOccupied = !entity.getLevel().getBlockState(position).isAir();
                WireBlockEntity mainEntity = ((WireBlockEntity) entity.getLevel().getBlockEntity(pos));
                if (isThereNorth) {
                    WireBlockEntity currentEntity = (WireBlockEntity) (entity.getLevel().getBlockEntity(position.north()));
                    if (mainEntity == null) return;
                    if ((!isOccupied || entity.getLevel().getBlockState(position).is(ModBlocks.RED_ALLOY_WIRE.get())) && WireBlockItem.getSides(currentEntity.getSides()).contains(directions[i].getName())
                            && WireBlockItem.getSides(mainEntity.getSides()).contains("north"))
                        edgesNorth.add(directions[i].getName());
                }
                if (isThereSouth) {
                    WireBlockEntity currentEntity = (WireBlockEntity) (entity.getLevel().getBlockEntity(position.south()));
                    if (mainEntity == null) return;
                    if ((!isOccupied || entity.getLevel().getBlockState(position).is(ModBlocks.RED_ALLOY_WIRE.get())) && WireBlockItem.getSides(currentEntity.getSides()).contains(directions[i].getName())
                            && WireBlockItem.getSides(mainEntity.getSides()).contains("south"))
                        edgesSouth.add(directions[i].getName());
                }
            }
        }

        renderNearbyConnections(stack, buffer, power, direction, side, entity, currentSides, currentBlockState);
        renderInnerConnections(stack, buffer, power, mainSides);

        renderNorthSideConnections(stack, buffer, power, edgesNorth);
        renderSouthSideConnections(stack, buffer, power, edgesSouth);
        renderAboveSideConnections(stack, buffer, power, edgesAbove);
        renderBelowSideConnections(stack, buffer, power, edgesBelow);

    }

    public static void renderNearbyConnections(PoseStack stack, VertexConsumer buffer, int power, Direction direction, String side, WireBlockEntity entity, ArrayList<String> list, BlockState state) {
        BlockPos pos = entity.getBlockPos();
        BlockState nearbyState = entity.getLevel().getBlockState(pos.relative(direction));
        if ((state.canRedstoneConnectTo(entity.getLevel(), entity.getBlockPos(), direction) && (!list.isEmpty() && list.contains(side))) || (nearbyState.canRedstoneConnectTo(entity.getLevel(), pos.relative(direction), direction) && !nearbyState.is(ModBlocks.RED_ALLOY_WIRE.get()))) {
            if (side.contains("up") || side.contains("down")) {
                if (direction == Direction.NORTH)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, side.contains("up") ? 15f : 1f, 3.5f, 2, 2, 7, 0, 0, 7, 2);
                if (direction == Direction.EAST)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 12.5f, side.contains("up") ? 15f : 1f, 8, 7, 2, 2, 0, 0, 2, 7);
                if (direction == Direction.SOUTH)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, side.contains("up") ? 15f : 1f, 12.5f, 2, 2, 7, 0, 0, 7, 2);
                if (direction == Direction.WEST)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 3.5f, side.contains("up") ? 15f : 1f, 8, 7, 2, 2, 0, 0, 2, 7);
            }
            if (side.contains("south") || side.contains("north")) {
                if (direction == Direction.UP)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, 12.5f, side.contains("south") ? 15f : 1f, 2, 7, 2, 0, 0, 7, 2);
                if (direction == Direction.DOWN)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, 3.5f, side.contains("south") ? 15f : 1f, 2, 7, 2, 0, 0, 7, 2);
                if (direction == Direction.EAST)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 12.5f, 8, side.contains("south") ? 15f : 1f, 7, 2, 2, 0, 0, 2, 7);
                if (direction == Direction.WEST)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 3.5f, 8, side.contains("south") ? 15f : 1f, 7, 2, 2, 0, 0, 2, 7);
            }
            if (side.contains("east") || side.contains("west")) {
                if (direction == Direction.UP)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 12.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
                if (direction == Direction.DOWN)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 3.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
                if (direction == Direction.NORTH)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 8, 3.5f, 2, 2, 7, 0, 0, 7, 2);
                if (direction == Direction.SOUTH)
                    drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), side.contains("east") ? 15f : 1f, 8, 12.5f, 2, 2, 7, 0, 0, 7, 2);
            }
        }
    }

    public static void renderInnerConnections(PoseStack stack, VertexConsumer buffer, int power, ArrayList<String> list) {
        if (list.contains("west") && list.contains("south")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1f, 8, 12.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 4.5f, 8, 15f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (list.contains("west") && list.contains("north")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1f, 8, 3.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 4.5f, 8, 1f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (list.contains("east") && list.contains("north")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15f, 8, 3.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 11.5f, 8, 1f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (list.contains("east") && list.contains("south")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15f, 8, 12.5f, 2, 2, 7, 0, 0, 7, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 11.5f, 8, 15f, 5, 2, 2, 0, 0, 2, 7);
        }
        if (list.contains("north") && (list.contains("up") || list.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, list.contains("up") ? 12.5f : 3.5f, 1f, 2, 7, 2, 0, 0, 5, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, list.contains("up") ? 15f : 1f, 4.5f, 2, 2, 5, 0, 0, 5, 2);
        }
        if (list.contains("east") && (list.contains("up") || list.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 15f, list.contains("up") ? 12.5f : 3.5f, 8f, 2, 7, 2, 0, 0, 2, 5);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 11.5f, list.contains("up") ? 15f : 1f, 8f, 5, 2, 2, 0, 0, 5, 2);
        }
        if (list.contains("south") && (list.contains("up") || list.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, list.contains("up") ? 12.5f : 3.5f, 15f, 2, 7, 2, 0, 0, 5, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, list.contains("up") ? 15f : 1f, 11.5f, 2, 2, 5, 0, 0, 5, 2);
        }
        if (list.contains("west") && (list.contains("up") || list.contains("down"))) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 1f, list.contains("up") ? 12.5f : 3.5f, 8f, 2, 7, 2, 0, 0, 2, 5);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 4.5f, list.contains("up") ? 15f : 1f, 8f, 5, 2, 2, 0, 0, 5, 2);
        }
    }

    public static void renderSouthSideConnections(PoseStack stack, VertexConsumer buffer, int power, ArrayList<String> list) {
        if (list.contains("east")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), -1, 8, 18.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 3.5f, 8f, 15f, 7, 2, 2, 0, 0, 7, 2);
        }
        if (list.contains("west")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 17, 8, 18.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 12.5f, 8f, 15f, 7, 2, 2, 0, 0, 7, 2);
        }
    }

    public static void renderNorthSideConnections(PoseStack stack, VertexConsumer buffer, int power, ArrayList<String> list) {
        if (list.contains("east")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), -1, 8, -2.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 3.5f, 8f, 1f, 7, 2, 2, 0, 0, 7, 2);
        }
        if (list.contains("west")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 17, 8, -2.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 12.5f, 8f, 1f, 7, 2, 2, 0, 0, 7, 2);
        }
    }

    public static void renderAboveSideConnections(PoseStack stack, VertexConsumer buffer, int power, ArrayList<String> list) {
        if (list.contains("north")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 15, 13.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, 19.5f, 17f, 2, 7, 2, 0, 0, 2, 7);
        }
        if (list.contains("east")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 2.5f, 15, 8f, 9, 2, 2, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), -1f, 19.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
        }
        if (list.contains("south")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 15, 2.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, 19.5f, -1f, 2, 7, 2, 0, 0, 2, 7);
        }
        if (list.contains("west")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 13.5f, 15, 8f, 9, 2, 2, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 17f, 19.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
        }
    }

    public static void renderBelowSideConnections(PoseStack stack, VertexConsumer buffer, int power, ArrayList<String> list) {
        if (list.contains("north")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 1f, 13.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, -3.5f, 17f, 2, 7, 2, 0, 0, 2, 7);
        }
        if (list.contains("east")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 2.5f, 1f, 8f, 9, 2, 2, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), -1f, -3.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
        }
        if (list.contains("south")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8, 1f, 2.5f, 2, 2, 9, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 8f, -3.5f, -1f, 2, 7, 2, 0, 0, 2, 7);
        }
        if (list.contains("west")) {
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 13.5f, 1f, 8f, 9, 2, 2, 0, 0, 9, 2);
            drawBox(stack, buffer, getColorForPower(power), new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), 17f, -3.5f, 8f, 2, 7, 2, 0, 0, 2, 7);
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
        return Mth.color((float) vec3.x(), (float) vec3.y(), (float) vec3.z());
    }

    @Override
    public void render(@NotNull WireBlockEntity entity, float pPartialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay) {
        ArrayList<String> sides = WireBlockItem.getSides(entity.getSides());
        VertexConsumer boxVertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(TextureAtlas.LOCATION_BLOCKS));
        Direction[] directions = {Direction.UP, Direction.DOWN, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
        BlockState state = entity.getLevel().getBlockState(entity.getBlockPos());
        if (state.is(Blocks.AIR)) return;
        int powerValue = state.getValue(WireBlock.POWER);
        int power = 0;
        if (state.is(ModBlocks.RED_ALLOY_WIRE.get()) && powerValue > 0)
            power = (int) Math.floor(powerValue / 15f); // max = 300

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

}
