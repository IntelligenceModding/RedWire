package de.unhappycodings.redwire.redwirealloys.common.data;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedwireAlloys.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProvider {

    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new LanguageProvider(generator, "en_us"));
        generator.addProvider(true, new LootTableProvider(generator));
        generator.addProvider(true, new RecipeProvider(generator));
        generator.addProvider(true, new TagsProvider(generator, existingFileHelper));
        generator.addProvider(true, new ModelAndBlockStatesProvider(generator, existingFileHelper));
        generator.addProvider(true, new ItemModelProvider(generator, existingFileHelper));
    }
}
