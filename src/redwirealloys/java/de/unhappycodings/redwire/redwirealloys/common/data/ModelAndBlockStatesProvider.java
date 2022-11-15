package de.unhappycodings.redwire.redwirealloys.common.data;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirealloys.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelAndBlockStatesProvider extends BlockStateProvider {

    public ModelAndBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireAlloys.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.RED_ALLOY_WIRE.get(), new ConfiguredModel(models().withExistingParent(ItemUtil.getRegString(ModBlocks.RED_ALLOY_WIRE.get()), new ResourceLocation(RedwireAlloys.MOD_ID, "generation/wire")).texture("0", new ResourceLocation(RedwireAlloys.MOD_ID, "block/red_alloy_wire")).texture("particle", "block/red_alloy_wire")));

    }

}