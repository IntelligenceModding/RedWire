package de.unhappycodings.redwire.redwirelampsandlighting.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.ToIntFunction;

public class LampButtonTriggerBlock extends StoneButtonBlock {

    public static final BooleanProperty TOGGLED = BooleanProperty.create("toggled");
    protected static final VoxelShape BIG_CEILING_AABB_X = Block.box(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    protected static final VoxelShape BIG_FLOOR_AABB_X = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D);
    protected static final VoxelShape BIG_NORTH_AABB = Block.box(5.0D, 5.0D, 14.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape BIG_SOUTH_AABB = Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 2.0D);
    protected static final VoxelShape BIG_WEST_AABB = Block.box(14.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape BIG_EAST_AABB = Block.box(0.0D, 5.0D, 5.0D, 2.0D, 11.0D, 11.0D);
    protected static final VoxelShape BIG_PRESSED_CEILING_AABB_X = Block.box(5.0D, 15.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    protected static final VoxelShape BIG_PRESSED_FLOOR_AABB_X = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D);
    protected static final VoxelShape BIG_PRESSED_NORTH_AABB = Block.box(5.0D, 5.0D, 15.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape BIG_PRESSED_SOUTH_AABB = Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 1.0D);
    protected static final VoxelShape BIG_PRESSED_WEST_AABB = Block.box(15.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape BIG_PRESSED_EAST_AABB = Block.box(0.0D, 5.0D, 5.0D, 1.0D, 11.0D, 11.0D);

    protected static final VoxelShape SMALL_CEILING_AABB_X = Block.box(6.0D, 14.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    protected static final VoxelShape SMALL_FLOOR_AABB_X = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 2.0D, 10.0D);
    protected static final VoxelShape SMALL_NORTH_AABB = Block.box(6.0D, 6.0D, 14.0D, 10.0D, 10.0D, 16.0D);
    protected static final VoxelShape SMALL_SOUTH_AABB = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 2.0D);
    protected static final VoxelShape SMALL_WEST_AABB = Block.box(14.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);
    protected static final VoxelShape SMALL_EAST_AABB = Block.box(0.0D, 6.0D, 6.0D, 2.0D, 10.0D, 10.0D);
    protected static final VoxelShape SMALL_PRESSED_CEILING_AABB_X = Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    protected static final VoxelShape SMALL_PRESSED_FLOOR_AABB_X = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 1.0D, 10.0D);
    protected static final VoxelShape SMALL_PRESSED_NORTH_AABB = Block.box(6.0D, 6.0D, 15.0D, 10.0D, 10.0D, 16.0D);
    protected static final VoxelShape SMALL_PRESSED_SOUTH_AABB = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 1.0D);
    protected static final VoxelShape SMALL_PRESSED_WEST_AABB = Block.box(15.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);
    protected static final VoxelShape SMALL_PRESSED_EAST_AABB = Block.box(0.0D, 6.0D, 6.0D, 1.0D, 10.0D, 10.0D);
    public String type;

    public LampButtonTriggerBlock(String type) {
        super(Properties.copy(Blocks.STONE_BUTTON));
        this.type = type;
        registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.FALSE).setValue(FACE, AttachFace.WALL).setValue(TOGGLED, false));
    }

    public LampButtonTriggerBlock(String type, boolean inverted) {
        super(Properties.copy(Blocks.STONE_BUTTON).lightLevel(poweredBlockEmission(inverted)));
        this.type = type;
        registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.FALSE).setValue(FACE, AttachFace.WALL).setValue(TOGGLED, false));
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        if (inverted) return (p_50763_) -> !p_50763_.getValue(BlockStateProperties.POWERED) ? 15 : 0;
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.POWERED) ? 15 : 0;
    }

    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState p_51104_, @NotNull BlockGetter p_51105_, @NotNull BlockPos p_51106_, @NotNull CollisionContext p_51107_) {
        if (Objects.equals(type, "normal")) return super.getShape(p_51104_, p_51105_, p_51106_, p_51107_);
        Direction direction = p_51104_.getValue(FACING);
        boolean flag = p_51104_.getValue(POWERED);
        AttachFace value = p_51104_.getValue(FACE);
        if (Objects.equals(type, "big")) {
            if (value == AttachFace.FLOOR) {
                return flag ? BIG_PRESSED_FLOOR_AABB_X : BIG_FLOOR_AABB_X;
            } else if (value == AttachFace.WALL) {
                return switch (direction) {
                    case EAST -> flag ? BIG_PRESSED_EAST_AABB : BIG_EAST_AABB;
                    case WEST -> flag ? BIG_PRESSED_WEST_AABB : BIG_WEST_AABB;
                    case SOUTH -> flag ? BIG_PRESSED_SOUTH_AABB : BIG_SOUTH_AABB;
                    default -> flag ? BIG_PRESSED_NORTH_AABB : BIG_NORTH_AABB;
                };
            }
            return flag ? BIG_PRESSED_CEILING_AABB_X : BIG_CEILING_AABB_X;
        } else {
            if (value == AttachFace.FLOOR) {
                return flag ? SMALL_PRESSED_FLOOR_AABB_X : SMALL_FLOOR_AABB_X;
            } else if (value == AttachFace.WALL) {
                return switch (direction) {
                    case EAST -> flag ? SMALL_PRESSED_EAST_AABB : SMALL_EAST_AABB;
                    case WEST -> flag ? SMALL_PRESSED_WEST_AABB : SMALL_WEST_AABB;
                    case SOUTH -> flag ? SMALL_PRESSED_SOUTH_AABB : SMALL_SOUTH_AABB;
                    default -> flag ? SMALL_PRESSED_NORTH_AABB : SMALL_NORTH_AABB;
                };
            }
            return flag ? SMALL_PRESSED_CEILING_AABB_X : SMALL_CEILING_AABB_X;
        }
    }

    @NotNull
    @Override
    public InteractionResult use(@NotNull BlockState p_51088_, @NotNull Level p_51089_, @NotNull BlockPos p_51090_, @NotNull Player p_51091_, @NotNull InteractionHand p_51092_, @NotNull BlockHitResult p_51093_) {
        this.press(p_51088_, p_51089_, p_51090_);
        this.playSound(p_51091_, p_51089_, p_51090_, !p_51088_.getValue(TOGGLED));
        return InteractionResult.sidedSuccess(p_51089_.isClientSide);
    }

    // Needed to prevent the button from snapping back!
    @Override
    public void tick(BlockState p_220903_, ServerLevel p_220904_, BlockPos p_220905_, RandomSource p_220906_) {

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> p_51101_) {
        super.createBlockStateDefinition(p_51101_);
        p_51101_.add(TOGGLED);
    }

    @Override
    public void press(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos) {
        if (blockState.getValue(TOGGLED)) {
            level.setBlock(blockPos, blockState.setValue(TOGGLED, Boolean.FALSE).setValue(POWERED, Boolean.FALSE), 3);
            this.updateNeighbours(blockState, level, blockPos);
            return;
        }
        level.setBlock(blockPos, blockState.setValue(TOGGLED, Boolean.TRUE).setValue(POWERED, Boolean.TRUE), 3);
        this.updateNeighbours(blockState, level, blockPos);
    }


    private void updateNeighbours(BlockState p_51125_, Level p_51126_, BlockPos p_51127_) {
        p_51126_.updateNeighborsAt(p_51127_, this);
        p_51126_.updateNeighborsAt(p_51127_.relative(getConnectedDirection(p_51125_).getOpposite()), this);
    }
}
