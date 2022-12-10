package de.unhappycodings.redwire.redwirealloys.common.item;

import de.unhappycodings.redwire.redwirealloys.common.blockentity.WireBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WireBlockItem extends BlockItem {
    public static final byte UP = 1;
    public static final byte DOWN = 2;
    public static final byte NORTH = 4;
    public static final byte EAST = 8;
    public static final byte SOUTH = 16;
    public static final byte WEST = 32;

    public WireBlockItem(Block pBlock) {
        super(pBlock, new Properties());
    }

    public static ArrayList<String> getSides(byte sideValue) {
        ArrayList<String> stringList = new ArrayList<>();
        for (byte aByte : new byte[]{UP, DOWN, NORTH, EAST, SOUTH, WEST})
            if ((sideValue & aByte) == aByte) stringList.add(getSideName(aByte));
        return stringList;
    }

    public static String getSideName(byte sideValue) {
        return switch (sideValue) {
            case UP -> "up";
            case DOWN -> "down";
            case NORTH -> "north";
            case EAST -> "east";
            case SOUTH -> "south";
            default -> "west";
        };
    }

    public static byte getSideValue(String sideValue) {
        return switch (sideValue) {
            case "up" -> UP;
            case "down" -> DOWN;
            case "north" -> NORTH;
            case "east" -> EAST;
            case "south" -> SOUTH;
            default -> WEST;
        };
    }

    @NotNull
    @Override
    public InteractionResult place(@NotNull BlockPlaceContext context) {
        super.place(context);
        if (context.getLevel().getBlockEntity(context.getClickedPos()) instanceof WireBlockEntity entity) { // Prevent Air
            String side = context.getClickedFace().getOpposite().getName();
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();
            Level level = context.getLevel();
            byte sides = entity.getSides();
            if (!getSides(sides).contains(side)) {
                if (!context.getLevel().isClientSide) {
                    entity.setSides((byte) (sides + getSideValue(side)));
                    entity.setChanged();
                    ItemStack playerItem = player.getItemInHand(InteractionHand.MAIN_HAND);
                    if (!player.isCreative())
                        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(playerItem.getItem(), playerItem.getCount() - 1));
                    level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), Block.UPDATE_ALL);
                }
                level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
                player.swing(InteractionHand.MAIN_HAND);
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME;
    }

}
