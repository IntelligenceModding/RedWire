package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import de.unhappycodings.redwire.redwiredoors.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireDoors.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        bigSlidingDoorItem(ModBlocks.BIG_SLIDING_DOOR.get(), new ResourceLocation(RedwireDoors.MOD_ID, "geo/textures/stone_big_sliding_door"));
        playerSensorItem(ModBlocks.WHITE_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation(RedwireDoors.MOD_ID, "block/white"));
        playerSensorItem(ModBlocks.GRAY_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation(RedwireDoors.MOD_ID, "block/gray"));
        playerSensorItem(ModBlocks.BLACK_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation(RedwireDoors.MOD_ID, "block/black"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BOUNDING.get()), new ResourceLocation("item/barrier"));
    }

    private void playerSensorItem(Block block, ResourceLocation texture) {
        withExistingParent(ItemUtil.getRegString(block), new ResourceLocation(RedwireDoors.MOD_ID, "generation/player_sensor"))
                .texture("1", texture)
                .texture("2", new ResourceLocation(RedwireDoors.MOD_ID, "block/red_lamp_block_on"))
                .texture("3", new ResourceLocation(RedwireDoors.MOD_ID, "block/red_lamp_block_shade"))
                .texture("particle", texture);
    }

    private void bigSlidingDoorItem(Block block, ResourceLocation texture) {
        withExistingParent(ItemUtil.getRegString(block), new ResourceLocation(RedwireDoors.MOD_ID, "generation/big_sliding_door"))
                .texture("0", texture)
                .texture("particle", texture);
    }

}
