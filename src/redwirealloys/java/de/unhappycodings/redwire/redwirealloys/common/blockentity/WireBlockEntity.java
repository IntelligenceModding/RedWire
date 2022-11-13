package de.unhappycodings.redwire.redwirealloys.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WireBlockEntity extends BlockEntity {
    private byte sides;

    public WireBlockEntity(BlockPos pos, BlockState state, RegistryObject<BlockEntityType<WireBlockEntity>> registryObject) {
        super(registryObject.get(), pos, state);
    }

    public byte getSides() {
        return sides;
    }

    public void setSides(byte sides) {
        this.sides = sides;
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putByte("sides", this.sides);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        this.sides = nbt.getByte("sides");
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        if (level.isClientSide && net.getDirection() == PacketFlow.CLIENTBOUND) {
            handleUpdateTag(pkt.getTag());
        }
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        this.sides = tag.getByte("sides");
    }

    @NotNull
    @Override
    public CompoundTag getUpdateTag() {
        super.getUpdateTag();
        CompoundTag nbt = new CompoundTag();
        nbt.putByte("sides", this.sides);
        return nbt;
    }
    
    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
