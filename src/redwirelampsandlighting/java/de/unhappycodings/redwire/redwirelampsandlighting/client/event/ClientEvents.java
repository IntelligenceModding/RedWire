package de.unhappycodings.redwire.redwirelampsandlighting.client.event;

import de.unhappycodings.redwire.redwirelampsandlighting.RedwireLampsAndLighting;
import de.unhappycodings.redwire.redwirelampsandlighting.common.registration.Registration;
import de.unhappycodings.redwire.redwirelampsandlighting.common.util.ItemUtil;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = RedwireLampsAndLighting.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onStartupEvent(FMLClientSetupEvent event) {

        Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
            if (ItemUtil.getRegString(block).contains("lamp"))
                ItemBlockRenderTypes.setRenderLayer(block, (renderType) -> renderType == RenderType.translucent() || renderType == RenderType.cutoutMipped());
        });

    }

}
