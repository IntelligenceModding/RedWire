package de.unhappycodings.redwire.redwirelampsandlighting.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class RedstoneLampBlock extends net.minecraft.world.level.block.RedstoneLampBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    public boolean powerable;
    public boolean inverted;

    public RedstoneLampBlock(boolean powerable, boolean inverted) {
        super(Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(poweredBlockEmission(inverted)));
        this.inverted = inverted;
        this.powerable = powerable;

        registerDefaultState(this.getStateDefinition().any()
                .setValue(LIT, false)
                .setValue(REMOTED, false));
    }

    private static ToIntFunction<BlockState> poweredBlockEmission(boolean inverted) {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState = this.defaultBlockState();
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


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, REMOTED);
    }

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
