package de.unhappycodings.redwire.redwiredoors.common.block;

import de.unhappycodings.redwire.redwiredoors.common.blockentity.BigSlidingDoorEntity;
import de.unhappycodings.redwire.redwiredoors.common.util.LocationUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class BigSlidingDoorBlock extends BaseEntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    public RegistryObject<BlockEntityType<BigSlidingDoorEntity>> registryObject;

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
        BigSlidingDoorEntity blockEntity = (BigSlidingDoorEntity) level.getBlockEntity(pos);
        if (!state.getValue(REMOTED) && blockEntity.isOperable()) {
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
    public InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        ItemStack item = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        HashMap<Item, Integer> items = new HashMap<>();
        Block[] blocks = {Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE,
                Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES,
                Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.WHITE_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE,
                Blocks.BLACK_CONCRETE, Blocks.RED_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.BLUE_CONCRETE,
                Blocks.LIGHT_BLUE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.PURPLE_CONCRETE,
                Blocks.PINK_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS,
                Blocks.DARK_OAK_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.WARPED_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.ACACIA_PLANKS,
                Blocks.WHITE_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER,
                Blocks.RED_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER,
                Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER,
                Blocks.PURPLE_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER,
                Blocks.MUD, Blocks.CALCITE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE,
                Blocks.WHITE_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.BLACK_TERRACOTTA,
                Blocks.RED_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.BLUE_TERRACOTTA,
                Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.GREEN_TERRACOTTA,
                Blocks.PURPLE_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.BROWN_TERRACOTTA};
        for (int i = 0; i < blocks.length; i++) {
            items.put(blocks[i].asItem(), i);
        }
        if (pHand == InteractionHand.MAIN_HAND) {
            if (items.containsKey(item.getItem())) {
                BigSlidingDoorEntity blockEntity = (BigSlidingDoorEntity) pLevel.getBlockEntity(pPos);
                if (blockEntity.getStyle() != (byte) items.get(item.getItem()).intValue()) {
                    if (!pLevel.isClientSide) {
                        blockEntity.setStyle((byte) items.get(item.getItem()).intValue());
                        blockEntity.setChanged();
                        item.shrink(1);
                        if (item.getCount() > 0)
                            pPlayer.setItemInHand(InteractionHand.MAIN_HAND, item);
                    } else {
                        Block blockItem = ((BlockItem) item.getItem()).getBlock();
                        pLevel.playSound(pPlayer, pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5,
                                blockItem.getSoundType(blockItem.defaultBlockState()).getPlaceSound(), SoundSource.BLOCKS, 1f, 1f);
                        pPlayer.swing(InteractionHand.MAIN_HAND);
                    }
                    return InteractionResult.CONSUME;
                }
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public VoxelShape getShape(@NotNull BlockState bstate, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = bstate.getValue(FACING);
        if (!(level.getBlockEntity(pos) instanceof BigSlidingDoorEntity blockEntity)) return Shapes.empty();
        CompoundTag tagDoor = new CompoundTag();
        blockEntity.saveAdditional(tagDoor);
        CompoundTag tag = new CompoundTag();
        blockEntity.saveAdditional(tag);

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            byte state = tagDoor.getByte("state");
            if (blockEntity.isLast()) {
                if (state >= 20) {
                    if (state == 38)
                        return Shapes.or(Block.box(-16, 0, 7, -11.15, 32, 9), Block.box(27.15, 0, 7, 32, 32, 9));
                    return Shapes.or(Block.box(-16, 0, 7, 8 - ((state - 20) * 1.12), 32, 9), Block.box(8 + ((state - 20) * 1.12), 0, 7, 32, 32, 9));
                } else {
                    return Shapes.or(Block.box(-16, 0, 7, 8, 32, 9), Block.box(8, 0, 7, 32, 32, 9));
                }
            } else {
                if (state <= 18)
                    return Shapes.or(Block.box(-16, 0, 7, -11.15 + (state * 1.12), 32, 9), Block.box(27.15 - (state * 1.12), 0, 7, 32, 32, 9));
                else
                    return Shapes.or(Block.box(-16, 0, 7, 8, 32, 9), Block.box(8, 0, 7, 32, 32, 9));
            }
        }


        byte state = tagDoor.getByte("state");
        if (blockEntity.isLast()) {
            if (state >= 20) {
                if (state == 38)
                    return Shapes.or(Block.box(7, 0, 27.15, 9, 32, 32), Block.box(7, 0, -16, 9, 32, -11.15));
                return Shapes.or(Block.box(7, 0, 8 + ((state - 20) * 1.12), 9, 32, 32), Block.box(7, 0, -16, 9, 32, 8.0 - ((state - 20) * 1.12)));
            } else {
                return Shapes.or(Block.box(7, 0, 8, 9, 32, 32), Block.box(7, 0, -16, 9, 32, 8.0));
            }

        } else {
            if (state <= 18)
                return Shapes.or(Block.box(7, 0, 8 - ((state - 20) * 1.12), 9, 32, 32), Block.box(7, 0, -16, 9, 32, 8.0 + ((state - 20) * 1.12)));
            else
                return Shapes.or(Block.box(7, 0, 8, 9, 32, 32), Block.box(7, 0, -16, 9, 32, 8.0));
        }
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
        tooltipComponents.add(Component.literal("This animated door can be camouflaged.").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        tooltipComponents.add(Component.literal("Wireless Controllable: ").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW))
                .append(Component.literal("Yes").setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN))));
        tooltipComponents.add(Component.literal("Size: ").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW))
                .append(Component.literal("3x2x1 (WxHxD)").setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN))));
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
