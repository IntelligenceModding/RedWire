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
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class LampWallBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    protected static final VoxelShape NORTH = Block.box(4, 6, 13, 12, 10, 16);
    protected static final VoxelShape EAST = Block.box(0, 6, 4, 3, 10, 12);
    protected static final VoxelShape SOUTH = Block.box(4, 6, 0, 12, 10, 3);
    protected static final VoxelShape WEST = Block.box(13, 6, 4, 16, 10, 12);

    public boolean inverted;
    public boolean powerable;

    public LampWallBlock(boolean powerable, boolean inverted) {
        super(Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(poweredBlockEmission(inverted)));
        this.inverted = inverted;
        this.powerable = powerable;

        registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false).setValue(REMOTED, false));
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case DOWN, UP -> null;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            case EAST -> EAST;
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
                blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
            } else {
                blockState = this.defaultBlockState().setValue(FACING, direction.getOpposite());
            }
            blockState.setValue(REMOTED, false);
            if (context.getLevel().hasNeighborSignal(context.getClickedPos())) {
                if (inverted) {
                    if (powerable) {
                        return blockState.setValue(LIT, false);
                    }
                    return blockState.setValue(LIT, true);
                } else {
                    if (powerable) {
                        return blockState.setValue(LIT, true);
                    }
                    return blockState.setValue(LIT, false);
                }
            } else {
                if (inverted) {
                    return blockState.setValue(LIT, true);
                }
                return blockState.setValue(LIT, false);
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
        builder.add(FACING, LIT, REMOTED);
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
