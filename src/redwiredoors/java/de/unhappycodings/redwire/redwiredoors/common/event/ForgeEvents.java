package de.unhappycodings.redwire.redwiredoors.common.event;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix4f;
import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.block.BigSlidingDoorBlock;
import de.unhappycodings.redwire.redwiredoors.common.block.BoundingBlock;
import de.unhappycodings.redwire.redwiredoors.common.block.ModBlocks;
import de.unhappycodings.redwire.redwiredoors.common.blockentity.BoundingBlockEntity;
import de.unhappycodings.redwire.redwiredoors.common.util.ItemUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedwireDoors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    @SubscribeEvent
    public static void onSlidingDoorBreak(BlockEvent.BreakEvent event) {
        Block block = event.getLevel().getBlockState(event.getPos()).getBlock();
        if (block instanceof BoundingBlock || block instanceof BigSlidingDoorBlock) {
            LevelAccessor level = event.getLevel();
            BlockState blockState = level.getBlockState(event.getPos());
            Direction facing = blockState.getValue(BigSlidingDoorBlock.FACING);
            BlockPos blockOriginPos;
            if (block instanceof BoundingBlock) {
                BoundingBlockEntity blockEntity = (BoundingBlockEntity) event.getLevel().getBlockEntity(event.getPos());
                CompoundTag tag = new CompoundTag();
                blockEntity.saveAdditional(tag);
                blockOriginPos = new BlockPos(tag.getInt("origin-x"), tag.getInt("origin-y"), tag.getInt("origin-z"));
            } else {
                blockOriginPos = event.getPos();
            }
            BlockPos above;
            BlockPos left;
            BlockPos leftAbove;
            BlockPos right;
            BlockPos rightAbove;
            if (facing == Direction.NORTH || facing == Direction.SOUTH) {
                left = blockOriginPos.offset(-1, 0, 0);
                leftAbove = blockOriginPos.offset(-1, 1, 0);
                above = blockOriginPos.offset(0, 1, 0);
                rightAbove = blockOriginPos.offset(1, 1, 0);
                right = blockOriginPos.offset(1, 0, 0);
            } else {
                left = blockOriginPos.offset(0, 0, -1);
                leftAbove = blockOriginPos.offset(0, 1, -1);
                above = blockOriginPos.offset(0, 1, 0);
                rightAbove = blockOriginPos.offset(0, 1, 1);
                right = blockOriginPos.offset(0, 0, 1);
            }

            BlockPos[] posList = {left, leftAbove, above, rightAbove, right};
            level.destroyBlock(blockOriginPos, !event.getPlayer().isCreative());
            for (BlockPos pos : posList) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    @SubscribeEvent
    public static void onSlidingDoorPlaced(BlockEvent.EntityPlaceEvent event) {
        if (event.getPlacedBlock().getBlock() instanceof BigSlidingDoorBlock) {
            BlockPos blockPos = event.getPos();
            LevelAccessor level = event.getLevel();
            BlockState blockState = level.getBlockState(blockPos);
            Direction facing = blockState.getValue(BigSlidingDoorBlock.FACING);
            BlockPos above;
            BlockPos left;
            BlockPos leftAbove;
            BlockPos right;
            BlockPos rightAbove;

            if (facing == Direction.NORTH || facing == Direction.SOUTH) {
                left = blockPos.offset(-1, 0, 0);
                leftAbove = blockPos.offset(-1, 1, 0);
                above = blockPos.offset(0, 1, 0);
                rightAbove = blockPos.offset(1, 1, 0);
                right = blockPos.offset(1, 0, 0);

                if (facing == Direction.NORTH) {
                    setNbt(level, left, blockPos, facing, (byte) 5);
                    setNbt(level, leftAbove, blockPos, facing, (byte) 4);
                    setNbt(level, above, blockPos, facing, (byte) 3);
                    setNbt(level, rightAbove, blockPos, facing, (byte) 2);
                    setNbt(level, right, blockPos, facing, (byte) 1);
                } else {
                    setNbt(level, left, blockPos, facing, (byte) 1);
                    setNbt(level, leftAbove, blockPos, facing, (byte) 2);
                    setNbt(level, above, blockPos, facing, (byte) 3);
                    setNbt(level, rightAbove, blockPos, facing, (byte) 4);
                    setNbt(level, right, blockPos, facing, (byte) 5);
                }
            }
            if (facing == Direction.EAST || facing == Direction.WEST) {
                left = blockPos.offset(0, 0, -1);
                leftAbove = blockPos.offset(0, 1, -1);
                above = blockPos.offset(0, 1, 0);
                rightAbove = blockPos.offset(0, 1, 1);
                right = blockPos.offset(0, 0, 1);

                if (facing == Direction.EAST) {
                    setNbt(level, left, blockPos, facing, (byte) 5);
                    setNbt(level, leftAbove, blockPos, facing, (byte) 4);
                    setNbt(level, above, blockPos, facing, (byte) 3);
                    setNbt(level, rightAbove, blockPos, facing, (byte) 2);
                    setNbt(level, right, blockPos, facing, (byte) 1);
                } else {
                    setNbt(level, left, blockPos, facing, (byte) 1);
                    setNbt(level, leftAbove, blockPos, facing, (byte) 2);
                    setNbt(level, above, blockPos, facing, (byte) 3);
                    setNbt(level, rightAbove, blockPos, facing, (byte) 4);
                    setNbt(level, right, blockPos, facing, (byte) 5);
                }
            }
        }
    }

    public static void setNbt(LevelAccessor level, BlockPos blockPos, BlockPos originBlockPos, Direction facing, Byte pos) {
        level.setBlock(blockPos, ModBlocks.BOUNDING.get().defaultBlockState().setValue(BoundingBlock.FACING, facing), 3);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (!(blockEntity instanceof BoundingBlockEntity curBlockEntity)) return;
        CompoundTag tag = new CompoundTag();
        curBlockEntity.saveAdditional(tag);
        tag.putByte("state", (byte) 1);
        tag.putByte("pos", pos);
        tag.putInt("origin-x", originBlockPos.getX());
        tag.putInt("origin-y", originBlockPos.getY());
        tag.putInt("origin-z", originBlockPos.getZ());
        curBlockEntity.load(tag);
        curBlockEntity.setChanged();
    }

    @SubscribeEvent
    public static void onSlidingDoorPlace(final PlayerInteractEvent.RightClickBlock event) {
        if (ItemUtil.getRegName(event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getItem()).toString().contains("big_sliding_door")) {
            LevelAccessor level = event.getLevel();
            BlockPos pos;
            BlockState above;
            BlockState left;
            BlockState leftAbove;
            BlockState right;
            BlockState rightAbove;
            pos = switch (event.getFace()) {
                case UP -> event.getPos().above();
                case DOWN -> event.getPos().below();
                case NORTH -> event.getPos().north();
                case EAST -> event.getPos().east();
                case SOUTH -> event.getPos().south();
                default -> event.getPos().west();
            };
            if (event.getEntity().getDirection().getOpposite() == Direction.NORTH || event.getEntity().getDirection().getOpposite() == Direction.SOUTH) {
                above = level.getBlockState(pos.offset(0, 1, 0));
                left = level.getBlockState(pos.offset(-1, 0, 0));
                leftAbove = level.getBlockState(pos.offset(-1, 1, 0));
                right = level.getBlockState(pos.offset(1, 0, 0));
                rightAbove = level.getBlockState(pos.offset(1, 1, 0));
            } else {
                above = level.getBlockState(pos.offset(0, 1, 0));
                left = level.getBlockState(pos.offset(0, 0, -1));
                leftAbove = level.getBlockState(pos.offset(0, 1, -1));
                right = level.getBlockState(pos.offset(0, 0, 1));
                rightAbove = level.getBlockState(pos.offset(0, 1, 1));
            }

            if (!isPlacable(above, left, right, leftAbove, rightAbove)) {
                event.setCanceled(true);
            }
        }
    }

    public static boolean isPlacable(BlockState above, BlockState right, BlockState left, BlockState rightAbove, BlockState leftAbove) {
        return above.getBlock() == Blocks.AIR && left.getBlock() == Blocks.AIR && right.getBlock() == Blocks.AIR
                && leftAbove.getBlock() == Blocks.AIR && rightAbove.getBlock() == Blocks.AIR;
    }

}
