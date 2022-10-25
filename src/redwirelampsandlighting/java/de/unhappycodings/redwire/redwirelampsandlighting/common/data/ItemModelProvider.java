package de.unhappycodings.redwire.redwirelampsandlighting.common.data;

import de.unhappycodings.redwire.redwirelampsandlighting.RedwireLampsAndLighting;
import de.unhappycodings.redwire.redwirelampsandlighting.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirelampsandlighting.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireLampsAndLighting.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block_enlighted"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block_enlighted"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block_on"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block"));
        buttonInventory(ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_lamp_block_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/white_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_gray_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/gray_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/black_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/red_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/orange_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/yellow_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/blue_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/light_blue_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/cyan_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/green_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/purple_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/magenta_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_wall_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_wall_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_wall_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_wall_lamp_static_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_gulp_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_gulp_lamp_enlighted_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_gulp_lamp_static_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/pink_gulp_lamp_static_enlighted_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP.get()).toString(), new ResourceLocation("block/redstone_lamp"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation("block/redstone_lamp_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP_STATIC.get()).toString(), new ResourceLocation("block/redstone_lamp"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation("block/redstone_lamp_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/shroomlight_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/shroomlight_lamp_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/shroomlight_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/shroomlight_lamp_on"));

        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/glowstone_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/glowstone_lamp_on"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP_STATIC.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/glowstone_lamp_off"));
        withExistingParent(ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP_STATIC_ENLIGHTED.get()).toString(), new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/glowstone_lamp_on"));
    }

    private void simpleItem(Item item) {
        withExistingParent(ItemUtil.getRegName(item).toString(), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" + item).getPath());
    }
}
