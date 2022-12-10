package de.unhappycodings.redwire;

import com.mojang.logging.LogUtils;
import de.unhappycodings.redwire.common.ItemCreativeTab;
import de.unhappycodings.redwire.common.block.ModBlocks;
import de.unhappycodings.redwire.common.blockentity.ModBlockEntities;
import de.unhappycodings.redwire.common.config.CommonConfig;
import de.unhappycodings.redwire.common.item.ModItems;
import de.unhappycodings.redwire.common.registration.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

@Mod(RedwireCore.MOD_ID)
public class RedwireCore {

    public static final int MOD_COLOR = 0x00b497;
    public static final int MOD_COLOR_SUB = 0x13C6A6;
    public static final String MOD_ID = "redwirecore";
    public static final CreativeModeTab creativeTab = new ItemCreativeTab();
    private static final Logger LOGGER = LogUtils.getLogger();

    public RedwireCore() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.register();
        ModItems.register();
        ModBlocks.register();

        ModBlockEntities.BLOCK_ENTITIES.register(bus);

        CommonConfig.loadConfigFile(CommonConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("redwirecore-common.toml").toString());
        MinecraftForge.EVENT_BUS.register(this);
    }

}
