package de.unhappycodings.redwire.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class CommonConfig {

    public static ForgeConfigSpec COMMON_CONFIG;

    /* General */

    // FUTURE
    public static ForgeConfigSpec.ConfigValue<String> LINKING_TOOL_OVERLAY_COLOR;
    public static ForgeConfigSpec.IntValue LINKING_TOOL_MAX_BOUNDS;
    public static ForgeConfigSpec.BooleanValue LINKING_TOOL_OVERLAY_RAINBOW;
    // public static ForgeConfigSpec.BooleanValue ENABLE_LAMP_BLOCKS;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        init(COMMON_BUILDER);
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    private static void init(ForgeConfigSpec.Builder COMMON_BUILDER) {
        COMMON_BUILDER.push("General");
        LINKING_TOOL_OVERLAY_COLOR = COMMON_BUILDER.comment("What Color should the Overlay be [Format: #RRGGBB] [Def: #00b497]")
                .define("linking_tool_overlay_color", "#00b497");
        LINKING_TOOL_OVERLAY_RAINBOW = COMMON_BUILDER.comment("Render the overlay in fading rainbow colors! [Format: true] [Def: false]")
                .define("linking_tool_overlay_rainbow", false);
        LINKING_TOOL_MAX_BOUNDS = COMMON_BUILDER.comment("How many RedWire blocks should be boundaböe to one single Linking Card? [Def: 48]")
                .defineInRange("linking_tool_max_bounds", 48, 1, 512);
        COMMON_BUILDER.pop();
    }

    public static void loadConfigFile(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

}
