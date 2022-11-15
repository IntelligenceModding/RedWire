package de.unhappycodings.redwire.redwirealloys.common.item;

import de.unhappycodings.redwire.redwirealloys.common.blockentity.WireBlockEntity;
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
    public static final byte ALL_OPTS = 63;

    public WireBlockItem(Block pBlock) {
        super(pBlock, new Properties());
    }

    @NotNull
    @Override
    public InteractionResult place(@NotNull BlockPlaceContext context) {
        super.place(context);

        if (context.getLevel().getBlockEntity(context.getClickedPos()) instanceof WireBlockEntity entity) {
            String side = context.getClickedFace().getOpposite().getName();
            Player player = context.getPlayer();
            Level level = context.getLevel();
            byte sides = entity.getSides();
            if (!getSides(sides).contains(side)) {
                if (!context.getLevel().isClientSide) {
                    entity.setSides((byte) (sides + getSideValue(side)));
                    entity.setChanged();
                    ItemStack playerItem = player.getItemInHand(InteractionHand.MAIN_HAND);
                    if (!player.isCreative())
                        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(playerItem.getItem(), playerItem.getCount() -1));
                    level.sendBlockUpdated(context.getClickedPos(), level.getBlockState(context.getClickedPos()), level.getBlockState(context.getClickedPos()), Block.UPDATE_ALL);
                }
                level.playLocalSound(context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
                player.swing(InteractionHand.MAIN_HAND);
                return InteractionResult.CONSUME;
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME;
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

}
