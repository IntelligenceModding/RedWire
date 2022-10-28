package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.registration.Registration;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Objects;

public class TagsProvider extends net.minecraft.data.tags.TagsProvider<Block> {
    public final DataGenerator generator;

    @SuppressWarnings("deprecation")
    protected TagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Registry.BLOCK, RedwireDoors.MOD_ID, existingFileHelper);
        this.generator = generator;
    }

    @Override
    protected void addTags() {

        for (RegistryObject<Block> block : Registration.BLOCKS.getEntries()) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
        }

    }

    @NotNull
    @Override
    protected Path getPath(ResourceLocation location) {
        return this.generator.getOutputFolder().resolve("data/" + location.getNamespace() + "/tags/blocks/" + location.getPath() + ".json");
    }

    @NotNull
    @Override
    public String getName() {
        return "Block tags";
    }
}
