package de.unhappycodings.redwire.redwiredoors.common;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class ItemCreativeTab extends CreativeModeTab {

    public ItemCreativeTab() {
        super(RedwireDoors.MOD_ID + ".items");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Blocks.STONE);
    }

    @Override
    public void fillItemList(@NotNull NonNullList<ItemStack> items) {
        int index = 0;

        ArrayList<Item> blockList = new ArrayList<>();
        Collections.addAll(blockList, Blocks.STONE.asItem());

        for (Item i : blockList) {
            items.add(index, new ItemStack(i));
            index++;
        }
    }

}