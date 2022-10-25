package de.unhappycodings.redwire.redwirelampsandlighting.common.block;

import de.unhappycodings.redwire.redwirelampsandlighting.RedwireLampsAndLighting;
import de.unhappycodings.redwire.redwirelampsandlighting.common.registration.Registration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final RegistryObject<StoneButtonBlock> WHITE_LAMP_BUTTON = register("white_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> WHITE_LAMP_BUTTON_ENLIGHTED = register("white_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> WHITE_LAMP_BUTTON_TRIGGER = register("white_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> WHITE_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("white_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> WHITE_LAMP_BUTTON_TOGGLE = register("white_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> WHITE_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("white_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> LIGHT_GRAY_LAMP_BUTTON = register("light_gray_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED = register("light_gray_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> LIGHT_GRAY_LAMP_BUTTON_TRIGGER = register("light_gray_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> LIGHT_GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("light_gray_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> LIGHT_GRAY_LAMP_BUTTON_TOGGLE = register("light_gray_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> LIGHT_GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("light_gray_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> GRAY_LAMP_BUTTON = register("gray_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> GRAY_LAMP_BUTTON_ENLIGHTED = register("gray_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> GRAY_LAMP_BUTTON_TRIGGER = register("gray_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("gray_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> GRAY_LAMP_BUTTON_TOGGLE = register("gray_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("gray_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> BLACK_LAMP_BUTTON = register("black_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> BLACK_LAMP_BUTTON_ENLIGHTED = register("black_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> BLACK_LAMP_BUTTON_TRIGGER = register("black_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> BLACK_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("black_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> BLACK_LAMP_BUTTON_TOGGLE = register("black_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> BLACK_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("black_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> YELLOW_LAMP_BUTTON = register("yellow_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> YELLOW_LAMP_BUTTON_ENLIGHTED = register("yellow_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> YELLOW_LAMP_BUTTON_TRIGGER = register("yellow_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> YELLOW_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("yellow_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> YELLOW_LAMP_BUTTON_TOGGLE = register("yellow_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> YELLOW_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("yellow_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> ORANGE_LAMP_BUTTON = register("orange_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> ORANGE_LAMP_BUTTON_ENLIGHTED = register("orange_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> ORANGE_LAMP_BUTTON_TRIGGER = register("orange_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> ORANGE_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("orange_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> ORANGE_LAMP_BUTTON_TOGGLE = register("orange_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> ORANGE_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("orange_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> RED_LAMP_BUTTON = register("red_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> RED_LAMP_BUTTON_ENLIGHTED = register("red_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> RED_LAMP_BUTTON_TRIGGER = register("red_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> RED_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("red_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> RED_LAMP_BUTTON_TOGGLE = register("red_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> RED_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("red_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> GREEN_LAMP_BUTTON = register("green_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> GREEN_LAMP_BUTTON_ENLIGHTED = register("green_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> GREEN_LAMP_BUTTON_TRIGGER = register("green_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> GREEN_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("green_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> GREEN_LAMP_BUTTON_TOGGLE = register("green_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> GREEN_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("green_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> CYAN_LAMP_BUTTON = register("cyan_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> CYAN_LAMP_BUTTON_ENLIGHTED = register("cyan_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> CYAN_LAMP_BUTTON_TRIGGER = register("cyan_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> CYAN_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("cyan_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> CYAN_LAMP_BUTTON_TOGGLE = register("cyan_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> CYAN_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("cyan_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> BLUE_LAMP_BUTTON = register("blue_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> BLUE_LAMP_BUTTON_ENLIGHTED = register("blue_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> BLUE_LAMP_BUTTON_TRIGGER = register("blue_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("blue_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> BLUE_LAMP_BUTTON_TOGGLE = register("blue_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("blue_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> LIGHT_BLUE_LAMP_BUTTON = register("light_blue_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED = register("light_blue_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> LIGHT_BLUE_LAMP_BUTTON_TRIGGER = register("light_blue_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> LIGHT_BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("light_blue_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> LIGHT_BLUE_LAMP_BUTTON_TOGGLE = register("light_blue_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> LIGHT_BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("light_blue_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> PINK_LAMP_BUTTON = register("pink_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> PINK_LAMP_BUTTON_ENLIGHTED = register("pink_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> PINK_LAMP_BUTTON_TRIGGER = register("pink_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> PINK_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("pink_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> PINK_LAMP_BUTTON_TOGGLE = register("pink_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> PINK_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("pink_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> MAGENTA_LAMP_BUTTON = register("magenta_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> MAGENTA_LAMP_BUTTON_ENLIGHTED = register("magenta_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> MAGENTA_LAMP_BUTTON_TRIGGER = register("magenta_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> MAGENTA_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("magenta_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> MAGENTA_LAMP_BUTTON_TOGGLE = register("magenta_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> MAGENTA_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("magenta_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<StoneButtonBlock> PURPLE_LAMP_BUTTON = register("purple_lamp_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)));
    public static final RegistryObject<StoneButtonBlock> PURPLE_LAMP_BUTTON_ENLIGHTED = register("purple_lamp_button_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((x) -> 15)));
    public static final RegistryObject<LampButtonTriggerBlock> PURPLE_LAMP_BUTTON_TRIGGER = register("purple_lamp_button_trigger", () -> new LampButtonTriggerBlock("normal", false));
    public static final RegistryObject<LampButtonTriggerBlock> PURPLE_LAMP_BUTTON_TRIGGER_ENLIGHTED = register("purple_lamp_button_trigger_enlighted", () -> new LampButtonTriggerBlock("normal", true));
    public static final RegistryObject<StoneButtonBlock> PURPLE_LAMP_BUTTON_TOGGLE = register("purple_lamp_button_toggle", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(false))));
    public static final RegistryObject<StoneButtonBlock> PURPLE_LAMP_BUTTON_TOGGLE_ENLIGHTED = register("purple_lamp_button_toggle_enlighted", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(true))));

    public static final RegistryObject<LampStaticBlock> WHITE_LAMP_STATIC = register("white_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> WHITE_LAMP_STATIC_ENLIGHTED = register("white_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> WHITE_LAMP = register("white_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> WHITE_LAMP_ENLIGHTED = register("white_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> LIGHT_GRAY_LAMP_STATIC = register("light_gray_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> LIGHT_GRAY_LAMP_STATIC_ENLIGHTED = register("light_gray_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> LIGHT_GRAY_LAMP = register("light_gray_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> LIGHT_GRAY_LAMP_ENLIGHTED = register("light_gray_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> GRAY_LAMP_STATIC = register("gray_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> GRAY_LAMP_STATIC_ENLIGHTED = register("gray_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> GRAY_LAMP = register("gray_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> GRAY_LAMP_ENLIGHTED = register("gray_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> BLACK_LAMP_STATIC = register("black_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> BLACK_LAMP_STATIC_ENLIGHTED = register("black_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> BLACK_LAMP = register("black_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> BLACK_LAMP_ENLIGHTED = register("black_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> YELLOW_LAMP_STATIC = register("yellow_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> YELLOW_LAMP_STATIC_ENLIGHTED = register("yellow_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> YELLOW_LAMP = register("yellow_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> YELLOW_LAMP_ENLIGHTED = register("yellow_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> ORANGE_LAMP_STATIC = register("orange_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> ORANGE_LAMP_STATIC_ENLIGHTED = register("orange_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> ORANGE_LAMP = register("orange_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> ORANGE_LAMP_ENLIGHTED = register("orange_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> RED_LAMP_STATIC = register("red_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> RED_LAMP_STATIC_ENLIGHTED = register("red_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> RED_LAMP = register("red_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> RED_LAMP_ENLIGHTED = register("red_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> GREEN_LAMP_STATIC = register("green_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> GREEN_LAMP_STATIC_ENLIGHTED = register("green_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> GREEN_LAMP = register("green_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> GREEN_LAMP_ENLIGHTED = register("green_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> CYAN_LAMP_STATIC = register("cyan_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> CYAN_LAMP_STATIC_ENLIGHTED = register("cyan_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> CYAN_LAMP = register("cyan_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> CYAN_LAMP_ENLIGHTED = register("cyan_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> BLUE_LAMP_STATIC = register("blue_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> BLUE_LAMP_STATIC_ENLIGHTED = register("blue_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> BLUE_LAMP = register("blue_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> BLUE_LAMP_ENLIGHTED = register("blue_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> LIGHT_BLUE_LAMP_STATIC = register("light_blue_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> LIGHT_BLUE_LAMP_STATIC_ENLIGHTED = register("light_blue_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> LIGHT_BLUE_LAMP = register("light_blue_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> LIGHT_BLUE_LAMP_ENLIGHTED = register("light_blue_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> PINK_LAMP_STATIC = register("pink_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> PINK_LAMP_STATIC_ENLIGHTED = register("pink_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> PINK_LAMP = register("pink_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> PINK_LAMP_ENLIGHTED = register("pink_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> MAGENTA_LAMP_STATIC = register("magenta_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> MAGENTA_LAMP_STATIC_ENLIGHTED = register("magenta_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> MAGENTA_LAMP = register("magenta_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> MAGENTA_LAMP_ENLIGHTED = register("magenta_lamp_block_enlighted", () -> new LampBlock(""));
    public static final RegistryObject<LampStaticBlock> PURPLE_LAMP_STATIC = register("purple_lamp_block_static", () -> new LampStaticBlock(false));
    public static final RegistryObject<LampStaticBlock> PURPLE_LAMP_STATIC_ENLIGHTED = register("purple_lamp_block_static_enlighted", () -> new LampStaticBlock(true));
    public static final RegistryObject<RedstoneLampBlock> PURPLE_LAMP = register("purple_lamp_block", LampBlock::new);
    public static final RegistryObject<RedstoneLampBlock> PURPLE_LAMP_ENLIGHTED = register("purple_lamp_block_enlighted", () -> new LampBlock(""));

    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT = register("white_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_ENLIGHTED = register("white_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_FRAMED = register("white_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_FRAMED_ENLIGHTED = register("white_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_BIG = register("white_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_BIG_ENLIGHTED = register("white_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_BIG_FRAMED = register("white_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("white_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_HUGE = register("white_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_HUGE_ENLIGHTED = register("white_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_HUGE_FRAMED = register("white_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> WHITE_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("white_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT = register("light_gray_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_ENLIGHTED = register("light_gray_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_FRAMED = register("light_gray_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_FRAMED_ENLIGHTED = register("light_gray_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_BIG = register("light_gray_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_BIG_ENLIGHTED = register("light_gray_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_BIG_FRAMED = register("light_gray_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("light_gray_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_HUGE = register("light_gray_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_HUGE_ENLIGHTED = register("light_gray_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_HUGE_FRAMED = register("light_gray_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> LIGHT_GRAY_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("light_gray_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));


    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT = register("gray_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_ENLIGHTED = register("gray_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_FRAMED = register("gray_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_FRAMED_ENLIGHTED = register("gray_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_BIG = register("gray_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_BIG_ENLIGHTED = register("gray_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_BIG_FRAMED = register("gray_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("gray_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_HUGE = register("gray_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_HUGE_ENLIGHTED = register("gray_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_HUGE_FRAMED = register("gray_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> GRAY_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("gray_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT = register("black_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_ENLIGHTED = register("black_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_FRAMED = register("black_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_FRAMED_ENLIGHTED = register("black_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_BIG = register("black_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_BIG_ENLIGHTED = register("black_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_BIG_FRAMED = register("black_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("black_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_HUGE = register("black_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_HUGE_ENLIGHTED = register("black_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_HUGE_FRAMED = register("black_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> BLACK_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("black_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT = register("green_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_ENLIGHTED = register("green_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_FRAMED = register("green_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_FRAMED_ENLIGHTED = register("green_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_BIG = register("green_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_BIG_ENLIGHTED = register("green_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_BIG_FRAMED = register("green_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("green_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_HUGE = register("green_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_HUGE_ENLIGHTED = register("green_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_HUGE_FRAMED = register("green_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> GREEN_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("green_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT = register("cyan_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_ENLIGHTED = register("cyan_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_FRAMED = register("cyan_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_FRAMED_ENLIGHTED = register("cyan_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_BIG = register("cyan_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_BIG_ENLIGHTED = register("cyan_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_BIG_FRAMED = register("cyan_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("cyan_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_HUGE = register("cyan_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_HUGE_ENLIGHTED = register("cyan_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_HUGE_FRAMED = register("cyan_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> CYAN_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("cyan_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT = register("blue_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_ENLIGHTED = register("blue_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_FRAMED = register("blue_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_FRAMED_ENLIGHTED = register("blue_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_BIG = register("blue_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_BIG_ENLIGHTED = register("blue_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_BIG_FRAMED = register("blue_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("blue_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_HUGE = register("blue_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_HUGE_ENLIGHTED = register("blue_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_HUGE_FRAMED = register("blue_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> BLUE_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("blue_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT = register("light_blue_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_ENLIGHTED = register("light_blue_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_FRAMED = register("light_blue_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_FRAMED_ENLIGHTED = register("light_blue_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_BIG = register("light_blue_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_BIG_ENLIGHTED = register("light_blue_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_BIG_FRAMED = register("light_blue_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("light_blue_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_HUGE = register("light_blue_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_HUGE_ENLIGHTED = register("light_blue_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_HUGE_FRAMED = register("light_blue_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> LIGHT_BLUE_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("light_blue_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT = register("red_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_ENLIGHTED = register("red_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_FRAMED = register("red_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_FRAMED_ENLIGHTED = register("red_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_BIG = register("red_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_BIG_ENLIGHTED = register("red_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_BIG_FRAMED = register("red_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("red_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_HUGE = register("red_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_HUGE_ENLIGHTED = register("red_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_HUGE_FRAMED = register("red_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> RED_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("red_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT = register("orange_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_ENLIGHTED = register("orange_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_FRAMED = register("orange_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_FRAMED_ENLIGHTED = register("orange_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_BIG = register("orange_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_BIG_ENLIGHTED = register("orange_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_BIG_FRAMED = register("orange_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("orange_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_HUGE = register("orange_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_HUGE_ENLIGHTED = register("orange_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_HUGE_FRAMED = register("orange_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> ORANGE_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("orange_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT = register("yellow_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_ENLIGHTED = register("yellow_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_FRAMED = register("yellow_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_FRAMED_ENLIGHTED = register("yellow_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_BIG = register("yellow_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_BIG_ENLIGHTED = register("yellow_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_BIG_FRAMED = register("yellow_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("yellow_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_HUGE = register("yellow_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_HUGE_ENLIGHTED = register("yellow_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_HUGE_FRAMED = register("yellow_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> YELLOW_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("yellow_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT = register("pink_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_ENLIGHTED = register("pink_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_FRAMED = register("pink_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_FRAMED_ENLIGHTED = register("pink_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_BIG = register("pink_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_BIG_ENLIGHTED = register("pink_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_BIG_FRAMED = register("pink_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("pink_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_HUGE = register("pink_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_HUGE_ENLIGHTED = register("pink_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_HUGE_FRAMED = register("pink_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> PINK_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("pink_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT = register("purple_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_ENLIGHTED = register("purple_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_FRAMED = register("purple_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_FRAMED_ENLIGHTED = register("purple_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_BIG = register("purple_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_BIG_ENLIGHTED = register("purple_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_BIG_FRAMED = register("purple_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("purple_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_HUGE = register("purple_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_HUGE_ENLIGHTED = register("purple_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_HUGE_FRAMED = register("purple_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> PURPLE_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("purple_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT = register("magenta_lamp_block_flat", () -> new LampFlatBlock(true, false, "normal"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_ENLIGHTED = register("magenta_lamp_block_flat_enlighted", () -> new LampFlatBlock(true, true, "normal"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_FRAMED = register("magenta_lamp_block_flat_framed", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_FRAMED_ENLIGHTED = register("magenta_lamp_block_flat_framed_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_BIG = register("magenta_lamp_block_flat_big", () -> new LampFlatBlock(true, false, "framed"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_BIG_ENLIGHTED = register("magenta_lamp_block_flat_big_enlighted", () -> new LampFlatBlock(true, true, "framed"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_BIG_FRAMED = register("magenta_lamp_block_flat_big_framed", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_BIG_FRAMED_ENLIGHTED = register("magenta_lamp_block_flat_big_framed_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_HUGE = register("magenta_lamp_block_flat_huge", () -> new LampFlatBlock(true, false, "big"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_HUGE_ENLIGHTED = register("magenta_lamp_block_flat_huge_enlighted", () -> new LampFlatBlock(true, true, "big"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_HUGE_FRAMED = register("magenta_lamp_block_flat_huge_framed", () -> new LampFlatBlock(true, false, "huge"));
    public static final RegistryObject<LampFlatBlock> MAGENTA_LAMP_FLAT_HUGE_FRAMED_ENLIGHTED = register("magenta_lamp_block_flat_huge_framed_enlighted", () -> new LampFlatBlock(true, true, "huge"));

    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP = register("white_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE = register("white_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_LEFT_OPEN = register("white_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_LEFT_OPEN = register("white_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_RIGHT_OPEN = register("white_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN = register("white_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN = register("white_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("white_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_ENLIGHTED = register("white_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_ENLIGHTED = register("white_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("white_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("white_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("white_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("white_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("white_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("white_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP = register("light_gray_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE = register("light_gray_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN = register("light_gray_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN = register("light_gray_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN = register("light_gray_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN = register("light_gray_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN = register("light_gray_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("light_gray_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_ENLIGHTED = register("light_gray_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_ENLIGHTED = register("light_gray_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("light_gray_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("light_gray_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("light_gray_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("light_gray_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("light_gray_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("light_gray_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP = register("gray_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE = register("gray_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_LEFT_OPEN = register("gray_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_LEFT_OPEN = register("gray_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_RIGHT_OPEN = register("gray_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN = register("gray_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN = register("gray_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("gray_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_ENLIGHTED = register("gray_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_ENLIGHTED = register("gray_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("gray_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("gray_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("gray_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("gray_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("gray_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("gray_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP = register("black_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE = register("black_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_LEFT_OPEN = register("black_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_LEFT_OPEN = register("black_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_RIGHT_OPEN = register("black_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN = register("black_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN = register("black_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("black_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_ENLIGHTED = register("black_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_ENLIGHTED = register("black_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("black_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("black_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("black_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("black_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("black_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("black_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP = register("green_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE = register("green_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_LEFT_OPEN = register("green_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_LEFT_OPEN = register("green_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_RIGHT_OPEN = register("green_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN = register("green_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN = register("green_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("green_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_ENLIGHTED = register("green_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_ENLIGHTED = register("green_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("green_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("green_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("green_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("green_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("green_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("green_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP = register("cyan_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE = register("cyan_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_LEFT_OPEN = register("cyan_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_LEFT_OPEN = register("cyan_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_RIGHT_OPEN = register("cyan_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN = register("cyan_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN = register("cyan_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("cyan_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_ENLIGHTED = register("cyan_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_ENLIGHTED = register("cyan_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("cyan_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("cyan_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("cyan_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("cyan_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("cyan_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("cyan_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP = register("blue_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE = register("blue_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_LEFT_OPEN = register("blue_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_LEFT_OPEN = register("blue_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_RIGHT_OPEN = register("blue_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN = register("blue_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN = register("blue_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("blue_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_ENLIGHTED = register("blue_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_ENLIGHTED = register("blue_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("blue_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("blue_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("blue_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("blue_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("blue_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("blue_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP = register("light_blue_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE = register("light_blue_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN = register("light_blue_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN = register("light_blue_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN = register("light_blue_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN = register("light_blue_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN = register("light_blue_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("light_blue_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_ENLIGHTED = register("light_blue_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_ENLIGHTED = register("light_blue_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("light_blue_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("light_blue_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("light_blue_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("light_blue_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("light_blue_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("light_blue_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP = register("yellow_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE = register("yellow_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_LEFT_OPEN = register("yellow_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN = register("yellow_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_RIGHT_OPEN = register("yellow_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN = register("yellow_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN = register("yellow_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("yellow_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_ENLIGHTED = register("yellow_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_ENLIGHTED = register("yellow_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("yellow_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("yellow_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("yellow_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("yellow_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("yellow_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("yellow_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP = register("orange_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE = register("orange_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_LEFT_OPEN = register("orange_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN = register("orange_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_RIGHT_OPEN = register("orange_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN = register("orange_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN = register("orange_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("orange_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_ENLIGHTED = register("orange_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_ENLIGHTED = register("orange_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("orange_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("orange_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("orange_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("orange_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("orange_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("orange_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP = register("red_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE = register("red_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_LEFT_OPEN = register("red_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_LEFT_OPEN = register("red_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_RIGHT_OPEN = register("red_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_RIGHT_OPEN = register("red_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_LEFT_RIGHT_OPEN = register("red_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("red_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_ENLIGHTED = register("red_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_ENLIGHTED = register("red_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("red_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("red_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("red_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("red_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("red_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("red_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP = register("pink_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE = register("pink_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_LEFT_OPEN = register("pink_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_LEFT_OPEN = register("pink_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_RIGHT_OPEN = register("pink_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_RIGHT_OPEN = register("pink_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_LEFT_RIGHT_OPEN = register("pink_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("pink_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_ENLIGHTED = register("pink_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_ENLIGHTED = register("pink_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("pink_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("pink_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("pink_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("pink_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("pink_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("pink_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP = register("magenta_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE = register("magenta_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_LEFT_OPEN = register("magenta_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN = register("magenta_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_RIGHT_OPEN = register("magenta_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN = register("magenta_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN = register("magenta_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("magenta_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_ENLIGHTED = register("magenta_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_ENLIGHTED = register("magenta_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("magenta_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("magenta_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("magenta_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("magenta_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("magenta_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("magenta_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP = register("purple_tube_lamp", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE = register("purple_tube_lamp_edge", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_LEFT_OPEN = register("purple_tube_lamp_left_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN = register("purple_tube_lamp_edge_left_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_RIGHT_OPEN = register("purple_tube_lamp_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN = register("purple_tube_lamp_edge_right_open", () -> new TubeLampEdgeBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN = register("purple_tube_lamp_left_right_open", () -> new TubeLampBlock(true, false));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN = register("purple_tube_lamp_edge_left_right_open", () -> new TubeLampEdgeBlock(true, false));

    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_ENLIGHTED = register("purple_tube_lamp_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_ENLIGHTED = register("purple_tube_lamp_edge_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED = register("purple_tube_lamp_left_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED = register("purple_tube_lamp_edge_left_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED = register("purple_tube_lamp_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED = register("purple_tube_lamp_edge_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED = register("purple_tube_lamp_left_right_open_enlighted", () -> new TubeLampBlock(true, true));
    public static final RegistryObject<TubeLampBlock> PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED = register("purple_tube_lamp_edge_left_right_open_enlighted", () -> new TubeLampEdgeBlock(true, true));

    public static final RegistryObject<LampWallBlock> WHITE_WALL_LAMP = register("white_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> WHITE_WALL_LAMP_ENLIGHTED = register("white_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> WHITE_WALL_LAMP_STATIC = register("white_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> WHITE_WALL_LAMP_STATIC_ENLIGHTED = register("white_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> WHITE_GULP_LAMP = register("white_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> WHITE_GULP_LAMP_ENLIGHTED = register("white_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> WHITE_GULP_LAMP_STATIC = register("white_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> WHITE_GULP_LAMP_STATIC_ENLIGHTED = register("white_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> LIGHT_GRAY_WALL_LAMP = register("light_gray_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> LIGHT_GRAY_WALL_LAMP_ENLIGHTED = register("light_gray_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> LIGHT_GRAY_WALL_LAMP_STATIC = register("light_gray_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED = register("light_gray_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> LIGHT_GRAY_GULP_LAMP = register("light_gray_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> LIGHT_GRAY_GULP_LAMP_ENLIGHTED = register("light_gray_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> LIGHT_GRAY_GULP_LAMP_STATIC = register("light_gray_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED = register("light_gray_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> GRAY_WALL_LAMP = register("gray_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> GRAY_WALL_LAMP_ENLIGHTED = register("gray_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> GRAY_WALL_LAMP_STATIC = register("gray_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> GRAY_WALL_LAMP_STATIC_ENLIGHTED = register("gray_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> GRAY_GULP_LAMP = register("gray_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> GRAY_GULP_LAMP_ENLIGHTED = register("gray_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> GRAY_GULP_LAMP_STATIC = register("gray_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> GRAY_GULP_LAMP_STATIC_ENLIGHTED = register("gray_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> BLACK_WALL_LAMP = register("black_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> BLACK_WALL_LAMP_ENLIGHTED = register("black_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> BLACK_WALL_LAMP_STATIC = register("black_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> BLACK_WALL_LAMP_STATIC_ENLIGHTED = register("black_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> BLACK_GULP_LAMP = register("black_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> BLACK_GULP_LAMP_ENLIGHTED = register("black_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> BLACK_GULP_LAMP_STATIC = register("black_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> BLACK_GULP_LAMP_STATIC_ENLIGHTED = register("black_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> RED_WALL_LAMP = register("red_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> RED_WALL_LAMP_ENLIGHTED = register("red_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> RED_WALL_LAMP_STATIC = register("red_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> RED_WALL_LAMP_STATIC_ENLIGHTED = register("red_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> RED_GULP_LAMP = register("red_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> RED_GULP_LAMP_ENLIGHTED = register("red_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> RED_GULP_LAMP_STATIC = register("red_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> RED_GULP_LAMP_STATIC_ENLIGHTED = register("red_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> ORANGE_WALL_LAMP = register("orange_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> ORANGE_WALL_LAMP_ENLIGHTED = register("orange_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> ORANGE_WALL_LAMP_STATIC = register("orange_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> ORANGE_WALL_LAMP_STATIC_ENLIGHTED = register("orange_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> ORANGE_GULP_LAMP = register("orange_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> ORANGE_GULP_LAMP_ENLIGHTED = register("orange_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> ORANGE_GULP_LAMP_STATIC = register("orange_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> ORANGE_GULP_LAMP_STATIC_ENLIGHTED = register("orange_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> YELLOW_WALL_LAMP = register("yellow_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> YELLOW_WALL_LAMP_ENLIGHTED = register("yellow_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> YELLOW_WALL_LAMP_STATIC = register("yellow_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> YELLOW_WALL_LAMP_STATIC_ENLIGHTED = register("yellow_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> YELLOW_GULP_LAMP = register("yellow_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> YELLOW_GULP_LAMP_ENLIGHTED = register("yellow_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> YELLOW_GULP_LAMP_STATIC = register("yellow_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> YELLOW_GULP_LAMP_STATIC_ENLIGHTED = register("yellow_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> BLUE_WALL_LAMP = register("blue_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> BLUE_WALL_LAMP_ENLIGHTED = register("blue_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> BLUE_WALL_LAMP_STATIC = register("blue_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> BLUE_WALL_LAMP_STATIC_ENLIGHTED = register("blue_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> BLUE_GULP_LAMP = register("blue_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> BLUE_GULP_LAMP_ENLIGHTED = register("blue_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> BLUE_GULP_LAMP_STATIC = register("blue_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> BLUE_GULP_LAMP_STATIC_ENLIGHTED = register("blue_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> LIGHT_BLUE_WALL_LAMP = register("light_blue_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> LIGHT_BLUE_WALL_LAMP_ENLIGHTED = register("light_blue_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> LIGHT_BLUE_WALL_LAMP_STATIC = register("light_blue_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED = register("light_blue_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> LIGHT_BLUE_GULP_LAMP = register("light_blue_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> LIGHT_BLUE_GULP_LAMP_ENLIGHTED = register("light_blue_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> LIGHT_BLUE_GULP_LAMP_STATIC = register("light_blue_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED = register("light_blue_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> CYAN_WALL_LAMP = register("cyan_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> CYAN_WALL_LAMP_ENLIGHTED = register("cyan_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> CYAN_WALL_LAMP_STATIC = register("cyan_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> CYAN_WALL_LAMP_STATIC_ENLIGHTED = register("cyan_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> CYAN_GULP_LAMP = register("cyan_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> CYAN_GULP_LAMP_ENLIGHTED = register("cyan_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> CYAN_GULP_LAMP_STATIC = register("cyan_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> CYAN_GULP_LAMP_STATIC_ENLIGHTED = register("cyan_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> GREEN_WALL_LAMP = register("green_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> GREEN_WALL_LAMP_ENLIGHTED = register("green_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> GREEN_WALL_LAMP_STATIC = register("green_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> GREEN_WALL_LAMP_STATIC_ENLIGHTED = register("green_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> GREEN_GULP_LAMP = register("green_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> GREEN_GULP_LAMP_ENLIGHTED = register("green_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> GREEN_GULP_LAMP_STATIC = register("green_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> GREEN_GULP_LAMP_STATIC_ENLIGHTED = register("green_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> PURPLE_WALL_LAMP = register("purple_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> PURPLE_WALL_LAMP_ENLIGHTED = register("purple_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> PURPLE_WALL_LAMP_STATIC = register("purple_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> PURPLE_WALL_LAMP_STATIC_ENLIGHTED = register("purple_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> PURPLE_GULP_LAMP = register("purple_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> PURPLE_GULP_LAMP_ENLIGHTED = register("purple_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> PURPLE_GULP_LAMP_STATIC = register("purple_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> PURPLE_GULP_LAMP_STATIC_ENLIGHTED = register("purple_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> MAGENTA_WALL_LAMP = register("magenta_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> MAGENTA_WALL_LAMP_ENLIGHTED = register("magenta_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> MAGENTA_WALL_LAMP_STATIC = register("magenta_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> MAGENTA_WALL_LAMP_STATIC_ENLIGHTED = register("magenta_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> MAGENTA_GULP_LAMP = register("magenta_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> MAGENTA_GULP_LAMP_ENLIGHTED = register("magenta_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> MAGENTA_GULP_LAMP_STATIC = register("magenta_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> MAGENTA_GULP_LAMP_STATIC_ENLIGHTED = register("magenta_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<LampWallBlock> PINK_WALL_LAMP = register("pink_wall_lamp", () -> new LampWallBlock(true, false));
    public static final RegistryObject<LampWallBlock> PINK_WALL_LAMP_ENLIGHTED = register("pink_wall_lamp_enlighted", () -> new LampWallBlock(true, true));
    public static final RegistryObject<LampWallBlock> PINK_WALL_LAMP_STATIC = register("pink_wall_lamp_static", () -> new LampWallBlock(false, false));
    public static final RegistryObject<LampWallBlock> PINK_WALL_LAMP_STATIC_ENLIGHTED = register("pink_wall_lamp_static_enlighted", () -> new LampWallBlock(false, true));
    public static final RegistryObject<LampGulpBlock> PINK_GULP_LAMP = register("pink_gulp_lamp", () -> new LampGulpBlock(true, false));
    public static final RegistryObject<LampGulpBlock> PINK_GULP_LAMP_ENLIGHTED = register("pink_gulp_lamp_enlighted", () -> new LampGulpBlock(true, true));
    public static final RegistryObject<LampGulpBlock> PINK_GULP_LAMP_STATIC = register("pink_gulp_lamp_static", () -> new LampGulpBlock(false, false));
    public static final RegistryObject<LampGulpBlock> PINK_GULP_LAMP_STATIC_ENLIGHTED = register("pink_gulp_lamp_static_enlighted", () -> new LampGulpBlock(false, true));

    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> REDSTONE_LAMP = register("redstone_lamp",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(true, false));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> REDSTONE_LAMP_ENLIGHTED = register("redstone_lamp_enlighted",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(true, true));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> REDSTONE_LAMP_STATIC = register("redstone_lamp_static",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(false, false));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> REDSTONE_LAMP_STATIC_ENLIGHTED = register("redstone_lamp_static_enlighted",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(false, true));

    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSHROOM_LAMP = register("shroomlight_lamp",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(true, false));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSHROOM_LAMP_ENLIGHTED = register("shroomlight_lamp_enlighted",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(true, true));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSHROOM_LAMP_STATIC = register("shroomlight_lamp_static",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(false, false));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSHROOM_LAMP_STATIC_ENLIGHTED = register("shroomlight_lamp_static_enlighted",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(false, true));

    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSTONE_LAMP = register("glowstone_lamp",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(true, false));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSTONE_LAMP_ENLIGHTED = register("glowstone_lamp_enlighted",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(true, true));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSTONE_LAMP_STATIC = register("glowstone_lamp_static",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(false, false));
    public static final RegistryObject<de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock> GLOWSTONE_LAMP_STATIC_ENLIGHTED = register("glowstone_lamp_static_enlighted",
            () -> new de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock(false, true));

    public static void register() {
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(RedwireLampsAndLighting.creativeTab)));
        return toReturn;
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        if (inverted) return (p_50763_) -> !p_50763_.getValue(BlockStateProperties.POWERED) ? 15 : 0;
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.POWERED) ? 15 : 0;
    }
}
