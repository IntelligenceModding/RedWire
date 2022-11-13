package de.unhappycodings.redwire.redwiredoors.client.event;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.client.render.BigSlidingDoorRenderer;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.ModBlockEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RedwireDoors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    private ClientEvents() {
        throw new IllegalStateException("ClientEvent class");
    }

    @SubscribeEvent
    public static void onStartupEvent(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIG_SLIDING_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BOUNDING.get(), RenderType.translucent());

    }

    @SubscribeEvent
    public static void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.BIG_SLIDING_DOOR.get(), BigSlidingDoorRenderer::new);
    }

}
