package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireDoors.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {


    }

}
