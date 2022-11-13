package de.unhappycodings.redwire.redwiredoors.common.block;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.ModBlockEntities;
import de.unhappycodings.redwire.redwiredoors.common.registration.Registration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<BigSlidingDoorBlock> BIG_SLIDING_DOOR = register("big_sliding_door", () -> new BigSlidingDoorBlock(ModBlockEntities.BIG_SLIDING_DOOR));

    public static final RegistryObject<PlayerSensorBlock> WHITE_PLAYER_SENSOR_BLOCK = register("white_player_sensor_block", () -> new PlayerSensorBlock(ModBlockEntities.WHITE_PLAYER_SENSOR_BLOCK));
    public static final RegistryObject<PlayerSensorBlock> GRAY_PLAYER_SENSOR_BLOCK = register("gray_player_sensor_block", () -> new PlayerSensorBlock(ModBlockEntities.GRAY_PLAYER_SENSOR_BLOCK));
    public static final RegistryObject<PlayerSensorBlock> BLACK_PLAYER_SENSOR_BLOCK = register("black_player_sensor_block", () -> new PlayerSensorBlock(ModBlockEntities.BLACK_PLAYER_SENSOR_BLOCK));
    public static final RegistryObject<BoundingBlock> BOUNDING = registerNoTab("bounding", BoundingBlock::new);


    private ModBlocks() {
        throw new IllegalStateException("ModBlocks class");
    }

    public static void register() {
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(RedwireDoors.creativeTab)));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerNoTab(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Supplier<BlockItem> blockItem) {
        RegistryObject<T> registryObject = registerNoItem(name, block);
        Registration.ITEMS.register(name, blockItem);
        return registryObject;
    }

}
