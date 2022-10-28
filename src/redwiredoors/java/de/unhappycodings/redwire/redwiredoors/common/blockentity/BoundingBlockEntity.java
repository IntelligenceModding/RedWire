package de.unhappycodings.redwire.redwiredoors.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Nameable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BoundingBlockEntity extends BlockEntity implements Nameable {
    byte pos;
    int x;
    int y;
    int z;

    public BoundingBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BOUNDING_BLOCK.get(), pos, state);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.load(tag);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putByte("pos", this.pos);
        nbt.putInt("origin-x", this.x);
        nbt.putInt("origin-y", this.y);
        nbt.putInt("origin-z", this.z);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        this.pos = nbt.getByte("pos");
        this.x = nbt.getInt("origin-x");
        this.y = nbt.getInt("origin-y");
        this.z = nbt.getInt("origin-z");
    }

    @NotNull
    @Override
    public Component getName() {
        return Component.translatable("block.redwiredoors.big_sliding_door");
    }

    @Nullable
    @Override
    public Component getCustomName() {
        return Component.translatable("block.redwiredoors.big_sliding_door");
    }

    @Override
    public boolean hasCustomName() {
        return true;
    }
}
