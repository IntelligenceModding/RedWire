package de.unhappycodings.redwire.common.data;

import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.block.ModBlocks;
import de.unhappycodings.redwire.common.item.ModItems;
import de.unhappycodings.redwire.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RedwireCore.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Objects.requireNonNull(ItemUtil.getRegName(ModBlocks.WIRELESS_CONTROLLER.get())).toString(),
                new ResourceLocation(RedwireCore.MOD_ID, "block/wireless_lamp_controller_off"));
        simpleItem(ModItems.LINKING_CARD.get());

    }

    private void simpleItem(Item item) {
        withExistingParent(Objects.requireNonNull(ItemUtil.getRegName(item)).toString(), "item/generated").texture("layer0",
                new ResourceLocation(this.modid, "item/" + ItemUtil.getRegName(item).getPath()));
    }

}
