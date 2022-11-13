package de.unhappycodings.redwire.redwiredoors.common.util;

import de.unhappycodings.redwire.redwiredoors.common.block.BigSlidingDoorBlock;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.BigSlidingDoorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class LocationUtil {

    public static boolean getBigSlidingDoorRedstoneState(Level level, BlockPos origin) {
        BlockPos above;
        BlockPos left;
        BlockPos leftAbove;
        BlockPos right;
        BlockPos rightAbove;
        Direction facing = level.getBlockState(origin).getValue(HorizontalDirectionalBlock.FACING);
        boolean xState = false;
        if (facing == Direction.NORTH || facing == Direction.SOUTH) {
            left = origin.offset(-1, 0, 0);
            leftAbove = origin.offset(-1, 1, 0);
            above = origin.offset(0, 1, 0);
            rightAbove = origin.offset(1, 1, 0);
            right = origin.offset(1, 0, 0);
        } else {
            left = origin.offset(0, 0, -1);
            leftAbove = origin.offset(0, 1, -1);
            above = origin.offset(0, 1, 0);
            rightAbove = origin.offset(0, 1, 1);
            right = origin.offset(0, 0, 1);
        }
        BlockPos[] posList = {origin, left, leftAbove, above, rightAbove, right};
        for (BlockPos pos : posList) {
            if (level.getBlockState(pos).getBlock() != Blocks.AIR) {
                if (level.hasNeighborSignal(pos)) {
                    xState = true;
                }
            }
        }
        if (level.getBlockState(origin).getValue(BigSlidingDoorBlock.REMOTED))
            xState = true;
        return xState;
    }

}
