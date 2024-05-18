package com.arrl.radiocraft.common.blocks;

import com.arrl.radiocraft.common.blockentities.radio.VHFReceiverBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class VHFReceiverBlock extends RadioBlock {

	public static final HashMap<Direction, VoxelShape> SHAPES = new HashMap<>();

	static {
		SHAPES.put(Direction.NORTH, Block.box(4.0D, 0.0D, 3.0D, 12.0D, 3.0D, 16.0D));
		SHAPES.put(Direction.SOUTH, Block.box(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 13.0D));
		SHAPES.put(Direction.WEST, Block.box(3.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D));
		SHAPES.put(Direction.EAST, Block.box(0.0D, 0.0D, 4.0D, 13.0D, 3.0D, 12.0D));
	}

	public VHFReceiverBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPES.get(state.getValue(RadioBlock.HORIZONTAL_FACING));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(RadioBlock.HORIZONTAL_FACING);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new VHFReceiverBlockEntity(pos, state);
	}

}
