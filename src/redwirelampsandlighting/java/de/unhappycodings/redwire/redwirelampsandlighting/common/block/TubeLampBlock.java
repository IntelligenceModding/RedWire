package de.unhappycodings.redwire.redwirelampsandlighting.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class TubeLampBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    protected static final VoxelShape ALL_EW_FLOOR = Block.box(7, 0, 0, 9, 1.50, 16);
    protected static final VoxelShape ALL_NS_FLOOR = Block.box(0, 0, 7, 16, 1.50, 9);

    protected static final VoxelShape ALL_N_WALL = Block.box(0, 7, 14.50, 16, 9, 16);
    protected static final VoxelShape ALL_E_WALL = Block.box(0, 7, 0, 1.50, 9, 16);
    protected static final VoxelShape ALL_S_WALL = Block.box(0, 7, 0, 16, 9, 1.50);
    protected static final VoxelShape ALL_W_WALL = Block.box(14.50, 7, 0, 16, 9, 16);

    protected static final VoxelShape ALL_EW_CEILING = Block.box(7, 14.50, 0, 9, 16, 16);
    protected static final VoxelShape ALL_NS_CEILING = Block.box(0, 14.50, 7, 16, 16, 9);

    public boolean inverted;
    public boolean powerable;

    public TubeLampBlock(boolean powerable, boolean inverted) {
        super(Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(poweredBlockEmission(inverted)));
        this.inverted = inverted;
        this.powerable = powerable;

        registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false)
                .setValue(REMOTED, false)
                .setValue(FACE, AttachFace.WALL));
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState;
        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                blockState = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR)
                        .setValue(FACING, context.getHorizontalDirection());
            } else {
                blockState = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite());
            }
            blockState.setValue(REMOTED, false);
            if (context.getLevel().hasNeighborSignal(context.getClickedPos())) {
                if (inverted) {
                    return blockState.setValue(LIT, !powerable);
                } else {
                    return blockState.setValue(LIT, powerable);
                }
            } else {
                return blockState.setValue(LIT, inverted);
            }
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (powerable) {
            if (!state.getValue(REMOTED)) {
                if (inverted) {
                    level.setBlock(pos, state.setValue(LIT, !level.hasNeighborSignal(pos)), 3);
                } else {
                    level.setBlock(pos, state.setValue(LIT, level.hasNeighborSignal(pos)), 3);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = state.getValue(FACING);
        AttachFace value = state.getValue(FACE);
        if (value == AttachFace.FLOOR) {
            if (direction == Direction.NORTH || direction == Direction.SOUTH)
                return ALL_NS_FLOOR;
            return ALL_EW_FLOOR;
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
        if (direction == Direction.NORTH || direction == Direction.SOUTH)
            return ALL_NS_CEILING;
        return ALL_EW_CEILING;
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT, FACE, REMOTED);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {
        tooltipComponents.add(Component.literal("Wireless Controllable: ").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW))
                .append(Component.literal("Yes").setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN))));
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

}
