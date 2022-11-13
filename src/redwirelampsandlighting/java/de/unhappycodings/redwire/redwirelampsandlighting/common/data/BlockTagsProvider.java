package de.unhappycodings.redwire.redwirelampsandlighting.common.data;

import de.unhappycodings.redwire.redwirelampsandlighting.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirelampsandlighting.common.registration.Registration;
import de.unhappycodings.redwire.redwirelampsandlighting.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class BlockTagsProvider extends net.minecraft.data.tags.BlockTagsProvider {
    public static final TagKey<Block> LAMPS_CONTROLLABLE = BlockTags.create(new ResourceLocation("redwirelampsandlighting:lamps/controllable"));

    public BlockTagsProvider(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
            System.out.println(ItemUtil.getRegString(block));
            if (ItemUtil.getRegString(block).contains("lamp") && !ItemUtil.getRegString(block).contains("static")) {
                tag(LAMPS_CONTROLLABLE).add(block);
            }
        });
    }
}
