package de.unhappycodings.redwire.redwirelampsandlighting;

import de.unhappycodings.redwire.redwirelampsandlighting.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirelampsandlighting.common.item.ModItems;
import de.unhappycodings.redwire.redwirelampsandlighting.common.registration.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RedwireLampsAndLighting.MOD_ID)
public class RedwireLampsAndLighting {

    public static final String MOD_ID = "redwirelampsandlighting";
    public static final CreativeModeTab creativeTab = new ItemCreativeTab();

    public RedwireLampsAndLighting() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.register();
        ModItems.register();
        ModBlocks.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

}
