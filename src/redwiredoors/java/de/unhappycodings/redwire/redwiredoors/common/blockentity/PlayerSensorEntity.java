package de.unhappycodings.redwire.redwiredoors.common.blockentity;

import de.unhappycodings.redwire.redwiredoors.common.block.PlayerSensorBlock;
import de.unhappycodings.redwire.redwiredoors.common.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlayerSensorEntity extends BlockEntity {
    boolean state;
    int ticks;

    public PlayerSensorEntity(BlockPos pos, BlockState state, RegistryObject<BlockEntityType<PlayerSensorEntity>> registryObject) {
        super(registryObject.get(), pos, state);
    }

    public void tick() {
        Direction direction = getBlockState().getValue(PlayerSensorBlock.FACING);
        BlockPos pos1 = getBlockPos().offset(1, 0, -1);
        BlockPos pos2 = getBlockPos().offset(-1, -2, 2);
        switch (direction) {
            case NORTH -> {
                pos1 = getBlockPos().offset(-1, 0, 1);
                pos2 = getBlockPos().offset(2, -2, -1);
            }
            case EAST -> {
                pos1 = getBlockPos().offset(2, 0, 2);
                pos2 = getBlockPos().offset(0, -2, -1);
            }
            case SOUTH -> {
                pos1 = getBlockPos().offset(2, 0, 2);
                pos2 = getBlockPos().offset(-1, -2, 0);
            }
            default -> {
            }
        }
        List<Player> players = level.getEntitiesOfClass(Player.class, new AABB(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ()), entity -> !entity.isSpectator() && !entity.isShiftKeyDown());

        LocalPlayer player = Minecraft.getInstance().player;
        if (!players.isEmpty()) {
            if (!state) {
                ticks = 0;
                state = true;
                if (player != null)
                    player.getLevel().playLocalSound(this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5,
                            ModSounds.PLAYER_SENSOR_CLICK_OFF.get(), SoundSource.BLOCKS, 0.4f, 1f, false);
                level.setBlock(getBlockPos(), getBlockState().setValue(PlayerSensorBlock.POWERED, true), 3);
            }
        } else {
            if (ticks > 3 * 20) {
                if (state) {
                    ticks = 0;
                    state = false;
                    if (player != null)
                        player.getLevel().playLocalSound(getBlockPos().getX() + 0.5, getBlockPos().getY() + 0.5, getBlockPos().getZ() + 0.5,
                                ModSounds.PLAYER_SENSOR_CLICK_ON.get(), SoundSource.BLOCKS, 0.4f, 1f, false);
                    level.setBlock(getBlockPos(), getBlockState().setValue(PlayerSensorBlock.POWERED, false), 3);
                }
            }
        }
        ticks++;
    }
}
