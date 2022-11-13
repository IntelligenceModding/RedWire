package de.unhappycodings.redwire.redwirealloys.common.data;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireAlloys.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    private void simpleItem(Item item) {
        withExistingParent(Objects.requireNonNull(ItemUtil.getRegName(item)).toString(), "item/generated").texture("layer0",
                new ResourceLocation(this.modid, "item/" + ItemUtil.getRegName(item).getPath()));
    }

}
