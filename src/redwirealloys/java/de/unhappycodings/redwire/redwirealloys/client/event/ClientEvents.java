package de.unhappycodings.redwire.redwirealloys.client.event;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.client.render.WireBlockEntityRenderer;
import de.unhappycodings.redwire.redwirealloys.common.blockentity.ModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = RedwireAlloys.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.RED_ALLOY_WIRE.get(), WireBlockEntityRenderer::new);
    }

}
