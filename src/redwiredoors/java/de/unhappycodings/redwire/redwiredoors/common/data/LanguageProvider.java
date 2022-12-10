package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedwireDoors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    public LanguageProvider(DataGenerator gen, String locale) {
        super(gen, RedwireDoors.MOD_ID, locale);
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

    @Override
    protected void addTranslations() {
        add("itemGroup.redwiredoors.items", "RedWire: Doors");
        add(ModBlocks.BOUNDING.get(), "Bounding (Redwire)");
        add(ModBlocks.BIG_SLIDING_DOOR.get(), "Big Sliding Door");
        add(ModBlocks.WHITE_PLAYER_SENSOR_BLOCK.get(), "Player Sensor (White)");
        add(ModBlocks.GRAY_PLAYER_SENSOR_BLOCK.get(), "Player Sensor (Gray)");
        add(ModBlocks.BLACK_PLAYER_SENSOR_BLOCK.get(), "Player Sensor (Black)");
    }

}
