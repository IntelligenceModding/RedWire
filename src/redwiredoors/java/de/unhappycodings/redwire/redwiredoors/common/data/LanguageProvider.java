package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedwireDoors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    public LanguageProvider(DataGenerator gen, String locale) {
        super(gen, RedwireDoors.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.redwiredoors.lamps", "RedWire: Doors");
    }

    private String getTranslationName(ResourceLocation registryName) {
        return toCamelCase(registryName.toString()
                .replaceAll("blocksmod:", ""));
    }

    static String toCamelCase(String s) {
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts) {
            camelCaseString = camelCaseString + toProperCase(part) + " ";
        }
        return camelCaseString.substring(0, camelCaseString.length() - 1);
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

}
