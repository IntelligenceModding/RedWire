package de.unhappycodings.redwire.redwirealloys.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import de.unhappycodings.redwire.redwirealloys.common.blockentity.WireBlockEntity;
import de.unhappycodings.redwire.redwirealloys.common.item.WireBlockItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WireBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<WireBlockEntity> {

    public WireBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(@NotNull WireBlockEntity entity, float pPartialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay) {
        ArrayList<String> sides = WireBlockItem.getSides(entity.getSides());
        System.out.println(sides);
        if (sides.contains("down")) {
            poseStack.pushPose();

            //TODO: RENDER STUFF

            poseStack.popPose();
        }
    }

}
