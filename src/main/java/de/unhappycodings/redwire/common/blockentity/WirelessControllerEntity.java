package de.unhappycodings.redwire.common.blockentity;

import de.unhappycodings.redwire.common.registration.Registration;
import de.unhappycodings.redwire.common.util.NbtUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public class WirelessControllerEntity extends BlockEntity {
    public static final BooleanProperty REMOTED = BooleanProperty.create("remoted");
    ListTag positions;
    boolean powered;
    boolean origin;

    public WirelessControllerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WIRELESS_CONTROLLER.get(), pos, state);
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putBoolean("powered", this.powered);
        if (this.positions != null)
            nbt.put("positions", this.positions);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        this.powered = nbt.getBoolean("powered");
        if (!nbt.getList("positions", Tag.TAG_COMPOUND).isEmpty())
            this.positions = nbt.getList("positions", Tag.TAG_COMPOUND);

    }

    public ListTag getPositions() {
        return this.positions;
    }

    public void setPositions(ListTag positions) {
        this.positions = positions;
    }

    public void tick() {
        BlockState state = this.getBlockState();
        Level level = this.getLevel();
        BlockPos pos = this.getBlockPos();
        if (level.hasNeighborSignal(pos)) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (!(blockEntity instanceof WirelessControllerEntity curBlockEntity)) return;
            CompoundTag tag = new CompoundTag();
            curBlockEntity.saveAdditional(tag);

            if (!tag.getBoolean("powered")) {
                tag.putBoolean("powered", !tag.getBoolean("powered"));
                blockEntity.load(tag);
                blockEntity.setChanged();
                if (!tag.isEmpty()) {
                    TagKey<Block> controllables = TagKey.create(Registration.BLOCKS.getRegistryKey(), new ResourceLocation("redwirelampsandlighting:lamps/controllable"));
                    ListTag list = tag.getList("positions", Tag.TAG_COMPOUND);
                    list.forEach((x) -> {
                        BlockPos blockPos = NbtUtil.getPos((CompoundTag) x);
                        BlockState blockState = level.getBlockState(blockPos);
                        if (blockState.is(controllables)) {
                            if (blockState.getValue(BlockStateProperties.LIT)) {
                                blockState = blockState.setValue(BlockStateProperties.LIT, false);
                            } else {
                                blockState = blockState.setValue(BlockStateProperties.LIT, true);
                            }
                            this.origin = true;
                            level.setBlockAndUpdate(blockPos, blockState.setValue(REMOTED, true));

                        }
                    });
                }
            }
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (!(blockEntity instanceof WirelessControllerEntity curBlockEntity)) return;
            CompoundTag tag = new CompoundTag();
            curBlockEntity.saveAdditional(tag);

            if (tag.getBoolean("powered")) {
                tag.putBoolean("powered", !tag.getBoolean("powered"));
                blockEntity.load(tag);
                blockEntity.setChanged();
                if (!tag.isEmpty()) {
                    ListTag list = tag.getList("positions", Tag.TAG_COMPOUND);
                    list.forEach((x) -> {
                        TagKey<Block> controllables = TagKey.create(Registration.BLOCKS.getRegistryKey(), new ResourceLocation("redwirelampsandlighting:lamps/controllable"));
                        BlockPos blockPos = NbtUtil.getPos((CompoundTag) x);
                        BlockState blockState = level.getBlockState(blockPos);
                        if (blockState.is(controllables)) {
                            if (blockState.getValue(BlockStateProperties.LIT)) {
                                blockState = blockState.setValue(BlockStateProperties.LIT, false);
                            } else {
                                blockState = blockState.setValue(BlockStateProperties.LIT, true);
                            }
                            level.setBlockAndUpdate(blockPos, blockState.setValue(REMOTED, false));
                        }
                    });
                }
            }
        }
    }
}
