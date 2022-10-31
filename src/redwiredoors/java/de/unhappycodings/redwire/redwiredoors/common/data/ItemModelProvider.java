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
        bigSlidingDoorItem(ModBlocks.STONE_BIG_SLIDING_DOOR.get(), new ResourceLocation("block/stone"));
        playerSensorItem(ModBlocks.STONE_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation("block/stone"));

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
                .texture("1", new ResourceLocation("block/gray_stained_glass"))
                .texture("2", new ResourceLocation(RedwireDoors.MOD_ID, "block/anorthosite_block_smooth_fine"))
                .texture("particle", texture);
    }

}
