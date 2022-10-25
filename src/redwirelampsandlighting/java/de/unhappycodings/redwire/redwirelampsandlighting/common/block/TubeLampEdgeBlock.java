package de.unhappycodings.redwire.redwirelampsandlighting.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TubeLampEdgeBlock extends TubeLampBlock {

    protected static final VoxelShape ALL_N_FLOOR = Shapes.or(Block.box(7, 0, 0, 9, 1.5, 9), Block.box(0, 0, 7, 7, 1.5, 9));
    protected static final VoxelShape ALL_E_FLOOR = Shapes.or(Block.box(7, 0, 7, 16, 1.5, 9), Block.box(7, 0, 0, 9, 1.5, 7));
    protected static final VoxelShape ALL_S_FLOOR = Shapes.or(Block.box(7, 0, 7, 9, 1.5, 16), Block.box(9, 0, 7, 16, 1.5, 9));
    protected static final VoxelShape ALL_W_FLOOR = Shapes.or(Block.box(0, 0, 7, 9, 1.5, 9), Block.box(7, 0, 9, 9, 1.5, 16));

    protected static final VoxelShape ALL_N_WALL = Shapes.or(Block.box(14.5, 7, 0, 16, 9, 16), Block.box(0, 7, 14.5, 14.5, 9, 16));
    protected static final VoxelShape ALL_E_WALL = Shapes.or(Block.box(0, 7, 14.5, 16, 9, 16), Block.box(0, 7, 0, 1.5, 9, 14.5));
    protected static final VoxelShape ALL_S_WALL = Shapes.or(Block.box(0, 7, 0, 1.5, 9, 16), Block.box(1.5, 7, 0, 16, 9, 1.5));
    protected static final VoxelShape ALL_W_WALL = Shapes.or(Block.box(0, 7, 0, 16, 9, 1.5), Block.box(14.5, 7, 1.5, 16, 9, 16));

    protected static final VoxelShape ALL_N_CEILING = Shapes.or(Block.box(7, 14.5, 0, 9, 16, 9), Block.box(0, 14.5, 7, 7, 16, 9));
    protected static final VoxelShape ALL_E_CEILING = Shapes.or(Block.box(7, 14.5, 7, 16, 16, 9), Block.box(7, 14.5, 0, 9, 16, 7));
    protected static final VoxelShape ALL_S_CEILING = Shapes.or(Block.box(7, 14.5, 7, 9, 16, 16), Block.box(9, 14.5, 7, 16, 16, 9));
    protected static final VoxelShape ALL_W_CEILING = Shapes.or(Block.box(0, 14.5, 7, 9, 16, 9), Block.box(7, 14.5, 9, 9, 16, 16));

    public TubeLampEdgeBlock(boolean powerable, boolean inverted) {
        super(powerable, inverted);
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = state.getValue(FACING);
        AttachFace value = state.getValue(FACE);
        if (value == AttachFace.FLOOR) {
            if (direction == Direction.NORTH)
                return ALL_S_FLOOR;
            if (direction == Direction.EAST)
                return ALL_W_FLOOR;
            if (direction == Direction.SOUTH)
                return ALL_N_FLOOR;
            if (direction == Direction.WEST)
                return ALL_E_FLOOR;
        } else if (value == AttachFace.WALL) {
            if (direction == Direction.NORTH)
                return ALL_N_WALL;
            if (direction == Direction.EAST)
                return ALL_E_WALL;
            if (direction == Direction.SOUTH)
                return ALL_S_WALL;
            if (direction == Direction.WEST)
                return ALL_W_WALL;
        }
        if (direction == Direction.NORTH)
            return ALL_E_CEILING;
        if (direction == Direction.EAST)
            return ALL_S_CEILING;
        if (direction == Direction.SOUTH)
            return ALL_W_CEILING;
        if (direction == Direction.WEST)
            return ALL_N_CEILING;
        return ALL_S_FLOOR;
    }
}
