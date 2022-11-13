package de.unhappycodings.redwire.redwirealloys.common.data;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelAndBlockStatesProvider extends BlockStateProvider {

    public ModelAndBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireAlloys.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {


    }

}