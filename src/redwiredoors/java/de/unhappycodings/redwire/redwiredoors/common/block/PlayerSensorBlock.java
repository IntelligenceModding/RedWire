package de.unhappycodings.redwire.redwiredoors.common.block;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.PlayerSensorEntity;
import de.unhappycodings.redwire.redwiredoors.common.util.TextComponentUtil;
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
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class PlayerSensorBlock extends BaseEntityBlock {
    public static final EnumProperty<AttachFace> FACE = BlockStateProperties.ATTACH_FACE;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public RegistryObject<BlockEntityType<PlayerSensorEntity>> registryObject;

    protected static final VoxelShape NORTH = Block.box(4.5, 0, 15.4, 11.5, 1.25, 16);
    protected static final VoxelShape EAST = Block.box(0, 0, 4.5, 0.6, 1.25, 11.5);
    protected static final VoxelShape SOUTH = Block.box(4.5, 0, 0, 11.5, 1.25, 0.6);
    protected static final VoxelShape WEST = Block.box(15.4, 0, 4.5, 16, 1.25, 11.5);

    public PlayerSensorBlock(RegistryObject<BlockEntityType<PlayerSensorEntity>> registryObject) {
        super(Properties.of(Material.STONE));
        this.registryObject = registryObject;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACE, AttachFace.WALL)
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false));
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case EAST -> EAST;
            case WEST -> WEST;
            case SOUTH -> SOUTH;
            default -> NORTH;
        };
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSignalSource(@NotNull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getSignal(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull Direction direction) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getDirectSignal(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull Direction direction) {
        return state.getValue(POWERED) && state.getValue(FACING) == direction ? 15 : 0;
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(POWERED, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING, POWERED);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {

        tooltipComponents.add(TextComponentUtil.getTComp("tooltip.player_sensor_1", false, ChatFormatting.GRAY).append(" ")
                .append(Component.literal("2").setStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR)))
                .append(Component.literal("x").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                .append(Component.literal("3").setStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR))).append(" ")
                .append(Component.translatable("block.blocksmod.player_sensor").withStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR))));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(TextComponentUtil.getTComp("tooltip.player_sensor_2", false, ChatFormatting.GRAY).append(" ")
                .append(Component.translatable("block.blocksmod.all_remotables").withStyle(Style.EMPTY.withColor(RedwireDoors.MOD_COLOR_SUB))));

        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : (a, b, c, blockEntity) -> ((PlayerSensorEntity) blockEntity).tick();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return registryObject.get().create(pos, state);
    }

}

