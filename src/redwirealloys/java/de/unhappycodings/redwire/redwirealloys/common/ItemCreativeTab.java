package de.unhappycodings.redwire.redwirealloys.common;

import de.unhappycodings.redwire.redwirealloys.RedwireAlloys;
import de.unhappycodings.redwire.redwirealloys.common.block.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class ItemCreativeTab extends CreativeModeTab {

    public ItemCreativeTab() {
        super(RedwireAlloys.MOD_ID + ".items");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModBlocks.RED_ALLOY_WIRE.get());
    }

    @Override
    public void fillItemList(@NotNull NonNullList<ItemStack> items) {
        int index = 0;

        ArrayList<Block> blockList = new ArrayList<>();
        Collections.addAll(blockList, ModBlocks.RED_ALLOY_WIRE.get());

        for (Block i : blockList) {
            items.add(index, new ItemStack(i));
            index++;
        }
    }

}