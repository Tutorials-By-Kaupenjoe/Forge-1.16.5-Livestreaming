package net.tutorialbykaupenjoe.livestreammod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;

import javax.annotation.Nullable;

// For different textures on different Sides of a Block
// I suggest using the DirectionalBlock Class and extending it, pretty much like this!
// Both of these methods are mandatory! And then the placement should work
// The JSON files are examples of how those should look like.
public class HerobrinesFurnaceBlock extends DirectionalBlock {
    protected HerobrinesFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
