package net.tutorialbykaupenjoe.livestreammod.block;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.tutorialbykaupenjoe.livestreammod.tile.KaupenFurnaceTileEntity;
import net.tutorialbykaupenjoe.livestreammod.tile.ModTileEntities;

import javax.annotation.Nullable;

public class KaupenFurnaceBlock extends AbstractFurnaceBlock {
    protected KaupenFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof KaupenFurnaceTileEntity) {
            player.openContainer((INamedContainerProvider)tileentity);
            player.addStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return ModTileEntities.KAUPENFURNACE_TILE.get().create();
    }
}
