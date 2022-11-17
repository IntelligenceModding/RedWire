package de.unhappycodings.redwire.redwirealloys.common.block;

import de.unhappycodings.redwire.redwirealloys.common.blockentity.WireBlockEntity;
import de.unhappycodings.redwire.redwirealloys.common.item.WireBlockItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class WireBlock extends BaseEntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    protected static final VoxelShape SHAPE_DOWN = Block.box(0, 0, 0, 16, 2, 16);
    protected static final VoxelShape SHAPE_UP = Block.box(0, 14, 0, 16, 16, 16);
    protected static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 0, 16, 16, 2);
    protected static final VoxelShape SHAPE_EAST = Block.box(14, 0, 0, 16, 16, 16);
    protected static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 14, 16, 16, 16);
    protected static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 2, 16, 16);

    public RegistryObject<BlockEntityType<WireBlockEntity>> registryObject;

    public WireBlock(RegistryObject<BlockEntityType<WireBlockEntity>> registryObject) {
        super(Properties.of(Material.STONE).noOcclusion().noCollission());
        this.registryObject = registryObject;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(POWERED, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    @NotNull
    public VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        if (pLevel.getBlockEntity(pPos) instanceof WireBlockEntity entity && Minecraft.getInstance().level != null && Minecraft.getInstance().hitResult != null) {
            ArrayList<String> sides = WireBlockItem.getSides(entity.getSides());
            double range = Minecraft.getInstance().player.getAttributeValue(ForgeMod.REACH_DISTANCE.get());
            Vec3 origin = Minecraft.getInstance().player.getEyePosition();
            Vec3 look = Minecraft.getInstance().player.getLookAngle();
            Vec3 target = new Vec3(origin.x + look.x * range, origin.y + look.y * range, origin.z + look.z * range);
            // Check for players focused direction
            BlockHitResult result = pLevel.clip(new ClipContext(origin, target, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null) {
                @NotNull
                @Override
                public VoxelShape getBlockShape(@NotNull BlockState pBlockState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
                    return pBlockState.is(ModBlocks.RED_ALLOY_WIRE.get()) ? Shapes.empty() : super.getBlockShape(pBlockState, pLevel, pPos);
                }
            });
            // Get focused direction and render specific side
            Direction direction = result.getDirection().getOpposite();
            if (sides.contains(direction.getName())) {
                return switch (direction) {
                    case UP -> SHAPE_UP;
                    case DOWN -> SHAPE_DOWN;
                    case NORTH -> SHAPE_NORTH;
                    case EAST -> SHAPE_EAST;
                    case SOUTH -> SHAPE_SOUTH;
                    case WEST -> SHAPE_WEST;
                };
            }
        }
        return Shapes.empty();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean moving) {

        System.out.println(pos); // Wire Block
        System.out.println(fromPos); // Geänderter / Platzierter Block

        BlockState wireBlockState = level.getBlockState(pos);
        BlockState placedBlockState = level.getBlockState(fromPos);

        if (!wireBlockState.getValue(POWERED)) {



            System.out.println(placedBlockState.isSignalSource());
            System.out.println(placedBlockState);
            if (level.hasSignal(fromPos, Direction.DOWN)) {
                level.setBlock(pos, wireBlockState.setValue(POWERED, true), 3);
            }
        }


        super.neighborChanged(state, level, pos, block, fromPos, moving);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getSignal(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull Direction pDirection) {
        return pState.getValue(POWERED) ? 15 : 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(POWERED);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        double range = Minecraft.getInstance().player.getAttributeValue(ForgeMod.REACH_DISTANCE.get());
        Vec3 origin = Minecraft.getInstance().player.getEyePosition();
        Vec3 look = Minecraft.getInstance().player.getLookAngle();
        Vec3 target = new Vec3(origin.x + look.x * range, origin.y + look.y * range, origin.z + look.z * range);
        // Check for players focused direction
        BlockHitResult result = level.clip(new ClipContext(origin, target, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null) {
            @NotNull
            @Override
            public VoxelShape getBlockShape(@NotNull BlockState pBlockState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
                return pBlockState.is(ModBlocks.RED_ALLOY_WIRE.get()) ? Shapes.empty() : super.getBlockShape(pBlockState, pLevel, pPos);
            }
        });
        // Get focused direction and render specific side
        Direction direction = result.getDirection().getOpposite();
        WireBlockEntity entity = (WireBlockEntity) level.getBlockEntity(pos);
        String side = direction.getName();
        byte sides = entity.getSides();
        if (WireBlockItem.getSides(sides).contains(side)) {
            if ((sides - WireBlockItem.getSideValue(side)) > 0) {
                entity.setSides((byte) (sides - WireBlockItem.getSideValue(side)));
                entity.setChanged();
                level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), Block.UPDATE_ALL);
            } else {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            }
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            if (!player.isCreative())
                level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, new ItemStack(ModBlocks.RED_ALLOY_WIRE.get().asItem(), 1)));
        }

        return false;
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return registryObject.get().create(pos, state);
    }
}
