package de.unhappycodings.redwire.redwirelampsandlighting.common.data;

import de.unhappycodings.redwire.redwirelampsandlighting.RedwireLampsAndLighting;
import de.unhappycodings.redwire.redwirelampsandlighting.common.block.LampGulpBlock;
import de.unhappycodings.redwire.redwirelampsandlighting.common.block.LampWallBlock;
import de.unhappycodings.redwire.redwirelampsandlighting.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirelampsandlighting.common.block.RedstoneLampBlock;
import de.unhappycodings.redwire.redwirelampsandlighting.common.util.ItemUtil;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelAndBlockstateProvider extends BlockStateProvider {

    public ModelAndBlockstateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    private static int getRotation(Direction facing) {
        return switch (facing) {
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
            default -> 0;
        };
    }

    @Override
    protected void registerStatesAndModels() {
        wallLampBlock(ModBlocks.WHITE_WALL_LAMP.get());
        wallLampBlock(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.WHITE_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.WHITE_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.WHITE_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.WHITE_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.WHITE_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.LIGHT_GRAY_WALL_LAMP.get());
        wallLampBlock(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.LIGHT_GRAY_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.GRAY_WALL_LAMP.get());
        wallLampBlock(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.GRAY_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.GRAY_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.GRAY_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.GRAY_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.GRAY_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.BLACK_WALL_LAMP.get());
        wallLampBlock(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.BLACK_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.BLACK_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.BLACK_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.BLACK_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.BLACK_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.RED_WALL_LAMP.get());
        wallLampBlock(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.RED_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.RED_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.RED_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.RED_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.RED_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.ORANGE_WALL_LAMP.get());
        wallLampBlock(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.ORANGE_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.ORANGE_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.ORANGE_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.ORANGE_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.ORANGE_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.YELLOW_WALL_LAMP.get());
        wallLampBlock(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.YELLOW_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.YELLOW_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.YELLOW_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.YELLOW_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.YELLOW_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.BLUE_WALL_LAMP.get());
        wallLampBlock(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.BLUE_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.BLUE_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.BLUE_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.BLUE_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.BLUE_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.LIGHT_BLUE_WALL_LAMP.get());
        wallLampBlock(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.LIGHT_BLUE_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.CYAN_WALL_LAMP.get());
        wallLampBlock(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.CYAN_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.CYAN_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.CYAN_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.CYAN_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.CYAN_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.GREEN_WALL_LAMP.get());
        wallLampBlock(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.GREEN_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.GREEN_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.GREEN_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.GREEN_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.GREEN_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.PURPLE_WALL_LAMP.get());
        wallLampBlock(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.PURPLE_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.PURPLE_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.PURPLE_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.PURPLE_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.PURPLE_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.MAGENTA_WALL_LAMP.get());
        wallLampBlock(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.MAGENTA_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.MAGENTA_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.MAGENTA_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.MAGENTA_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.MAGENTA_GULP_LAMP_STATIC_ENLIGHTED.get());

        wallLampBlock(ModBlocks.PINK_WALL_LAMP.get());
        wallLampBlock(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get());
        wallLampBlock(ModBlocks.PINK_WALL_LAMP_STATIC.get());
        wallLampBlock(ModBlocks.PINK_WALL_LAMP_STATIC_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.PINK_GULP_LAMP.get());
        gulpLampBlock(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get());
        gulpLampBlock(ModBlocks.PINK_GULP_LAMP_STATIC.get());
        gulpLampBlock(ModBlocks.PINK_GULP_LAMP_STATIC_ENLIGHTED.get());

        redstoneLampBlock(ModBlocks.REDSTONE_LAMP.get());
        redstoneLampBlock(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get());
        redstoneLampBlock(ModBlocks.REDSTONE_LAMP_STATIC.get());
        redstoneLampBlock(ModBlocks.REDSTONE_LAMP_STATIC_ENLIGHTED.get());

        glowshroomLampBlock(ModBlocks.GLOWSHROOM_LAMP.get());
        glowshroomLampBlock(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get());
        glowshroomLampBlock(ModBlocks.GLOWSHROOM_LAMP_STATIC.get());
        glowshroomLampBlock(ModBlocks.GLOWSHROOM_LAMP_STATIC_ENLIGHTED.get());

        glowstoneLampBlock(ModBlocks.GLOWSTONE_LAMP.get());
        glowstoneLampBlock(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get());
        glowstoneLampBlock(ModBlocks.GLOWSTONE_LAMP_STATIC.get());
        glowstoneLampBlock(ModBlocks.GLOWSTONE_LAMP_STATIC_ENLIGHTED.get());
    }

    public void glowstoneLampBlock(RedstoneLampBlock block) {
        ModelFile lampOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off", new ResourceLocation("block/redstone_lamp")).texture("all", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/glowstone_off"));
        ModelFile lampOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on", new ResourceLocation("block/redstone_lamp")).texture("all", new ResourceLocation("block/glowstone"));
        redstoneLampBlock(block, lampOff, lampOn);
    }

    public void glowshroomLampBlock(RedstoneLampBlock block) {
        ModelFile lampOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off", new ResourceLocation("block/redstone_lamp")).texture("all", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/shroomlight_off"));
        ModelFile lampOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on", new ResourceLocation("block/redstone_lamp")).texture("all", new ResourceLocation("block/shroomlight"));
        redstoneLampBlock(block, lampOff, lampOn);
    }

    public void redstoneLampBlock(RedstoneLampBlock block) {
        ModelFile lampOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off", new ResourceLocation("block/redstone_lamp")).texture("all", new ResourceLocation("block/redstone_lamp"));
        ModelFile lampOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on", new ResourceLocation("block/redstone_lamp")).texture("all", new ResourceLocation("block/redstone_lamp_on"));
        redstoneLampBlock(block, lampOff, lampOn);
    }

    public void redstoneLampBlock(RedstoneLampBlock block, ModelFile off, ModelFile on) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(RedstoneLampBlock.LIT) ? on : off).build());
    }

    public void gulpLampBlock(LampGulpBlock block) {
        String texture = "";
        String colors[] = ItemUtil.getRegString(block).replace("redwirelampsandlighting:", "").split("_");
        if (colors[0].equals("light")) {
            texture = colors[0] + "_" + colors[1] + "_lamp_block";
        } else {
            texture = colors[0] + "_lamp_block";
        }
        ModelFile lampOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "generation/gulp_lamp_off")).texture("1", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture)).texture("0", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/wall_lamp")).texture("particle", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture));
        ModelFile lampOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "generation/gulp_lamp")).texture("1", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture + "_on")).texture("2", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture + "_shade")).texture("0", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/wall_lamp")).texture("particle", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture + "_on"));
        gulpLampBlock(block, lampOff, lampOn);
    }

    public void gulpLampBlock(LampGulpBlock block, ModelFile off, ModelFile on) {
        getVariantBuilder(block).forAllStates(state -> {
            AttachFace facing = state.getValue(LampGulpBlock.FACE);
            Direction face = state.getValue(LampGulpBlock.FACING);
            ConfiguredModel.Builder<?> file = ConfiguredModel.builder().modelFile(state.getValue(LampGulpBlock.LIT) ? on : off);
            if (facing == AttachFace.CEILING) return file.rotationX(180).build();
            if (facing == AttachFace.FLOOR) return file.build();
            switch (face) {
                case NORTH -> {
                    return file.rotationX(90).build();
                }
                case EAST -> {
                    return file.rotationX(90).rotationY(90).build();
                }
                case SOUTH -> {
                    return file.rotationX(90).rotationY(180).build();
                }
                case WEST -> {
                    return file.rotationX(90).rotationY(270).build();
                }
            }
            return file.build();
        });
    }

    public void wallLampBlock(LampWallBlock block) {
        String texture = "";
        String colors[] = ItemUtil.getRegString(block).replace("redwirelampsandlighting:", "").split("_");
        if (colors[0].equals("light")) {
            texture = colors[0] + "_" + colors[1] + "_lamp_block";
        } else {
            texture = colors[0] + "_lamp_block";
        }
        ModelFile lampOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "generation/wall_lamp_off")).texture("1", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture)).texture("2", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/wall_lamp")).texture("particle", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture));
        ModelFile lampOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "generation/wall_lamp")).texture("1", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture + "_on")).texture("2", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture + "_shade")).texture("3", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/wall_lamp")).texture("particle", new ResourceLocation(RedwireLampsAndLighting.MOD_ID, "block/" + texture + "_on"));
        wallLampBlock(block, lampOff, lampOn);
    }

    public void wallLampBlock(LampWallBlock block, ModelFile off, ModelFile on) {
        getVariantBuilder(block).forAllStates(state -> {
            Direction facing = state.getValue(LampWallBlock.FACING);
            return ConfiguredModel.builder().modelFile(state.getValue(LampWallBlock.LIT) ? on : off).rotationY(getRotation(facing)).build();
        });
    }

}
