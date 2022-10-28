package de.unhappycodings.redwire.redwiredoors.client.event;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.client.render.BigSlidingDoorRenderer;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.ModBlockEntities;
import de.unhappycodings.redwire.redwiredoors.common.registration.Registration;
import de.unhappycodings.redwire.redwiredoors.common.util.ItemUtil;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = RedwireDoors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    private ClientEvents() {
        throw new IllegalStateException("ClientEvent class");
    }

    @SubscribeEvent
    public static void onStartupEvent(FMLClientSetupEvent event) {
        Collection<RegistryObject<Block>> blockList = Registration.BLOCKS.getEntries();
        for (RegistryObject<Block> block : blockList) {
            String registryName = ItemUtil.getRegString(block.get());
            if (registryName.contains("big_sliding_door") || registryName.contains("bounding") || registryName.contains("glass")) {
                ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.translucent());
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.STONE_BIG_SLIDING_DOOR.get(), BigSlidingDoorRenderer::new);
    }

}
