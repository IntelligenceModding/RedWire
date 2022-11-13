package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsProvider extends net.minecraft.data.tags.BlockTagsProvider {
    public static final TagKey<Block> LAMPS_CONTROLLABLE = BlockTags.create(new ResourceLocation("redwiredoors:doors/controllable"));

    public BlockTagsProvider(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(LAMPS_CONTROLLABLE).add(ModBlocks.BIG_SLIDING_DOOR.get());
    }
}
