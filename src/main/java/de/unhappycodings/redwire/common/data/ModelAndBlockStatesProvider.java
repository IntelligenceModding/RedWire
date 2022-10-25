package de.unhappycodings.redwire.common.data;

import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.block.ModBlocks;
import de.unhappycodings.redwire.common.block.WirelessControllerBlock;
import de.unhappycodings.redwire.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelAndBlockStatesProvider extends BlockStateProvider {

    public ModelAndBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireCore.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        wirelessControllerBlock(ModBlocks.WIRELESS_CONTROLLER.get());

    }

    @SuppressWarnings("ConstantConditions")
    public void wirelessControllerBlock(WirelessControllerBlock block) {
        ModelFile wirelessControllerOn = models().withExistingParent(ItemUtil.getRegString(block) + "_on",
                        new ResourceLocation(RedwireCore.MOD_ID, "generation/wireless_controller_on"))
                .texture("0", new ResourceLocation(RedwireCore.MOD_ID, "block/wireless_controller_on"))
                .texture("particle", new ResourceLocation(RedwireCore.MOD_ID, "block/wireless_controller_on"));
        ModelFile wirelessControllerOff = models().withExistingParent(ItemUtil.getRegString(block) + "_off",
                        new ResourceLocation(RedwireCore.MOD_ID, "generation/wireless_controller"))
                .texture("0", new ResourceLocation(RedwireCore.MOD_ID, "block/wireless_controller"))
                .texture("particle", new ResourceLocation(RedwireCore.MOD_ID, "block/wireless_controller"));
        wirelessControllerBlock(block, wirelessControllerOn, wirelessControllerOff);
    }

    public void wirelessControllerBlock(WirelessControllerBlock block, ModelFile on, ModelFile off) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean active = state.getValue(BlockStateProperties.POWERED);
            if (active)
                return ConfiguredModel.builder().modelFile(on).build();
            return ConfiguredModel.builder().modelFile(off).build();
        });
    }

}