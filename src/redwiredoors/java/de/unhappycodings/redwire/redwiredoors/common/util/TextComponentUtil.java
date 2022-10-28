package de.unhappycodings.redwire.redwiredoors.common.util;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.Nullable;

public class TextComponentUtil {

    public static MutableComponent getTComp(String key, boolean subModColored) {
        MutableComponent x = Component.translatable("item.redwiredoors." + key);
        return x.setStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR_SUB));
    }

    public static MutableComponent getTComp(String key, boolean modColored, @Nullable ChatFormatting formatting) {
        MutableComponent x = Component.translatable("item.redwiredoors." + key);
        if (modColored) return x.setStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR));
        if (formatting == null)
            return x;
        return x.setStyle(Style.EMPTY.withColor(formatting));
    }

    public static MutableComponent getTCompNK(String key, boolean subModColored) {
        MutableComponent x = Component.translatable("item.redwiredoors." + key);
        return x.setStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR_SUB));
    }

    public static MutableComponent getTCompNK(String key, boolean modColored, @Nullable ChatFormatting formatting) {
        MutableComponent x = Component.translatable("item.redwiredoors." + key);
        if (modColored) return x.setStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR));
        if (formatting == null)
            return x;
        return x.setStyle(Style.EMPTY.withColor(formatting));
    }

}
