package de.unhappycodings.redwire.redwiredoors.common;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
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
        return new ItemStack(ModBlocks.BIG_SLIDING_DOOR.get());
    }

    @Override
    public void fillItemList(@NotNull NonNullList<ItemStack> items) {
        int index = 0;

        ArrayList<Block> blockList = new ArrayList<>();
        Collections.addAll(blockList, ModBlocks.BIG_SLIDING_DOOR.get(), ModBlocks.WHITE_PLAYER_SENSOR_BLOCK.get(), ModBlocks.GRAY_PLAYER_SENSOR_BLOCK.get(), ModBlocks.BLACK_PLAYER_SENSOR_BLOCK.get());

        for (Block i : blockList) {
            items.add(index, new ItemStack(i));
            index++;
        }
    }

}