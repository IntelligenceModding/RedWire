package de.unhappycodings.redwire.common.blockentity;

import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RedwireCore.MOD_ID);

    private ModBlockEntities() {
    }    public static final RegistryObject<BlockEntityType<WirelessControllerEntity>> WIRELESS_CONTROLLER =
            BLOCK_ENTITIES.register("wireless_controller", () ->
                    BlockEntityType.Builder.of(WirelessControllerEntity::new, ModBlocks.WIRELESS_CONTROLLER.get()).build(null));



}
