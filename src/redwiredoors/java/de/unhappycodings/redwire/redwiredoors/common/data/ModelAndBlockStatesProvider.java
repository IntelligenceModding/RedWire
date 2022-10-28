package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import de.unhappycodings.redwire.redwiredoors.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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

    @Override
    protected void registerStatesAndModels() {
        bigSlidingDoorBlock(ModBlocks.STONE_BIG_SLIDING_DOOR.get(), new ResourceLocation("block/stone"));

    }

    public void bigSlidingDoorBlock(Block block, ResourceLocation texture) {
        ModelFile model = models().withExistingParent(ItemUtil.getRegString(block), "block/cube_all").texture("all", texture);
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
    }

}
