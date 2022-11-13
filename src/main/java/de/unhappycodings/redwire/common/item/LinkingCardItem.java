package de.unhappycodings.redwire.common.item;

import de.unhappycodings.redwire.RedwireCore;
import de.unhappycodings.redwire.common.block.WirelessControllerBlock;
import de.unhappycodings.redwire.common.blockentity.WirelessControllerEntity;
import de.unhappycodings.redwire.common.config.CommonConfig;
import de.unhappycodings.redwire.common.registration.Registration;
import de.unhappycodings.redwire.common.util.ItemUtil;
import de.unhappycodings.redwire.common.util.NbtUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class LinkingCardItem extends Item {
    public LinkingCardItem() {
        super(new Properties().stacksTo(1).tab(RedwireCore.creativeTab));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
        int size = stack.getOrCreateTag().getList("positions", Tag.TAG_COMPOUND).size();
        tooltipComponents.add(Component.literal(size + "/" + CommonConfig.LINKING_TOOL_MAX_BOUNDS.get().toString() + " ")
                .append(Component.literal("connections saved")).setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("Usable on RedWire blocks!").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        tooltipComponents.add(Component.literal("Sneak to copy from Wireless Controller").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        if (CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.get()) tooltipComponents.add(rgbComp());
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

    private Component rgbComp() {
        return Component.literal("R").withStyle(Style.EMPTY.withColor(0xFF0000))
                .append(Component.literal("a").withStyle(Style.EMPTY.withColor(0xFF7700)))
                .append(Component.literal("i").withStyle(Style.EMPTY.withColor(0xFFEE00)))
                .append(Component.literal("n").withStyle(Style.EMPTY.withColor(0x99FF00)))
                .append(Component.literal("b").withStyle(Style.EMPTY.withColor(0x26FF00)))
                .append(Component.literal("o").withStyle(Style.EMPTY.withColor(0x00FF51)))
                .append(Component.literal("w").withStyle(Style.EMPTY.withColor(0x00FFC8)))
                .append(Component.literal(" "))
                .append(Component.literal("m").withStyle(Style.EMPTY.withColor(0x00C3FF)))
                .append(Component.literal("o").withStyle(Style.EMPTY.withColor(0x004CFF)))
                .append(Component.literal("d").withStyle(Style.EMPTY.withColor(0x004CFF)))
                .append(Component.literal("e").withStyle(Style.EMPTY.withColor(0x9D00FF)))
                .append(Component.literal("!").withStyle(Style.EMPTY.withColor(0xFF00EA)));
    }

    @NotNull
    @Override
    public InteractionResult useOn(@NotNull UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack item = context.getItemInHand();
        BlockPos pos = context.getClickedPos();

        TagKey<Block> lampControllables = TagKey.create(Registration.BLOCKS.getRegistryKey(), new ResourceLocation("redwirelampsandlighting:lamps/controllable"));
        TagKey<Block> doorControllables = TagKey.create(Registration.BLOCKS.getRegistryKey(), new ResourceLocation("redwiredoors:doors/controllable"));

        System.out.println(level.getBlockState(pos).is(doorControllables));
        if (level.getBlockState(pos).is(lampControllables) || level.getBlockState(pos).is(doorControllables)) {
            ListTag nbtList = new ListTag();
            if (item.getOrCreateTag().contains("positions"))
                nbtList = item.getOrCreateTag().getList("positions", Tag.TAG_COMPOUND);
            if (NbtUtil.posExistsInList(nbtList, pos)) {
                NbtUtil.removePosFromList(nbtList, pos);
                player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1, 1.5f);
            } else {
                if (nbtList.size() >= CommonConfig.LINKING_TOOL_MAX_BOUNDS.get()) {
                    player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1, 0.5f);
                    int x = CommonConfig.LINKING_TOOL_MAX_BOUNDS.get();
                    if (!level.isClientSide)
                        player.sendSystemMessage(Component.literal("Linking card is full!").append(" (" + x + "/" + x + ")"));
                    return InteractionResult.SUCCESS;
                }
                CompoundTag posTag = new CompoundTag();
                NbtUtil.writePos(posTag, pos);
                nbtList.add(posTag);
                player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1, 4f);
            }

            item.getOrCreateTag().put("positions", nbtList);
            player.setItemSlot(EquipmentSlot.MAINHAND, item);
            return InteractionResult.SUCCESS;
        } else if (level.getBlockState(pos).getBlock() instanceof WirelessControllerBlock) {
            if (level.isClientSide()) return InteractionResult.SUCCESS;
            if (player.isShiftKeyDown()) {
                BlockEntity block = level.getBlockEntity(pos);
                if (!(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof LinkingCardItem))
                    return InteractionResult.SUCCESS;
                if (!(block instanceof WirelessControllerEntity blockEntity)) return InteractionResult.SUCCESS;
                ListTag tag = blockEntity.getPositions();
                if (tag != null) {
                    ListTag nbtList = new ListTag();
                    tag.forEach((x) -> {
                        CompoundTag posTag = new CompoundTag();
                        NbtUtil.writePos(posTag, NbtUtil.getPos((CompoundTag) x));
                        nbtList.add(posTag);
                    });
                    item.getOrCreateTag().put("positions", nbtList);
                    player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1, 4f);
                    return InteractionResult.SUCCESS;
                } else {
                    player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1, 1.5f);
                    return InteractionResult.SUCCESS;
                }
            }
        } else {
            if (level.isClientSide && player.isShiftKeyDown()) {
                CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.set(!CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.get());
                player.swing(InteractionHand.MAIN_HAND);
                player.playNotifySound(SoundEvents.COMPARATOR_CLICK, SoundSource.BLOCKS, 1, CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.get() ? 0.55F : 0.50F);
            }
        }

        return InteractionResult.FAIL;
    }

    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (interactionHand == InteractionHand.MAIN_HAND && level.isClientSide && player.isShiftKeyDown()) {
            CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.set(!CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.get());
            player.swing(InteractionHand.MAIN_HAND);
            player.playNotifySound(SoundEvents.COMPARATOR_CLICK, SoundSource.BLOCKS, 1, CommonConfig.LINKING_TOOL_OVERLAY_RAINBOW.get() ? 0.55F : 0.50F);
        }
        return super.use(level, player, interactionHand);
    }

    @NotNull
    public Component getDescription() {
        String descriptionId = getDescriptionId();
        int lastIndex = descriptionId.lastIndexOf('.');
        return Component.translatable(String.format(
                "%s.tooltip.%s",
                descriptionId.substring(0, lastIndex).replaceFirst("^block", "item"),
                descriptionId.substring(lastIndex + 1))).withStyle(ChatFormatting.DARK_GRAY);
    }

}
