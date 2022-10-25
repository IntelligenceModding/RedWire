package de.unhappycodings.redwire.redwirelampsandlighting.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class LampBlock extends RedstoneLampBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    public boolean inverted;

    public LampBlock() {
        super(Properties.copy(Blocks.REDSTONE_LAMP));
        this.inverted = false;

        registerDefaultState(this.getStateDefinition().any()
                .setValue(LIT, false)
                .setValue(REMOTED, false));
    }

    public LampBlock(String x) {
        super(Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(litBlockEmission(true)));
        this.inverted = true;

        registerDefaultState(this.getStateDefinition().any()
                .setValue(LIT, false)
                .setValue(REMOTED, false));
    }

    private static ToIntFunction<BlockState> litBlockEmission(boolean inverted) {
        if (inverted)
            return (p_50763_) -> !p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? 15 : 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, REMOTED);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!state.getValue(REMOTED)) {
            super.neighborChanged(state, level, pos, block, fromPos, isMoving);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {
        tooltipComponents.add(Component.literal("Wireless Controllable: ").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW))
                .append(Component.literal("Yes").setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN))));
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }

}
