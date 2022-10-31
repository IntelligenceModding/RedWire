package de.unhappycodings.redwire.redwiredoors.common.blockentity;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITY_TYPES, RedwireDoors.MOD_ID);

    public static final RegistryObject<BlockEntityType<BigSlidingDoorEntity>> STONE_BIG_SLIDING_DOOR =
            BLOCK_ENTITIES.register("stone_big_sliding_door", () -> BlockEntityType.Builder.of((pos, state) -> new BigSlidingDoorEntity(
                    pos, state, new ResourceLocation(RedwireDoors.MOD_ID, "textures/geo/textures/stone_big_sliding_door.png"),
                    ModBlockEntities.STONE_BIG_SLIDING_DOOR), ModBlocks.STONE_BIG_SLIDING_DOOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<PlayerSensorEntity>> STONE_PLAYER_SENSOR_BLOCK =
            BLOCK_ENTITIES.register("stone_player_sensor_block", () ->
                    BlockEntityType.Builder.of((pos, state) -> new PlayerSensorEntity(
                            pos, state, ModBlockEntities.STONE_PLAYER_SENSOR_BLOCK), ModBlocks.STONE_PLAYER_SENSOR_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<BoundingBlockEntity>> BOUNDING_BLOCK =
            BLOCK_ENTITIES.register("bounding", () ->
                    BlockEntityType.Builder.of(BoundingBlockEntity::new, ModBlocks.BOUNDING.get()).build(null));

    private ModBlockEntities() {
    }

}
