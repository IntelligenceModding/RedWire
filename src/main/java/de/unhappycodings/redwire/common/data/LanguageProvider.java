package de.unhappycodings.redwire.common.data;

import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.block.ModBlocks;
import de.unhappycodings.redwire.common.item.ModItems;
import net.minecraft.data.DataGenerator;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    public LanguageProvider(DataGenerator gen, String locale) {
        super(gen, RedwireCore.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModBlocks.WIRELESS_CONTROLLER.get(), "Wireless Controller");
        add(ModItems.LINKING_CARD.get(), "Linking Card");

        add("itemGroup.redwirecore.items", "Redwire: Core");

    }
}
