package de.unhappycodings.redwire.common;

import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.block.ModBlocks;
import de.unhappycodings.redwire.common.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class ItemCreativeTab extends CreativeModeTab {

    public ItemCreativeTab() {
        super(RedwireCore.MOD_ID + ".items");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModBlocks.WIRELESS_CONTROLLER.get());
    }

    @Override
    public void fillItemList(@NotNull NonNullList<ItemStack> items) {
        int index = 0;

        ArrayList<Item> blockList = new ArrayList<>();
        Collections.addAll(blockList, ModBlocks.WIRELESS_CONTROLLER.get().asItem(), ModItems.LINKING_CARD.get().asItem());

        for (Item i : blockList) {
            items.add(index, new ItemStack(i));
            index++;
        }
    }

}