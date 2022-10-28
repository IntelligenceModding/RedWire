package de.unhappycodings.redwire.redwiredoors;

import de.unhappycodings.redwire.redwiredoors.common.ItemCreativeTab;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.ModBlockEntities;
import de.unhappycodings.redwire.redwiredoors.common.registration.Registration;
import de.unhappycodings.redwire.redwiredoors.common.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(RedwireDoors.MOD_ID)
public class RedwireDoors {

    public static final int MOD_COLOR = 0x00b497;
    public static final int MOD_COLOR_SUB = 0x13C6A6;
    public static final String MOD_ID = "redwiredoors";
    public static final CreativeModeTab creativeTab = new ItemCreativeTab();

    public RedwireDoors() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModSounds.register();
        GeckoLib.initialize();
        Registration.register();
        ModBlocks.register();
        ModBlockEntities.BLOCK_ENTITIES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}
