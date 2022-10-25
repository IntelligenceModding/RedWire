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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class LampGulpBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    protected static final VoxelShape CEILING = Shapes.or(Block.box(6, 15, 6, 10, 16, 10), Block.box(7, 11.5, 7, 9, 15, 9));
    protected static final VoxelShape FLOOR = Shapes.or(Block.box(6, 0, 6, 10, 1, 10), Block.box(7, 1, 7, 9, 4.5, 9));
    protected static final VoxelShape NORTH = Shapes.or(Block.box(6, 6, 15, 10, 10, 16), Block.box(7, 7, 11.5, 9, 9, 15));
    protected static final VoxelShape SOUTH = Shapes.or(Block.box(1, 7, 7, 4.5, 9, 9), Block.box(0, 6, 6, 1, 10, 10));
    protected static final VoxelShape WEST = Shapes.or(Block.box(6, 6, 0, 10, 10, 1), Block.box(7, 7, 1, 9, 9, 4.5));
    protected static final VoxelShape EAST = Shapes.or(Block.box(11.5, 7, 7, 15, 9, 9), Block.box(15, 6, 6, 16, 10, 10));

    public boolean inverted;
    public boolean powerable;

    public LampGulpBlock(boolean powerable, boolean inverted) {
        super(Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(poweredBlockEmission(inverted)));
        this.inverted = inverted;
        this.powerable = powerable;

        registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false).setValue(REMOTED, false).setValue(FACE, AttachFace.WALL));
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (state.getValue(FACE) == AttachFace.CEILING) return CEILING;
        if (state.getValue(FACE) == AttachFace.FLOOR) return FLOOR;
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            default -> EAST;
        };
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

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState;
        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                blockState = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, context.getHorizontalDirection());
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
        if (powerable) {
            tooltipComponents.add(Component.literal("Wireless Controllable: ").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)).append(Component.literal("Yes").setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN))));
        } else {
            tooltipComponents.add(Component.literal("Wireless Controllable: ").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)).append(Component.literal("No").setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
        }
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

}
