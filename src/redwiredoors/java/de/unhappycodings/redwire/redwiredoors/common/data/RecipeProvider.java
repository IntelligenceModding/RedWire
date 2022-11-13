package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(ModBlocks.BIG_SLIDING_DOOR.get())
                .define('a', Blocks.STONE_SLAB).define('b', Items.GLASS).define('c', Items.IRON_DOOR).define('d', Items.REDSTONE)
                .pattern("aaa").pattern("bcb").pattern("ada").unlockedBy("has_item", has(Blocks.STONE_SLAB)).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_PLAYER_SENSOR_BLOCK.get())
                .define('a', Blocks.STONE_SLAB).define('b', Items.REDSTONE)
                .pattern("aba").unlockedBy("has_item", has(Blocks.STONE_SLAB)).save(consumer);
    }

}
