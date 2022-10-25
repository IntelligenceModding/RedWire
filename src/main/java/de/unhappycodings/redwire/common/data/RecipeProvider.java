package de.unhappycodings.redwire.common.data;

import de.unhappycodings.redwire.common.block.ModBlocks;
import de.unhappycodings.redwire.common.item.ModItems;
import de.unhappycodings.redwire.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(ModItems.LINKING_CARD.get())
                .define('a', Items.REDSTONE)
                .define('b', Items.REDSTONE_TORCH)
                .define('c', Items.OBSERVER)
                .define('d', Items.REPEATER)
                .define('e', Items.COMPARATOR)
                .define('f', Items.REDSTONE_LAMP)
                .pattern("  b").pattern("aca").pattern("def").unlockedBy("has_item", has(Items.REDSTONE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.LINKING_CARD.get())
                .requires(ModItems.LINKING_CARD.get())
                .unlockedBy("has_x", has(ModItems.LINKING_CARD.get())).save(consumer, ItemUtil.getRegName(ModItems.LINKING_CARD.get()).getPath() + "_from_self");
        ShapedRecipeBuilder.shaped(ModBlocks.WIRELESS_CONTROLLER.get())
                .define('a', Items.REDSTONE)
                .define('b', Items.REDSTONE_TORCH)
                .define('c', Items.OBSERVER)
                .pattern("aba").pattern("bcb").pattern("aba").unlockedBy("has_item", has(Items.REDSTONE)).save(consumer);
    }
}
