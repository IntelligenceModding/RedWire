package de.unhappycodings.redwire.redwiredoors.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.BigSlidingDoorEntity;
import de.unhappycodings.redwire.redwiredoors.common.geckolib.BigSlidingDoorModel;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class BigSlidingDoorRenderer<T extends BlockEntity & IAnimatable> extends GeoBlockRenderer<BigSlidingDoorEntity> {
    private final AnimatedGeoModel<T> modelProvider;

    public BigSlidingDoorRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new BigSlidingDoorModel());
        this.modelProvider = (AnimatedGeoModel<T>) new BigSlidingDoorModel();
    }

    @Override
    public void render(BigSlidingDoorEntity tile, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
        GeoModel model = modelProvider.getModel(modelProvider.getModelResource((T) tile));
        modelProvider.setLivingAnimations((T) tile, this.getUniqueID(tile));
        stack.pushPose();
        stack.translate(0, 0.01f, 0);
        stack.translate(0.5, 0, 0.5);

        rotateBlock(getFacing((T) tile), stack);

        RenderSystem.setShaderTexture(0, getTextureLocation(tile));
        Color renderColor = getRenderColor(tile, partialTicks, stack, bufferIn, null, packedLightIn);
        RenderType renderType = getRenderType(tile, partialTicks, stack, bufferIn, null, packedLightIn,
                getTextureLocation(tile));

        render(model, tile, partialTicks, renderType, stack, bufferIn, null, packedLightIn, OverlayTexture.NO_OVERLAY,
                (float) renderColor.getRed() / 255f, (float) renderColor.getGreen() / 255f,
                (float) renderColor.getBlue() / 255f, (float) renderColor.getAlpha() / 255);
        stack.popPose();
    }

    private Direction getFacing(T tile) {
        BlockState blockState = tile.getBlockState();
        if (blockState.hasProperty(HorizontalDirectionalBlock.FACING)) {
            return blockState.getValue(HorizontalDirectionalBlock.FACING);
        } else if (blockState.hasProperty(DirectionalBlock.FACING)) {
            return blockState.getValue(DirectionalBlock.FACING);
        } else {
            return Direction.NORTH;
        }
    }

    @Override
    public boolean shouldRenderOffScreen(@NotNull BlockEntity entity) {
        return true;
    }

    @Override
    public boolean shouldRender(@NotNull BlockEntity entity, @NotNull Vec3 vec3) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(BigSlidingDoorEntity instance) {
        return instance.getTexture();
    }

    @Override
    public RenderType getRenderType(BigSlidingDoorEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        boolean isFabulous = Minecraft.getInstance().options.graphicsMode().equals(GraphicsStatus.FABULOUS);
        return isFabulous ? RenderType.itemEntityTranslucentCull(animatable.getTexture()) : RenderType.entityTranslucentCull(animatable.getTexture());
    }
}
