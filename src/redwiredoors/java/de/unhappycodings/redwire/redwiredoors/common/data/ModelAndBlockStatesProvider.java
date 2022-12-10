package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import de.unhappycodings.redwire.redwiredoors.common.block.PlayerSensorBlock;
import de.unhappycodings.redwire.redwiredoors.common.util.ItemUtil;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelAndBlockStatesProvider extends BlockStateProvider {
    DataGenerator gen;

    public ModelAndBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireDoors.MOD_ID, exFileHelper);
        this.gen = gen;
    }

    private static int getSensorRotation(Direction facing) {
        return switch (facing) {
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
            default -> 0;
        };
    }

    @Override
    protected void registerStatesAndModels() {
        bigSlidingDoorBlock(ModBlocks.BIG_SLIDING_DOOR.get(), new ResourceLocation("block/stone"));
        playerSensorBlock(ModBlocks.WHITE_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation(RedwireDoors.MOD_ID, "block/white"));
        playerSensorBlock(ModBlocks.GRAY_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation(RedwireDoors.MOD_ID, "block/gray"));
        playerSensorBlock(ModBlocks.BLACK_PLAYER_SENSOR_BLOCK.get(), new ResourceLocation(RedwireDoors.MOD_ID, "block/black"));
        //simpleBlock(ModBlocks.BOUNDING.get(), new ConfiguredModel(models().withExistingParent(ItemUtil.getRegString(ModBlocks.BOUNDING.get()), new ResourceLocation("block/air")).texture("all", "block/empty").texture("particle", "block/empty")));

    }

    public void playerSensorBlock(PlayerSensorBlock block, ResourceLocation texture) {
        ModelFile modelOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on", new ResourceLocation(RedwireDoors.MOD_ID, "generation/player_sensor"))
                .texture("1", texture)
                .texture("2", new ResourceLocation(RedwireDoors.MOD_ID, "block/green_lamp_block_on"))
                .texture("3", new ResourceLocation(RedwireDoors.MOD_ID, "block/green_lamp_block_shade"))
                .texture("particle", texture);
        ModelFile modelOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off", new ResourceLocation(RedwireDoors.MOD_ID, "generation/player_sensor"))
                .texture("1", texture)
                .texture("2", new ResourceLocation(RedwireDoors.MOD_ID, "block/red_lamp_block_on"))
                .texture("3", new ResourceLocation(RedwireDoors.MOD_ID, "block/red_lamp_block_shade"))
                .texture("particle", texture);
        playerSensorBlock(block, modelOn, modelOff);
    }

    public void playerSensorBlock(PlayerSensorBlock block, ModelFile sensorOn, ModelFile sensorOff) {
        getVariantBuilder(block).forAllStates(state -> {
            Direction facing = state.getValue(PlayerSensorBlock.FACING);
            boolean powered = state.getValue(PlayerSensorBlock.POWERED);
            return ConfiguredModel.builder()
                    .modelFile(powered ? sensorOn : sensorOff)
                    .rotationY(getSensorRotation(facing))
                    .build();
        });
    }

    public void bigSlidingDoorBlock(Block block, ResourceLocation texture) {
        ModelFile model = models().withExistingParent(ItemUtil.getRegString(block), "block/cube_all").texture("all", texture).texture("particle", texture);
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
    }

}
