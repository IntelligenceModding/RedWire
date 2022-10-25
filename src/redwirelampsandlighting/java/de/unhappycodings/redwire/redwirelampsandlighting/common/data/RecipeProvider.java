package de.unhappycodings.redwire.redwirelampsandlighting.common.data;

import de.unhappycodings.redwire.redwirelampsandlighting.common.block.ModBlocks;
import de.unhappycodings.redwire.redwirelampsandlighting.common.item.ModItems;
import de.unhappycodings.redwire.redwirelampsandlighting.common.registration.Registration;
import de.unhappycodings.redwire.redwirelampsandlighting.common.util.ItemUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        HashMap<ItemLike, ItemLike> items = new HashMap<>();
        items.put(ModBlocks.WHITE_LAMP.get(), Items.WHITE_DYE);
        items.put(ModBlocks.LIGHT_GRAY_LAMP.get(), Items.LIGHT_GRAY_DYE);
        items.put(ModBlocks.GRAY_LAMP.get(), Items.GRAY_DYE);
        items.put(ModBlocks.BLACK_LAMP.get(), Items.BLACK_DYE);
        items.put(ModBlocks.GREEN_LAMP.get(), Items.GREEN_DYE);
        items.put(ModBlocks.CYAN_LAMP.get(), Items.CYAN_DYE);
        items.put(ModBlocks.BLUE_LAMP.get(), Items.BLUE_DYE);
        items.put(ModBlocks.LIGHT_BLUE_LAMP.get(), Items.LIGHT_BLUE_DYE);
        items.put(ModBlocks.YELLOW_LAMP.get(), Items.YELLOW_DYE);
        items.put(ModBlocks.ORANGE_LAMP.get(), Items.ORANGE_DYE);
        items.put(ModBlocks.RED_LAMP.get(), Items.RED_DYE);
        items.put(ModBlocks.PINK_LAMP.get(), Items.PINK_DYE);
        items.put(ModBlocks.MAGENTA_LAMP.get(), Items.MAGENTA_DYE);
        items.put(ModBlocks.PURPLE_LAMP.get(), Items.PURPLE_DYE);

        HashMap<ItemLike, ItemLike> enlighted = new HashMap<>();
        enlighted.put(ModBlocks.WHITE_LAMP.get(), ModBlocks.WHITE_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.LIGHT_GRAY_LAMP.get(), ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.GRAY_LAMP.get(), ModBlocks.GRAY_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.BLACK_LAMP.get(), ModBlocks.BLACK_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.GREEN_LAMP.get(), ModBlocks.GREEN_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.CYAN_LAMP.get(), ModBlocks.CYAN_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.BLUE_LAMP.get(), ModBlocks.BLUE_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.LIGHT_BLUE_LAMP.get(), ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.YELLOW_LAMP.get(), ModBlocks.YELLOW_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.ORANGE_LAMP.get(), ModBlocks.ORANGE_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.RED_LAMP.get(), ModBlocks.RED_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.PINK_LAMP.get(), ModBlocks.PINK_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.MAGENTA_LAMP.get(), ModBlocks.MAGENTA_LAMP_ENLIGHTED.get());
        enlighted.put(ModBlocks.PURPLE_LAMP.get(), ModBlocks.PURPLE_LAMP_ENLIGHTED.get());

        Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
            if (ItemUtil.getRegName(block).getPath().contains("flat")) {
                for (Map.Entry<ItemLike, ItemLike> item : enlighted.entrySet()) {
                    if (ItemUtil.getRegName(block).getPath().contains(ItemUtil.getRegName(item.getKey().asItem()).getPath())) {
                        if (ItemUtil.getRegName(block).getPath().contains("big")) {
                            if (ItemUtil.getRegName(block).getPath().contains("enlighted")) { // value=enlighted key=normal
                                if (ItemUtil.getRegName(block).getPath().contains("framed")) {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getValue()).define('c', Items.IRON_NUGGET).pattern(" ac").pattern("aba").pattern("ca ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                } else {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getValue()).pattern(" a ").pattern("aba").pattern(" a ").unlockedBy("has_item", has(Items.IRON_NUGGET)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }

                                }
                            } else {
                                if (ItemUtil.getRegName(block).getPath().contains("framed")) {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getKey()).define('c', Items.IRON_NUGGET).pattern(" ac").pattern("aba").pattern("ca ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                } else {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getKey()).pattern(" a ").pattern("aba").pattern(" a ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }

                                }
                            }
                        } else if (ItemUtil.getRegName(block).getPath().contains("huge")) {
                            if (ItemUtil.getRegName(block).getPath().contains("enlighted")) { // value=enlighted key=normal
                                if (ItemUtil.getRegName(block).getPath().contains("framed")) {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getValue()).define('c', Items.IRON_NUGGET).pattern("caa").pattern("aba").pattern("aac").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                } else {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getValue()).pattern(" aa").pattern("aba").pattern("aa ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }

                                }
                            } else {
                                if (ItemUtil.getRegName(block).getPath().contains("framed")) {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getKey()).define('c', Items.IRON_NUGGET).pattern("caa").pattern("aba").pattern("aac").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                } else {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getKey()).pattern(" aa").pattern("aba").pattern("aa ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }

                                }
                            }
                        } else {
                            if (ItemUtil.getRegName(block).getPath().contains("enlighted")) { // value=enlighted key=normal
                                if (ItemUtil.getRegName(block).getPath().contains("framed")) {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getValue()).define('c', Items.IRON_NUGGET).pattern(" c ").pattern("aba").pattern(" c ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                } else {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getValue()).pattern("aba").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }

                                }
                            } else {
                                if (ItemUtil.getRegName(block).getPath().contains("framed")) {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getKey()).define('c', Items.IRON_NUGGET).pattern(" c ").pattern("aba").pattern(" c ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                } else {
                                    boolean usable = ItemUtil.getRegName(block).getPath().contains("light_") && ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_");
                                    if (!ItemUtil.getRegName(block).getPath().contains("light_") && !ItemUtil.getRegName(item.getValue().asItem()).getPath().contains("light_"))
                                        usable = true;
                                    if (usable) {
                                        ShapedRecipeBuilder.shaped(block, 12).define('a', Items.IRON_INGOT).define('b', item.getKey()).pattern("aba").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, ItemUtil.getRegName(block).getPath() + "_crafted");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        for (Map.Entry<ItemLike, ItemLike> recipeItems : enlighted.entrySet()) {
            ShapelessRecipeBuilder.shapeless(recipeItems.getValue()).requires(recipeItems.getKey()).unlockedBy("has_x", has(recipeItems.getValue())).save(consumer, ItemUtil.getRegName(recipeItems.getKey().asItem()).getPath() + "_enlighted");
            ShapelessRecipeBuilder.shapeless(recipeItems.getKey()).requires(recipeItems.getValue()).unlockedBy("has_x", has(recipeItems.getKey())).save(consumer, Objects.requireNonNull(ItemUtil.getRegName(recipeItems.getKey().asItem())).getPath() + "_enlighted_back");
        }

        for (Map.Entry<ItemLike, ItemLike> recipeItems : items.entrySet()) {
            ShapedRecipeBuilder.shaped(recipeItems.getKey()).define('a', Items.GLASS_PANE).define('b', recipeItems.getValue()).define('c', Items.REDSTONE_LAMP).define('d', ModItems.LUMINOUS_DUST.get()).pattern("aba").pattern("aca").pattern("ada").unlockedBy("has_item", has(Items.GLASS_PANE)).save(consumer);

            for (Map.Entry<ItemLike, ItemLike> shapelessRecipeItems : items.entrySet()) {
                if (shapelessRecipeItems != recipeItems) {
                    ShapelessRecipeBuilder.shapeless(recipeItems.getKey()).requires(shapelessRecipeItems.getKey()).requires(recipeItems.getValue()).unlockedBy("has_x", has(recipeItems.getKey())).save(consumer, ItemUtil.getRegName(recipeItems.getKey().asItem()).getPath() + "_dyed_" + Objects.requireNonNull(ItemUtil.getRegName(shapelessRecipeItems.getKey().asItem())).getPath());
                }
            }
        }
        ShapelessRecipeBuilder.shapeless(ModItems.LUMINOUS_DUST.get()).requires(Items.REDSTONE).requires(Items.GLOWSTONE_DUST).unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_LAMP_STATIC.get(), 1).define('a', ModBlocks.WHITE_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.WHITE_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP.get()).requires(ModBlocks.WHITE_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP.get()).requires(ModBlocks.WHITE_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_LAMP_STATIC.get(), 1).define('a', ModBlocks.LIGHT_GRAY_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_LAMP_STATIC.get(), 1).define('a', ModBlocks.GRAY_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.GRAY_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP.get()).requires(ModBlocks.GRAY_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP.get()).requires(ModBlocks.GRAY_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_LAMP_STATIC.get(), 1).define('a', ModBlocks.BLACK_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.BLACK_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP.get()).requires(ModBlocks.BLACK_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP.get()).requires(ModBlocks.BLACK_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_LAMP_STATIC.get(), 1).define('a', ModBlocks.GREEN_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.GREEN_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP.get()).requires(ModBlocks.GREEN_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP.get()).requires(ModBlocks.GREEN_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_LAMP_STATIC.get(), 1).define('a', ModBlocks.CYAN_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.CYAN_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP.get()).requires(ModBlocks.CYAN_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP.get()).requires(ModBlocks.CYAN_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_LAMP_STATIC.get(), 1).define('a', ModBlocks.BLUE_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.BLUE_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP.get()).requires(ModBlocks.BLUE_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP.get()).requires(ModBlocks.BLUE_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_LAMP_STATIC.get(), 1).define('a', ModBlocks.YELLOW_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.YELLOW_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP.get()).requires(ModBlocks.YELLOW_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP.get()).requires(ModBlocks.YELLOW_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_LAMP_STATIC.get(), 1).define('a', ModBlocks.ORANGE_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.ORANGE_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP.get()).requires(ModBlocks.ORANGE_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP.get()).requires(ModBlocks.ORANGE_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.RED_LAMP_STATIC.get(), 1).define('a', ModBlocks.RED_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.RED_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.RED_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP.get()).requires(ModBlocks.RED_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP.get()).requires(ModBlocks.RED_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_LAMP.get()).getPath() + "_from_static_enlighted");


        ShapedRecipeBuilder.shaped(ModBlocks.PINK_LAMP_STATIC.get(), 1).define('a', ModBlocks.PINK_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PINK_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.PINK_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP.get()).requires(ModBlocks.PINK_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP.get()).requires(ModBlocks.PINK_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_LAMP_STATIC.get(), 1).define('a', ModBlocks.MAGENTA_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.MAGENTA_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP.get()).requires(ModBlocks.MAGENTA_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP.get()).requires(ModBlocks.MAGENTA_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP.get()).getPath() + "_from_static_enlighted");

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_LAMP_STATIC.get(), 1).define('a', ModBlocks.PURPLE_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_LAMP_STATIC_ENLIGHTED.get(), 1).define('a', ModBlocks.PURPLE_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP.get()).requires(ModBlocks.PURPLE_LAMP_STATIC.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_LAMP.get()).getPath() + "_from_static");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP.get()).requires(ModBlocks.PURPLE_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_LAMP.get()).getPath() + "_from_static_enlighted");

        //region Tube Lamps
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_TUBE_LAMP.get(), 16).define('a', ModBlocks.WHITE_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.WHITE_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.WHITE_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.WHITE_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP.get()).requires(ModBlocks.WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.WHITE_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.WHITE_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.WHITE_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_TUBE_LAMP.get(), 16).define('a', ModBlocks.LIGHT_GRAY_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.LIGHT_GRAY_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_TUBE_LAMP.get(), 16).define('a', ModBlocks.GRAY_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.GRAY_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.GRAY_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.GRAY_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP.get()).requires(ModBlocks.GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.GRAY_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.GRAY_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.GRAY_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_TUBE_LAMP.get(), 16).define('a', ModBlocks.BLACK_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.BLACK_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.BLACK_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.BLACK_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP.get()).requires(ModBlocks.BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.BLACK_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.BLACK_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.BLACK_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_TUBE_LAMP.get(), 16).define('a', ModBlocks.GREEN_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.GREEN_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.GREEN_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.GREEN_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP.get()).requires(ModBlocks.GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.GREEN_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.GREEN_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.GREEN_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_TUBE_LAMP.get(), 16).define('a', ModBlocks.CYAN_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.CYAN_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.CYAN_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.CYAN_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP.get()).requires(ModBlocks.CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.CYAN_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.CYAN_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.CYAN_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_TUBE_LAMP.get(), 16).define('a', ModBlocks.BLUE_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.BLUE_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.BLUE_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.BLUE_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP.get()).requires(ModBlocks.BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.BLUE_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.BLUE_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.BLUE_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_TUBE_LAMP.get(), 16).define('a', ModBlocks.LIGHT_BLUE_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.LIGHT_BLUE_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_TUBE_LAMP.get(), 16).define('a', ModBlocks.YELLOW_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.YELLOW_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.YELLOW_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.YELLOW_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.YELLOW_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_TUBE_LAMP.get(), 16).define('a', ModBlocks.ORANGE_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.ORANGE_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.ORANGE_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.ORANGE_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.ORANGE_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.RED_TUBE_LAMP.get(), 16).define('a', ModBlocks.RED_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.RED_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.RED_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.RED_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP.get()).requires(ModBlocks.RED_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.RED_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.RED_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.RED_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.RED_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.RED_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.RED_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.RED_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.RED_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PINK_TUBE_LAMP.get(), 16).define('a', ModBlocks.PINK_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.PINK_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.PINK_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.PINK_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP.get()).requires(ModBlocks.PINK_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PINK_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.PINK_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PINK_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.PINK_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.PINK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PINK_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.PINK_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.PINK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_TUBE_LAMP.get(), 16).define('a', ModBlocks.MAGENTA_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.MAGENTA_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.MAGENTA_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.MAGENTA_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_TUBE_LAMP.get(), 16).define('a', ModBlocks.PURPLE_LAMP.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_LEFT_OPEN.get()).requires(ModBlocks.PURPLE_TUBE_LAMP.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_RIGHT_OPEN.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_TUBE_LAMP.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_TUBE_LAMP_EDGE.get(), 16).define('a', ModBlocks.PURPLE_LAMP.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_TUBE_LAMP_EDGE.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_TUBE_LAMP_ENLIGHTED.get(), 16).define('a', ModBlocks.PURPLE_LAMP_ENLIGHTED.get()).pattern("aaa").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_TUBE_LAMP_ENLIGHTED.get()).getPath() + "_from_self");

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_TUBE_LAMP_EDGE_ENLIGHTED.get(), 16).define('a', ModBlocks.PURPLE_LAMP_ENLIGHTED.get()).pattern("   ").pattern("aa ").pattern("a  ").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_RIGHT_OPEN_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_TUBE_LAMP_EDGE_ENLIGHTED.get()).requires(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_TUBE_LAMP_EDGE_LEFT_RIGHT_OPEN_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_TUBE_LAMP_EDGE_ENLIGHTED.get()).getPath() + "_from_self");

        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON.get(), 6).requires(ModBlocks.WHITE_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.WHITE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON.get()).requires(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.WHITE_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.WHITE_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.WHITE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON.get(), 6).requires(ModBlocks.LIGHT_GRAY_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON.get(), 6).requires(ModBlocks.GRAY_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.GRAY_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON.get()).requires(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.GRAY_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.GRAY_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GRAY_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON.get(), 6).requires(ModBlocks.BLACK_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.BLACK_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON.get()).requires(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.BLACK_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.BLACK_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLACK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON.get(), 6).requires(ModBlocks.YELLOW_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.YELLOW_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON.get()).requires(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.YELLOW_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.YELLOW_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.YELLOW_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON.get(), 6).requires(ModBlocks.ORANGE_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.ORANGE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON.get()).requires(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.ORANGE_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.ORANGE_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.ORANGE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON.get(), 6).requires(ModBlocks.RED_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.RED_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON.get()).requires(ModBlocks.RED_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.RED_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.RED_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.RED_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.RED_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.RED_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.RED_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON.get(), 6).requires(ModBlocks.GREEN_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.GREEN_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON.get()).requires(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.GREEN_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.GREEN_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.GREEN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON.get(), 6).requires(ModBlocks.CYAN_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.CYAN_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON.get()).requires(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.CYAN_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.CYAN_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.CYAN_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON.get(), 6).requires(ModBlocks.BLUE_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.BLUE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON.get()).requires(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.BLUE_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.BLUE_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON.get(), 6).requires(ModBlocks.LIGHT_BLUE_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.LIGHT_BLUE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON.get(), 6).requires(ModBlocks.PINK_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.PINK_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON.get()).requires(ModBlocks.PINK_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.PINK_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.PINK_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.PINK_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.PINK_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.PINK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PINK_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON.get(), 6).requires(ModBlocks.MAGENTA_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON.get()).requires(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.MAGENTA_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.MAGENTA_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON.get(), 6).requires(ModBlocks.PURPLE_LAMP.get()).requires(Blocks.STONE_BUTTON).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.PURPLE_LAMP_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON.get()).requires(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON_ENLIGHTED.get()).requires(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_LAMP_BUTTON_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE.get()).requires(ModBlocks.PURPLE_LAMP_BUTTON.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_BUTTON.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).requires(ModBlocks.PURPLE_LAMP_BUTTON_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_BUTTON_ENLIGHTED.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER.get()).requires(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_LAMP_BUTTON_TRIGGER_ENLIGHTED.get()).requires(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get()).unlockedBy("has_x", has(ModBlocks.PURPLE_LAMP_BUTTON_TOGGLE_ENLIGHTED.get())).save(consumer);

        HashMap<ItemLike, ItemLike> wallItems = new HashMap<>();
        wallItems.put(ModBlocks.WHITE_WALL_LAMP.get(), Items.WHITE_DYE);
        wallItems.put(ModBlocks.LIGHT_GRAY_WALL_LAMP.get(), Items.LIGHT_GRAY_DYE);
        wallItems.put(ModBlocks.GRAY_WALL_LAMP.get(), Items.GRAY_DYE);
        wallItems.put(ModBlocks.BLACK_WALL_LAMP.get(), Items.BLACK_DYE);
        wallItems.put(ModBlocks.GREEN_WALL_LAMP.get(), Items.GREEN_DYE);
        wallItems.put(ModBlocks.CYAN_WALL_LAMP.get(), Items.CYAN_DYE);
        wallItems.put(ModBlocks.BLUE_WALL_LAMP.get(), Items.BLUE_DYE);
        wallItems.put(ModBlocks.LIGHT_BLUE_WALL_LAMP.get(), Items.LIGHT_BLUE_DYE);
        wallItems.put(ModBlocks.YELLOW_WALL_LAMP.get(), Items.YELLOW_DYE);
        wallItems.put(ModBlocks.ORANGE_WALL_LAMP.get(), Items.ORANGE_DYE);
        wallItems.put(ModBlocks.RED_WALL_LAMP.get(), Items.RED_DYE);
        wallItems.put(ModBlocks.PINK_WALL_LAMP.get(), Items.PINK_DYE);
        wallItems.put(ModBlocks.MAGENTA_WALL_LAMP.get(), Items.MAGENTA_DYE);
        wallItems.put(ModBlocks.PURPLE_WALL_LAMP.get(), Items.PURPLE_DYE);
        for (Map.Entry<ItemLike, ItemLike> recipeItems : wallItems.entrySet()) {
            for (Map.Entry<ItemLike, ItemLike> shapelessRecipeItems : wallItems.entrySet()) {
                if (shapelessRecipeItems != recipeItems) {
                    ShapelessRecipeBuilder.shapeless(recipeItems.getKey()).requires(shapelessRecipeItems.getKey()).requires(recipeItems.getValue()).unlockedBy("has_x", has(recipeItems.getKey())).save(consumer, ItemUtil.getRegName(recipeItems.getKey().asItem()).getPath() + "_dyed_" + Objects.requireNonNull(ItemUtil.getRegName(shapelessRecipeItems.getKey().asItem())).getPath());
                }
            }
        }
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_WALL_LAMP.get(), 8).define('a', ModBlocks.WHITE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_WALL_LAMP.get()).requires(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_WALL_LAMP.get()).requires(ModBlocks.WHITE_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.WHITE_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_WALL_LAMP.get()).requires(ModBlocks.WHITE_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.WHITE_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.WHITE_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_WALL_LAMP_STATIC.get()).define('a', ModBlocks.WHITE_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_WALL_LAMP.get(), 8).define('a', ModBlocks.LIGHT_GRAY_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_WALL_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_WALL_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_WALL_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC.get()).define('a', ModBlocks.LIGHT_GRAY_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_WALL_LAMP.get(), 8).define('a', ModBlocks.GRAY_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_WALL_LAMP.get()).requires(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_WALL_LAMP.get()).requires(ModBlocks.GRAY_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.GRAY_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_WALL_LAMP.get()).requires(ModBlocks.GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GRAY_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.GRAY_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_WALL_LAMP_STATIC.get()).define('a', ModBlocks.GRAY_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_WALL_LAMP.get(), 8).define('a', ModBlocks.BLACK_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_WALL_LAMP.get()).requires(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_WALL_LAMP.get()).requires(ModBlocks.BLACK_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.BLACK_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_WALL_LAMP.get()).requires(ModBlocks.BLACK_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLACK_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.BLACK_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_WALL_LAMP_STATIC.get()).define('a', ModBlocks.BLACK_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.RED_WALL_LAMP.get(), 8).define('a', ModBlocks.RED_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_WALL_LAMP.get()).requires(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_WALL_LAMP.get()).requires(ModBlocks.RED_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.RED_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_WALL_LAMP.get()).requires(ModBlocks.RED_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.RED_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.RED_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.RED_WALL_LAMP_STATIC.get()).define('a', ModBlocks.RED_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.RED_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.RED_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_WALL_LAMP.get(), 8).define('a', ModBlocks.ORANGE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_WALL_LAMP.get()).requires(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_WALL_LAMP.get()).requires(ModBlocks.ORANGE_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_WALL_LAMP.get()).requires(ModBlocks.ORANGE_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.ORANGE_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_WALL_LAMP_STATIC.get()).define('a', ModBlocks.ORANGE_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_WALL_LAMP.get(), 8).define('a', ModBlocks.YELLOW_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_WALL_LAMP.get()).requires(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_WALL_LAMP.get()).requires(ModBlocks.YELLOW_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_WALL_LAMP.get()).requires(ModBlocks.YELLOW_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.YELLOW_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_WALL_LAMP_STATIC.get()).define('a', ModBlocks.YELLOW_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_WALL_LAMP.get(), 8).define('a', ModBlocks.BLUE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_WALL_LAMP.get()).requires(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_WALL_LAMP.get()).requires(ModBlocks.BLUE_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.BLUE_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_WALL_LAMP.get()).requires(ModBlocks.BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLUE_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.BLUE_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_WALL_LAMP_STATIC.get()).define('a', ModBlocks.BLUE_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_WALL_LAMP.get(), 8).define('a', ModBlocks.LIGHT_BLUE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_WALL_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_WALL_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_WALL_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC.get()).define('a', ModBlocks.LIGHT_BLUE_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_WALL_LAMP.get(), 8).define('a', ModBlocks.CYAN_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_WALL_LAMP.get()).requires(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_WALL_LAMP.get()).requires(ModBlocks.CYAN_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.CYAN_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_WALL_LAMP.get()).requires(ModBlocks.CYAN_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.CYAN_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.CYAN_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_WALL_LAMP_STATIC.get()).define('a', ModBlocks.CYAN_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_WALL_LAMP.get(), 8).define('a', ModBlocks.GREEN_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_WALL_LAMP.get()).requires(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_WALL_LAMP.get()).requires(ModBlocks.GREEN_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.GREEN_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_WALL_LAMP.get()).requires(ModBlocks.GREEN_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GREEN_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.GREEN_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_WALL_LAMP_STATIC.get()).define('a', ModBlocks.GREEN_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_WALL_LAMP.get(), 8).define('a', ModBlocks.PURPLE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_WALL_LAMP.get()).requires(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_WALL_LAMP.get()).requires(ModBlocks.PURPLE_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_WALL_LAMP.get()).requires(ModBlocks.PURPLE_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.PURPLE_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_WALL_LAMP_STATIC.get()).define('a', ModBlocks.PURPLE_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_WALL_LAMP.get(), 8).define('a', ModBlocks.MAGENTA_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_WALL_LAMP.get()).requires(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_WALL_LAMP.get()).requires(ModBlocks.MAGENTA_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_WALL_LAMP.get()).requires(ModBlocks.MAGENTA_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_WALL_LAMP_STATIC.get()).define('a', ModBlocks.MAGENTA_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.PINK_WALL_LAMP.get(), 8).define('a', ModBlocks.PINK_LAMP.get()).define('b', Items.IRON_INGOT).pattern("bb").pattern("ba").unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_WALL_LAMP.get()).requires(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_WALL_LAMP.get()).requires(ModBlocks.PINK_WALL_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.PINK_WALL_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_WALL_LAMP.get()).requires(ModBlocks.PINK_WALL_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PINK_WALL_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_WALL_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get()).requires(ModBlocks.PINK_WALL_LAMP.get()).unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PINK_WALL_LAMP_STATIC.get()).define('a', ModBlocks.PINK_WALL_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_WALL_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PINK_WALL_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_WALL_LAMP_ENLIGHTED.get())).save(consumer);

        HashMap<ItemLike, ItemLike> gulpItems = new HashMap<>();
        gulpItems.put(ModBlocks.WHITE_GULP_LAMP.get(), Items.WHITE_DYE);
        gulpItems.put(ModBlocks.LIGHT_GRAY_GULP_LAMP.get(), Items.LIGHT_GRAY_DYE);
        gulpItems.put(ModBlocks.GRAY_GULP_LAMP.get(), Items.GRAY_DYE);
        gulpItems.put(ModBlocks.BLACK_GULP_LAMP.get(), Items.BLACK_DYE);
        gulpItems.put(ModBlocks.GREEN_GULP_LAMP.get(), Items.GREEN_DYE);
        gulpItems.put(ModBlocks.CYAN_GULP_LAMP.get(), Items.CYAN_DYE);
        gulpItems.put(ModBlocks.BLUE_GULP_LAMP.get(), Items.BLUE_DYE);
        gulpItems.put(ModBlocks.LIGHT_BLUE_GULP_LAMP.get(), Items.LIGHT_BLUE_DYE);
        gulpItems.put(ModBlocks.YELLOW_GULP_LAMP.get(), Items.YELLOW_DYE);
        gulpItems.put(ModBlocks.ORANGE_GULP_LAMP.get(), Items.ORANGE_DYE);
        gulpItems.put(ModBlocks.RED_GULP_LAMP.get(), Items.RED_DYE);
        gulpItems.put(ModBlocks.PINK_GULP_LAMP.get(), Items.PINK_DYE);
        gulpItems.put(ModBlocks.MAGENTA_GULP_LAMP.get(), Items.MAGENTA_DYE);
        gulpItems.put(ModBlocks.PURPLE_GULP_LAMP.get(), Items.PURPLE_DYE);
        for (Map.Entry<ItemLike, ItemLike> recipeItems : gulpItems.entrySet()) {
            for (Map.Entry<ItemLike, ItemLike> shapelessRecipeItems : gulpItems.entrySet()) {
                if (shapelessRecipeItems != recipeItems) {
                    ShapelessRecipeBuilder.shapeless(recipeItems.getKey()).requires(shapelessRecipeItems.getKey()).requires(recipeItems.getValue()).unlockedBy("has_x", has(recipeItems.getKey())).save(consumer, ItemUtil.getRegName(recipeItems.getKey().asItem()).getPath() + "_dyed_" + Objects.requireNonNull(ItemUtil.getRegName(shapelessRecipeItems.getKey().asItem())).getPath());
                }
            }
        }

        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_GULP_LAMP.get(), 8).define('a', ModBlocks.WHITE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_GULP_LAMP.get()).requires(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_GULP_LAMP.get()).requires(ModBlocks.WHITE_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.WHITE_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_GULP_LAMP.get()).requires(ModBlocks.WHITE_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.WHITE_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.WHITE_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.WHITE_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.WHITE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_GULP_LAMP_STATIC.get()).define('a', ModBlocks.WHITE_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.WHITE_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.WHITE_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_GULP_LAMP.get(), 8).define('a', ModBlocks.LIGHT_GRAY_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_GULP_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_GULP_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_GULP_LAMP.get()).requires(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.LIGHT_GRAY_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC.get()).define('a', ModBlocks.LIGHT_GRAY_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_GRAY_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_GULP_LAMP.get(), 8).define('a', ModBlocks.GRAY_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_GULP_LAMP.get()).requires(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_GULP_LAMP.get()).requires(ModBlocks.GRAY_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.GRAY_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_GULP_LAMP.get()).requires(ModBlocks.GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GRAY_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.GRAY_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.GRAY_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_GULP_LAMP_STATIC.get()).define('a', ModBlocks.GRAY_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GRAY_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GRAY_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_GULP_LAMP.get(), 8).define('a', ModBlocks.BLACK_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_GULP_LAMP.get()).requires(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_GULP_LAMP.get()).requires(ModBlocks.BLACK_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.BLACK_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_GULP_LAMP.get()).requires(ModBlocks.BLACK_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLACK_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLACK_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.BLACK_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.BLACK_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_GULP_LAMP_STATIC.get()).define('a', ModBlocks.BLACK_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLACK_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLACK_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.RED_GULP_LAMP.get(), 8).define('a', ModBlocks.RED_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_GULP_LAMP.get()).requires(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_GULP_LAMP.get()).requires(ModBlocks.RED_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.RED_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_GULP_LAMP.get()).requires(ModBlocks.RED_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.RED_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.RED_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.RED_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.RED_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.RED_GULP_LAMP_STATIC.get()).define('a', ModBlocks.RED_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.RED_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.RED_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.RED_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_GULP_LAMP.get(), 8).define('a', ModBlocks.ORANGE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_GULP_LAMP.get()).requires(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_GULP_LAMP.get()).requires(ModBlocks.ORANGE_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_GULP_LAMP.get()).requires(ModBlocks.ORANGE_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.ORANGE_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.ORANGE_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.ORANGE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_GULP_LAMP_STATIC.get()).define('a', ModBlocks.ORANGE_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ORANGE_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.ORANGE_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_GULP_LAMP.get(), 8).define('a', ModBlocks.YELLOW_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_GULP_LAMP.get()).requires(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_GULP_LAMP.get()).requires(ModBlocks.YELLOW_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_GULP_LAMP.get()).requires(ModBlocks.YELLOW_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.YELLOW_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.YELLOW_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.YELLOW_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_GULP_LAMP_STATIC.get()).define('a', ModBlocks.YELLOW_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.YELLOW_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.YELLOW_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_GULP_LAMP.get(), 8).define('a', ModBlocks.BLUE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_GULP_LAMP.get()).requires(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_GULP_LAMP.get()).requires(ModBlocks.BLUE_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.BLUE_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_GULP_LAMP.get()).requires(ModBlocks.BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.BLUE_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.BLUE_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.BLUE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_GULP_LAMP_STATIC.get()).define('a', ModBlocks.BLUE_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.BLUE_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_GULP_LAMP.get(), 8).define('a', ModBlocks.LIGHT_BLUE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_GULP_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_GULP_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_GULP_LAMP.get()).requires(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.LIGHT_BLUE_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC.get()).define('a', ModBlocks.LIGHT_BLUE_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLUE_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.LIGHT_BLUE_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_GULP_LAMP.get(), 8).define('a', ModBlocks.CYAN_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_GULP_LAMP.get()).requires(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_GULP_LAMP.get()).requires(ModBlocks.CYAN_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.CYAN_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_GULP_LAMP.get()).requires(ModBlocks.CYAN_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.CYAN_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.CYAN_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.CYAN_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.CYAN_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_GULP_LAMP_STATIC.get()).define('a', ModBlocks.CYAN_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CYAN_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.CYAN_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_GULP_LAMP.get(), 8).define('a', ModBlocks.GREEN_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_GULP_LAMP.get()).requires(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_GULP_LAMP.get()).requires(ModBlocks.GREEN_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.GREEN_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_GULP_LAMP.get()).requires(ModBlocks.GREEN_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GREEN_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GREEN_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.GREEN_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.GREEN_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_GULP_LAMP_STATIC.get()).define('a', ModBlocks.GREEN_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GREEN_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GREEN_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_GULP_LAMP.get(), 8).define('a', ModBlocks.PURPLE_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_GULP_LAMP.get()).requires(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_GULP_LAMP.get()).requires(ModBlocks.PURPLE_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_GULP_LAMP.get()).requires(ModBlocks.PURPLE_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PURPLE_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.PURPLE_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.PURPLE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_GULP_LAMP_STATIC.get()).define('a', ModBlocks.PURPLE_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PURPLE_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PURPLE_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_GULP_LAMP.get(), 8).define('a', ModBlocks.MAGENTA_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_GULP_LAMP.get()).requires(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_GULP_LAMP.get()).requires(ModBlocks.MAGENTA_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_GULP_LAMP.get()).requires(ModBlocks.MAGENTA_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.MAGENTA_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.MAGENTA_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.MAGENTA_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_GULP_LAMP_STATIC.get()).define('a', ModBlocks.MAGENTA_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.MAGENTA_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.MAGENTA_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.PINK_GULP_LAMP.get(), 8).define('a', ModBlocks.PINK_LAMP.get()).define('b', Items.IRON_INGOT).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_GULP_LAMP.get()).requires(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_GULP_LAMP.get()).requires(ModBlocks.PINK_GULP_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.PINK_GULP_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_GULP_LAMP.get()).requires(ModBlocks.PINK_GULP_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.PINK_GULP_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.PINK_GULP_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get()).requires(ModBlocks.PINK_GULP_LAMP.get()).unlockedBy("has_item", has(ModBlocks.PINK_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PINK_GULP_LAMP_STATIC.get()).define('a', ModBlocks.PINK_GULP_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_GULP_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PINK_GULP_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.PINK_GULP_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GLOWSTONE_LAMP.get()).define('a', Items.GLOWSTONE).define('b', Items.GLASS_PANE).define('c', ModItems.LUMINOUS_DUST.get()).pattern("bbb").pattern("bab").pattern("bcb").unlockedBy("has_item", has(Items.GLOWSTONE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSTONE_LAMP.get()).requires(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSTONE_LAMP.get()).requires(ModBlocks.GLOWSTONE_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.GLOWSTONE_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSTONE_LAMP.get()).requires(ModBlocks.GLOWSTONE_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GLOWSTONE_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GLOWSTONE_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get()).requires(ModBlocks.GLOWSTONE_LAMP.get()).unlockedBy("has_item", has(ModBlocks.GLOWSTONE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GLOWSTONE_LAMP_STATIC.get()).define('a', ModBlocks.GLOWSTONE_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GLOWSTONE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GLOWSTONE_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GLOWSTONE_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.REDSTONE_LAMP.get()).define('a', Items.REDSTONE_LAMP).define('b', Items.GLASS_PANE).define('c', ModItems.LUMINOUS_DUST.get()).pattern("bbb").pattern("bab").pattern("bcb").unlockedBy("has_item", has(Items.REDSTONE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.REDSTONE_LAMP.get()).requires(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.REDSTONE_LAMP.get()).requires(ModBlocks.REDSTONE_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.REDSTONE_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.REDSTONE_LAMP.get()).requires(ModBlocks.REDSTONE_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.REDSTONE_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.REDSTONE_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get()).requires(ModBlocks.REDSTONE_LAMP.get()).unlockedBy("has_item", has(ModBlocks.REDSTONE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.REDSTONE_LAMP_STATIC.get()).define('a', ModBlocks.REDSTONE_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.REDSTONE_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.REDSTONE_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.REDSTONE_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.REDSTONE_LAMP_ENLIGHTED.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.GLOWSHROOM_LAMP.get()).define('a', Items.SHROOMLIGHT).define('b', Items.GLASS_PANE).define('c', ModItems.LUMINOUS_DUST.get()).pattern("bbb").pattern("bab").pattern("bcb").unlockedBy("has_item", has(Items.SHROOMLIGHT)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSHROOM_LAMP.get()).requires(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSHROOM_LAMP.get()).requires(ModBlocks.GLOWSHROOM_LAMP_STATIC.get()).unlockedBy("has_item", has(ModBlocks.GLOWSHROOM_LAMP_STATIC.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP_STATIC.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSHROOM_LAMP.get()).requires(ModBlocks.GLOWSHROOM_LAMP_STATIC_ENLIGHTED.get()).unlockedBy("has_item", has(ModBlocks.GLOWSHROOM_LAMP_STATIC_ENLIGHTED.get())).save(consumer, ItemUtil.getRegName(ModBlocks.GLOWSHROOM_LAMP_STATIC_ENLIGHTED.get()) + "_back");
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get()).requires(ModBlocks.GLOWSHROOM_LAMP.get()).unlockedBy("has_item", has(ModBlocks.GLOWSHROOM_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GLOWSHROOM_LAMP_STATIC.get()).define('a', ModBlocks.GLOWSHROOM_LAMP.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GLOWSHROOM_LAMP.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GLOWSHROOM_LAMP_STATIC_ENLIGHTED.get()).define('a', ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get()).define('b', Items.REDSTONE_TORCH).pattern("a").pattern("b").unlockedBy("has_item", has(ModBlocks.GLOWSHROOM_LAMP_ENLIGHTED.get())).save(consumer);

    }
}
