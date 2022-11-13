package de.unhappycodings.redwire.redwirealloys.common.blockentity;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.common.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RedwireAlloys.MOD_ID);

    public static final RegistryObject<BlockEntityType<WireBlockEntity>> RED_ALLOY_WIRE = BLOCK_ENTITIES.register("red_alloy_wire",
            () -> BlockEntityType.Builder.of((pos, state) -> new WireBlockEntity(pos, state, ModBlockEntities.RED_ALLOY_WIRE), ModBlocks.RED_ALLOY_WIRE.get()).build(null));

    private ModBlockEntities() {

    }

}
