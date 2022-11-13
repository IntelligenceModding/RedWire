package de.unhappycodings.redwire.redwiredoors.common.blockentity;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RedwireDoors.MOD_ID);

    public static final RegistryObject<BlockEntityType<BigSlidingDoorEntity>> BIG_SLIDING_DOOR = BLOCK_ENTITIES.register("big_sliding_door", () -> BlockEntityType.Builder.of((pos, state) -> new BigSlidingDoorEntity(pos, state, new ResourceLocation(RedwireDoors.MOD_ID, "textures/geo/textures/stone_big_sliding_door.png"), ModBlockEntities.BIG_SLIDING_DOOR), ModBlocks.BIG_SLIDING_DOOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<PlayerSensorEntity>> WHITE_PLAYER_SENSOR_BLOCK = BLOCK_ENTITIES.register("white_player_sensor_block", () -> BlockEntityType.Builder.of((pos, state) -> new PlayerSensorEntity(pos, state, ModBlockEntities.WHITE_PLAYER_SENSOR_BLOCK), ModBlocks.WHITE_PLAYER_SENSOR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<PlayerSensorEntity>> GRAY_PLAYER_SENSOR_BLOCK = BLOCK_ENTITIES.register("gray_player_sensor_block", () -> BlockEntityType.Builder.of((pos, state) -> new PlayerSensorEntity(pos, state, ModBlockEntities.GRAY_PLAYER_SENSOR_BLOCK), ModBlocks.GRAY_PLAYER_SENSOR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<PlayerSensorEntity>> BLACK_PLAYER_SENSOR_BLOCK = BLOCK_ENTITIES.register("black_player_sensor_block", () -> BlockEntityType.Builder.of((pos, state) -> new PlayerSensorEntity(pos, state, ModBlockEntities.BLACK_PLAYER_SENSOR_BLOCK), ModBlocks.BLACK_PLAYER_SENSOR_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<BoundingBlockEntity>> BOUNDING_BLOCK = BLOCK_ENTITIES.register("bounding", () -> BlockEntityType.Builder.of(BoundingBlockEntity::new, ModBlocks.BOUNDING.get()).build(null));

    private ModBlockEntities() {
    }

}
