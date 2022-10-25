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
import java.util.Objects;
import java.util.function.ToIntFunction;

public class LampFlatBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    protected static final VoxelShape CEILING_AABB_X = Block.box(6, 15, 6, 10, 16, 10);
    protected static final VoxelShape FLOOR_AABB_X = Block.box(6, 0, 6, 10, 1, 10);
    protected static final VoxelShape NORTH_AABB = Block.box(6, 6, 15, 10, 10, 16);
    protected static final VoxelShape SOUTH_AABB = Block.box(6, 6, 0, 10, 10, 1);
    protected static final VoxelShape WEST_AABB = Block.box(15, 6, 6, 16, 10, 10);
    protected static final VoxelShape EAST_AABB = Block.box(0, 6, 6, 1, 10, 10);
    protected static final VoxelShape FRAMED_CEILING_AABB_X = Block.box(5, 15, 5, 11, 16, 11);
    protected static final VoxelShape FRAMED_FLOOR_AABB_X = Block.box(5, 0, 5, 11, 1, 11);
    protected static final VoxelShape FRAMED_NORTH_AABB = Block.box(5, 5, 15, 11, 11, 16);
    protected static final VoxelShape FRAMED_SOUTH_AABB = Block.box(5, 5, 0, 11, 11, 1);
    protected static final VoxelShape FRAMED_WEST_AABB = Block.box(15, 5, 5, 16, 11, 11);
    protected static final VoxelShape FRAMED_EAST_AABB = Block.box(0, 5, 5, 1, 11, 11);
    protected static final VoxelShape BIG_CEILING_AABB_X = Block.box(4, 15, 4, 12, 16, 12);
    protected static final VoxelShape BIG_FLOOR_AABB_X = Block.box(4, 0, 4, 12, 1, 12);
    protected static final VoxelShape BIG_NORTH_AABB = Block.box(4, 4, 15, 12, 12, 16);
    protected static final VoxelShape BIG_SOUTH_AABB = Block.box(4, 4, 0, 12, 12, 1);
    protected static final VoxelShape BIG_WEST_AABB = Block.box(15, 4, 4, 16, 12, 12);
    protected static final VoxelShape BIG_EAST_AABB = Block.box(0, 4, 4, 1, 12, 12);
    protected static final VoxelShape HUGE_CEILING_AABB_X = Block.box(3, 15, 3, 13, 16, 13);
    protected static final VoxelShape HUGE_FLOOR_AABB_X = Block.box(3, 0, 3, 13, 1, 13);
    protected static final VoxelShape HUGE_NORTH_AABB = Block.box(3, 3, 15, 13, 13, 16);
    protected static final VoxelShape HUGE_SOUTH_AABB = Block.box(3, 3, 0, 13, 13, 1);
    protected static final VoxelShape HUGE_WEST_AABB = Block.box(15, 3, 3, 16, 13, 13);
    protected static final VoxelShape HUGE_EAST_AABB = Block.box(0, 3, 3, 1, 13, 13);
    public boolean inverted;
    public boolean powerable;
    public String type;

    public LampFlatBlock(boolean powerable, boolean inverted, String type) {
        super(Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(poweredBlockEmission(inverted)));
        this.inverted = inverted;
        this.powerable = powerable;
        this.type = type;

        registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false)
                .setValue(REMOTED, false)
                .setValue(FACE, AttachFace.WALL));
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = state.getValue(FACING);
        AttachFace value = state.getValue(FACE);
        if (value == AttachFace.FLOOR) {
            if (Objects.equals(type, "normal"))
                return FLOOR_AABB_X;
            if (Objects.equals(type, "framed"))
                return FRAMED_FLOOR_AABB_X;
            if (Objects.equals(type, "big"))
                return BIG_FLOOR_AABB_X;
            if (Objects.equals(type, "huge"))
                return HUGE_FLOOR_AABB_X;
        } else if (value == AttachFace.WALL) {
            if (Objects.equals(type, "normal"))
                return switch (direction) {
                    case EAST -> EAST_AABB;
                    case WEST -> WEST_AABB;
                    case SOUTH -> SOUTH_AABB;
                    default -> NORTH_AABB;
                };
            if (Objects.equals(type, "framed"))
                return switch (direction) {
                    case EAST -> FRAMED_EAST_AABB;
                    case WEST -> FRAMED_WEST_AABB;
                    case SOUTH -> FRAMED_SOUTH_AABB;
                    default -> FRAMED_NORTH_AABB;
                };
            if (Objects.equals(type, "big"))
                return switch (direction) {
                    case EAST -> BIG_EAST_AABB;
                    case WEST -> BIG_WEST_AABB;
                    case SOUTH -> BIG_SOUTH_AABB;
                    default -> BIG_NORTH_AABB;
                };
            if (Objects.equals(type, "huge"))
                return switch (direction) {
                    case EAST -> HUGE_EAST_AABB;
                    case WEST -> HUGE_WEST_AABB;
                    case SOUTH -> HUGE_SOUTH_AABB;
                    default -> HUGE_NORTH_AABB;
                };
        }
        if (Objects.equals(type, "framed"))
            return FRAMED_CEILING_AABB_X;
        if (Objects.equals(type, "big"))
            return BIG_CEILING_AABB_X;
        if (Objects.equals(type, "huge"))
            return HUGE_CEILING_AABB_X;
        return CEILING_AABB_X;
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
