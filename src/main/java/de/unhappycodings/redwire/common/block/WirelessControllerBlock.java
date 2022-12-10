package de.unhappycodings.redwire.common.block;

import de.unhappycodings.redwire.common.blockentity.ModBlockEntities;
import de.unhappycodings.redwire.common.blockentity.WirelessControllerEntity;
import de.unhappycodings.redwire.common.item.LinkingCardItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WirelessControllerBlock extends BaseEntityBlock {

    protected WirelessControllerBlock() {
        super(Properties.copy(Blocks.STONE));
        registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.POWERED, false));

    }

    private static void spawnParticles(Level p_55455_, BlockPos p_55456_) {
        RandomSource randomsource = p_55455_.random;
        for (Direction direction : Direction.values()) {
            BlockPos blockpos = p_55456_.relative(direction);
            if (!p_55455_.getBlockState(blockpos).isSolidRender(p_55455_, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getStepX() : (double) randomsource.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getStepY() : (double) randomsource.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getStepZ() : (double) randomsource.nextFloat();
                p_55455_.addParticle(DustParticleOptions.REDSTONE, (double) p_55456_.getX() + d1, (double) p_55456_.getY() + d2, (double) p_55456_.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }

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
    public InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        BlockEntity block = level.getBlockEntity(pos);
        if (!(block instanceof WirelessControllerEntity blockEntity)) return InteractionResult.SUCCESS;
        if (!(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof LinkingCardItem))
            return InteractionResult.PASS;
        if (level.isClientSide()) return InteractionResult.SUCCESS;
        CompoundTag nbtItem = player.getItemInHand(InteractionHand.MAIN_HAND).getTag();
        if (nbtItem == null) return InteractionResult.SUCCESS;
        CompoundTag tag = new CompoundTag();
        blockEntity.saveAdditional(tag);

        if (level.hasNeighborSignal(block.getBlockPos())) {
            player.sendSystemMessage(Component.literal("Cannot modify data while the wireless controller is on!").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
            player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1f, 0.5f);
            return InteractionResult.SUCCESS;
        }
        if (tag.getList("positions", Tag.TAG_COMPOUND).isEmpty()) {
            if (nbtItem.isEmpty()) return InteractionResult.SUCCESS;
            blockEntity.load(nbtItem);
            player.sendSystemMessage(Component.literal("Connections have been transfered to the wireless controller!").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
            player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1f, 4.0f);
            blockEntity.setChanged();
        } else {
            blockEntity.setPositions(null);
            player.sendSystemMessage(Component.literal("Saved connections have been cleared!").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
            player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1f, 1.5f);
            blockEntity.setChanged();
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {
        tooltipComponents.add(Component.literal("Used to control RedWire lamps, doors, sirens etc").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("Add connections by using a linking card.").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (blockState.getValue(BlockStateProperties.POWERED))
            spawnParticles(level, blockPos);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : ($0, $1, $2, blockEntity) -> ((WirelessControllerEntity) blockEntity).tick();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ModBlockEntities.WIRELESS_CONTROLLER.get().create(pos, state);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos blockPos, Block block, BlockPos pos, boolean p_60514_) {
        level.setBlock(blockPos, state.setValue(BlockStateProperties.POWERED, level.hasNeighborSignal(blockPos)), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.POWERED);
    }

}
