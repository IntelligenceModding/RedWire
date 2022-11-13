package de.unhappycodings.redwire.redwirealloys;

import de.unhappycodings.redwire.redwirealloys.common.ItemCreativeTab;
import de.unhappycodings.redwire.redwirealloys.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirealloys.common.blockentity.ModBlockEntities;
import de.unhappycodings.redwire.redwirealloys.common.item.ModItems;
import de.unhappycodings.redwire.redwirealloys.common.registration.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RedwireAlloys.MOD_ID)
public class RedwireAlloys {

    public static final int MOD_COLOR = 0x00b497;
    public static final int MOD_COLOR_SUB = 0x13C6A6;
    public static final String MOD_ID = "redwirealloys";
    public static final CreativeModeTab creativeTab = new ItemCreativeTab();

    public RedwireAlloys() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.register();
        ModBlocks.register();
        ModItems.register();
        ModBlockEntities.BLOCK_ENTITIES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}
