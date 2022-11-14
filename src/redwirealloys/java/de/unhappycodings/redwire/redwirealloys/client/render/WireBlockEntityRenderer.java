package de.unhappycodings.redwire.redwirealloys.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.client.util.RenderUtil;
import de.unhappycodings.redwire.redwirealloys.common.blockentity.WireBlockEntity;
import de.unhappycodings.redwire.redwirealloys.common.item.WireBlockItem;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
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
        System.out.println(sides);
        if (sides.contains("down")) {
            poseStack.pushPose();

            RenderUtil.drawPlane(poseStack, boxVertexConsumer, new ResourceLocation(RedwireAlloys.MOD_ID, "block/wire"), RenderUtil.Perspective.UP, 0.0625f * 7, 0.0625f, 0.0625f * 7, -0.0625f * 7, 0.0625f, -0.0625f * 7, 0, 0, 2, 2, 0.0625f * 7, 0.0625f * 7);
            //TODO: RENDER STUFF

            poseStack.popPose();
        }
    }

    public static int getColorForPower(int pPower) {
        Vec3 vec3 = COLORS[pPower];
        return Mth.color((float)vec3.x(), (float)vec3.y(), (float)vec3.z());
    }

}
