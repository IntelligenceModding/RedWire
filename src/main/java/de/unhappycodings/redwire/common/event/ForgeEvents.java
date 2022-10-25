package de.unhappycodings.redwire.common.event;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix4f;
import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.config.CommonConfig;
import de.unhappycodings.redwire.common.item.LinkingCardItem;
import de.unhappycodings.redwire.common.util.NbtUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@Mod.EventBusSubscriber(modid = RedwireCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    private static int[] rgbColour = {255, 0, 0};
    private static boolean countFirst = false;

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void renderSquareAboveWorldCentre(RenderLevelLastEvent event) {
        Player player = Minecraft.getInstance().player;
        ItemStack item = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (item.isEmpty()) return;
        if (item.getItem() instanceof LinkingCardItem) {
            CompoundTag nbt = item.getOrCreateTag();
            if (!nbt.contains("positions")) return;
            for (Tag tag : nbt.getList("positions", Tag.TAG_COMPOUND)) {
                CompoundTag positionTag = (CompoundTag) tag;
                BlockPos posToRenderSquareAt = NbtUtil.getPos(positionTag);
                Minecraft minecraft = Minecraft.getInstance();
                Vec3 cameraPos = minecraft.gameRenderer.getMainCamera().getPosition();

                RenderSystem.disableDepthTest();
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);

                Matrix4f matrix = event.getPoseStack().last().pose();
                RenderSystem.setTextureMatrix(matrix);
                Tesselator tes = Tesselator.getInstance();
                BufferBuilder buffer = tes.getBuilder();
                buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

                // Translate the positions back to the point of the block.
                float x = (float) (-cameraPos.x + posToRenderSquareAt.getX());
                float y = (float) (-cameraPos.y + posToRenderSquareAt.getY());
                float z = (float) (-cameraPos.z + posToRenderSquareAt.getZ());

                Color color = Color.decode(CommonConfig.LINKING_TOOL_OVERLAY_COLOR.get());

                if (CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.get()) {
                    if (!countFirst) {
                        rgbColour[0]--;
                        rgbColour[1]++;
                        if (rgbColour[0] <= 0)
                            countFirst = true;
                    } else {
                        if (rgbColour[1] <= 0) {
                            if (rgbColour[2] > 0) {
                                rgbColour[0]++;
                                rgbColour[2]--;
                            } else {
                                countFirst = false;
                            }
                        } else {
                            rgbColour[1]--;
                            rgbColour[2]++;
                        }
                    }
                    color = new Color(rgbColour[0], rgbColour[1], rgbColour[2]);
                }

                float r = color.getRed() / 255f;
                float g = color.getGreen() / 255f;
                float b = color.getBlue() / 255f;
                float a = 0.5f;
                float offset = 0;

                // Down
                buffer.vertex(matrix, x + 0, y + 0 - offset, z + 0).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 0 - offset, z + 0).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 0 - offset, z + 1).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0, y + 0 - offset, z + 1).color(r, g, b, a).endVertex();

                // Up
                buffer.vertex(matrix, x + 0, y + 1 + offset, z + 0).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0, y + 1 + offset, z + 1).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 1 + offset, z + 1).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 1 + offset, z + 0).color(r, g, b, a).endVertex();

                // North
                buffer.vertex(matrix, x + 0, y + 1, z + 0 - offset).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 1, z + 0 - offset).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 0, z + 0 - offset).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0, y + 0, z + 0 - offset).color(r, g, b, a).endVertex();

                // South
                buffer.vertex(matrix, x + 0, y + 1, z + 1 + offset).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0, y + 0, z + 1 + offset).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 0, z + 1 + offset).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1, y + 1, z + 1 + offset).color(r, g, b, a).endVertex();

                // East
                buffer.vertex(matrix, x + 0 - offset, y + 1, z + 0).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0 - offset, y + 0, z + 0).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0 - offset, y + 0, z + 1).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 0 - offset, y + 1, z + 1).color(r, g, b, a).endVertex();

                // West
                buffer.vertex(matrix, x + 1 + offset, y + 1, z + 0).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1 + offset, y + 1, z + 1).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1 + offset, y + 0, z + 1).color(r, g, b, a).endVertex();
                buffer.vertex(matrix, x + 1 + offset, y + 0, z + 0).color(r, g, b, a).endVertex();

                tes.end();
                RenderSystem.enableDepthTest();
                RenderSystem.depthFunc(0x207);
            }
        }
    }

}
