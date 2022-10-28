package de.unhappycodings.redwire.redwiredoors.common.block;

import de.unhappycodings.redwire.redwiredoors.common.blockentity.BigSlidingDoorEntity;
import de.unhappycodings.redwire.redwiredoors.common.util.LocationUtil;
import de.unhappycodings.redwire.redwiredoors.common.util.TextComponentUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BigSlidingDoorBlock extends BaseEntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    public RegistryObject<BlockEntityType<BigSlidingDoorEntity>> registryObject;

    protected static final VoxelShape OPEN_NS_1 = Shapes.or(Block.box(-16, 0, 7, 8, 32, 9), Block.box(8, 0, 7, 32, 32, 9));
    protected static final VoxelShape OPEN_NS_2 = Shapes.or(Block.box(-16, 0, 7, 3.5, 32, 9), Block.box(12.5, 0, 7, 32, 32, 9));
    protected static final VoxelShape OPEN_NS_3 = Shapes.or(Block.box(-16, 0, 7, -1, 32, 9), Block.box(17, 0, 7, 32, 32, 9));
    protected static final VoxelShape OPEN_NS_4 = Shapes.or(Block.box(-16, 0, 7, -5.5, 32, 9), Block.box(21.5, 0, 7, 32, 32, 9));
    protected static final VoxelShape OPEN_NS_5 = Shapes.or(Block.box(-16, 0, 7, -11.15, 32, 9), Block.box(27.15, 0, 7, 32, 32, 9));

    protected static final VoxelShape OPEN_EW_1 = Shapes.or(Block.box(7, 0, 8, 9, 32, 32), Block.box(7, 0, -16, 9, 32, 8.0));
    protected static final VoxelShape OPEN_EW_2 = Shapes.or(Block.box(7, 0, 12.5, 9, 32, 32), Block.box(7, 0, -16, 9, 32, 3.5));
    protected static final VoxelShape OPEN_EW_3 = Shapes.or(Block.box(7, 0, 17, 9, 32, 32), Block.box(7, 0, -16, 9, 32, -1));
    protected static final VoxelShape OPEN_EW_4 = Shapes.or(Block.box(7, 0, 21.5, 9, 32, 32), Block.box(7, 0, -16, 9, 32, -5.5));
    protected static final VoxelShape OPEN_EW_5 = Shapes.or(Block.box(7, 0, 27.15, 9, 32, 32), Block.box(7, 0, -16, 9, 32, -11.15));

    protected BigSlidingDoorBlock(RegistryObject<BlockEntityType<BigSlidingDoorEntity>> registryObject) {
        super(Properties.copy(Blocks.STONE).noOcclusion());
        this.registryObject = registryObject;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false)
                .setValue(REMOTED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(POWERED, context.getLevel().hasNeighborSignal(context.getClickedPos())).setValue(REMOTED, false);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        boolean xState = LocationUtil.getBigSlidingDoorRedstoneState(level, pos);
        if (!state.getValue(REMOTED)) {
            level.setBlock(pos, state.setValue(POWERED, xState), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, REMOTED);
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = state.getValue(FACING);
        if (!(level.getBlockEntity(pos) instanceof BigSlidingDoorEntity blockEntity)) return Shapes.empty();
        CompoundTag tag = new CompoundTag();
        blockEntity.saveAdditional(tag);

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            switch (tag.getByte("state")) {
                case 1:
                    return OPEN_NS_1;
                case 2:
                    return OPEN_NS_2;
                case 3:
                    return OPEN_NS_3;
                case 4:
                    return OPEN_NS_4;
                case 5:
                    return OPEN_NS_5;
            }
        }
        switch (tag.getByte("state")) {
            case 1:
                return OPEN_EW_1;
            case 2:
                return OPEN_EW_2;
            case 3:
                return OPEN_EW_3;
            case 4:
                return OPEN_EW_4;
            case 5:
                return OPEN_EW_5;
        }
        return Shapes.empty();
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {

        tooltipComponents.add(Component.translatable("item.redwiredoors.tooltip.big_sliding_door.size").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.redwiredoors.tooltip.big_sliding_door.controllableby").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(TextComponentUtil.getTComp("tooltip.big_sliding_door.information_1", false, ChatFormatting.DARK_RED));
        tooltipComponents.add(TextComponentUtil.getTComp("tooltip.big_sliding_door.information_2", false, ChatFormatting.DARK_RED));
        tooltipComponents.add(TextComponentUtil.getTComp("tooltip.big_sliding_door.information_3", false, ChatFormatting.DARK_RED));
        tooltipComponents.add(Component.literal(" "));
        tooltipComponents.add(TextComponentUtil.getTComp("tooltip.big_sliding_door.information_4", false, ChatFormatting.DARK_RED));

        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : (a, b, c, blockEntity) -> ((BigSlidingDoorEntity) blockEntity).tick();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return registryObject.get().create(pos, state);
    }

}
