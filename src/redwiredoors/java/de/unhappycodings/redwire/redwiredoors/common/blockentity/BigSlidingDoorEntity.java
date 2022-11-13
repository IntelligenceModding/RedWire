package de.unhappycodings.redwire.redwiredoors.common.blockentity;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.sound.ModSounds;
import de.unhappycodings.redwire.redwiredoors.common.util.ItemUtil;
import de.unhappycodings.redwire.redwiredoors.common.util.LocationUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.HashMap;
import java.util.Objects;

public class BigSlidingDoorEntity extends BlockEntity implements IAnimatable, AnimationController.ISoundListener<BigSlidingDoorEntity> {
    private final AnimationFactory factory = new AnimationFactory(this);
    boolean lasts;
    boolean last;
    byte state = 1;
    int ticks;
    byte style;
    boolean operable = true;
    ResourceLocation texture;

    public BigSlidingDoorEntity(BlockPos pos, BlockState state, ResourceLocation texture, RegistryObject<BlockEntityType<BigSlidingDoorEntity>> registryObject) {
        super(registryObject.get(), pos, state);
        this.texture = texture;
    }

    public void tick() {
        Level level = getLevel();
        BlockPos blockPos = getBlockPos();
        BlockState blockState = level.getBlockState(blockPos);
        CompoundTag tag = new CompoundTag();
        boolean xState = LocationUtil.getBigSlidingDoorRedstoneState(level, blockPos);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        this.saveAdditional(tag);
        if (((BigSlidingDoorEntity) blockEntity).isOperable()) {
            if (blockState.getBlock() != Blocks.AIR) {
                if (xState) {
                    if (!this.lasts) {
                        tag.putBoolean("last", true);
                        ticks = 0;
                        this.lasts = true;
                        this.load(tag);
                    }
                } else {
                    if (this.lasts) {
                        tag.putBoolean("last", false);
                        ticks = 0;
                        this.lasts = false;
                        this.load(tag);
                    }
                }
            }
        }

        if (ticks == 0) {
            tag.putBoolean("operable", false);
        } else if (ticks == 38) {
            tag.putBoolean("operable", true);
        }
        if (ticks >= 0 && ticks <= 38) {
            tag.putByte("state", (byte) ticks);
            this.load(tag);
        }
        level.sendBlockUpdated(blockPos, blockState, blockState, Block.UPDATE_ALL);
        this.setChanged();
        ticks++;
    }

    @Override
    public AABB getRenderBoundingBox() {
        return new AABB(getBlockPos().offset(-2, -2, -2), getBlockPos().offset(3, 3, 3)); //Relative to BlockOrigin | So 2- and 3+
    }

    public ResourceLocation getTexture() {
        HashMap<Item, String> items = new HashMap<>();
        Block[] blocks = {Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE, Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.WHITE_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.BLACK_CONCRETE, Blocks.RED_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.PINK_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.WARPED_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.ACACIA_PLANKS, Blocks.WHITE_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.MUD, Blocks.CALCITE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, Blocks.WHITE_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.BROWN_TERRACOTTA};
        for (Block block : blocks) {
            items.put(block.asItem(), ItemUtil.getRegString(block).replace("minecraft:", "textures/geo/textures/") + "_big_sliding_door.png");
        }
        return new ResourceLocation(RedwireDoors.MOD_ID, items.get(blocks[style].asItem()));
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setStyle(byte style) {
        this.style = style;
    }

    public byte getStyle() {
        return style;
    }

    public void setOperable(boolean operable) {
        this.operable = operable;
    }

    public boolean isOperable() {
        return operable;
    }

    private <ENTITY extends IAnimatable> void soundListener(SoundKeyframeEvent<ENTITY> event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            if (Objects.equals(event.sound, "open"))
                player.getLevel().playLocalSound(this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5, ModSounds.BIG_SLIDING_DOOR_OPEN.get(), SoundSource.BLOCKS, 1f, 1f, false);
            if (Objects.equals(event.sound, "close"))
                player.getLevel().playLocalSound(this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5, ModSounds.BIG_SLIDING_DOOR_CLOSE.get(), SoundSource.BLOCKS, 1f, 1f, false);
        }
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<E> controller = event.getController();
        Level level = getLevel();
        BlockPos blockPos = getBlockPos();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.getBlock() != Blocks.AIR) {
            boolean xState = LocationUtil.getBigSlidingDoorRedstoneState(level, blockPos);
            BlockEntity blockEntity = level.getBlockEntity(blockPos);

            event.getController().transitionLengthTicks = 0;
            if (((BigSlidingDoorEntity) blockEntity).isOperable()) {
                if (xState) {
                    if (!this.lasts) {
                        controller.setAnimation(new AnimationBuilder().addAnimation("animation.big_sliding_door.anim_open", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
                        this.lasts = true;
                    } else {
                        if (event.getController().getAnimationState() == AnimationState.Stopped) {
                            controller.setAnimation(new AnimationBuilder().addAnimation("animation.big_sliding_door.idle_open", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
                        }
                    }
                } else {
                    if (this.lasts) {
                        controller.setAnimation(new AnimationBuilder().addAnimation("animation.big_sliding_door.anim_close", ILoopType.EDefaultLoopTypes.HOLD_ON_LAST_FRAME));
                        this.lasts = false;
                    } else {
                        if (event.getController().getAnimationState() == AnimationState.Stopped) {
                            controller.setAnimation(new AnimationBuilder().addAnimation("animation.big_sliding_door.idle_close", ILoopType.EDefaultLoopTypes.HOLD_ON_LAST_FRAME));
                        }
                    }
                }
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        if (level.isClientSide && net.getDirection() == PacketFlow.CLIENTBOUND) {
            handleUpdateTag(pkt.getTag());
        }
    }

    @NotNull
    @Override
    public CompoundTag getUpdateTag() {
        super.getUpdateTag();
        CompoundTag nbt = new CompoundTag();
        nbt.putBoolean("last", this.last);
        nbt.putByte("state", this.state);
        nbt.putByte("style", this.style);
        nbt.putBoolean("operable", this.operable);
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundTag nbt) {
        this.last = nbt.getBoolean("last");
        this.state = nbt.getByte("state");
        this.style = nbt.getByte("style");
        this.operable = nbt.getBoolean("operable");
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putBoolean("last", this.last);
        nbt.putByte("state", this.state);
        nbt.putByte("style", this.style);
        nbt.putBoolean("operable", this.operable);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        this.last = nbt.getBoolean("last");
        this.state = nbt.getByte("state");
        this.style = nbt.getByte("style");
        this.operable = nbt.getBoolean("operable");
    }

    @Override
    public void registerControllers(AnimationData data) {
        AnimationController<BigSlidingDoorEntity> controller = new AnimationController<BigSlidingDoorEntity>(this, "animation.big_sliding_door.idle_closed", 9, this::predicate);
        data.addAnimationController(controller);
        controller.registerSoundListener(this::soundListener);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void playSound(SoundKeyframeEvent<BigSlidingDoorEntity> event) {

    }
}
