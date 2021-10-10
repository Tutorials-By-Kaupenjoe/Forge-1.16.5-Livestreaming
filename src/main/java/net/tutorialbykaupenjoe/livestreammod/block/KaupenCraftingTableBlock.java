package net.tutorialbykaupenjoe.livestreammod.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tutorialbykaupenjoe.livestreammod.container.KaupenWorkbenchContainer;

public class KaupenCraftingTableBlock extends CraftingTableBlock {
    private static final ITextComponent CONTAINER_NAME =
            new TranslationTextComponent("livestreammod.container.crafting");

    public KaupenCraftingTableBlock(Properties properties) {
        super(properties);
    }


    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, player) -> {
            return new KaupenWorkbenchContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
        }, CONTAINER_NAME);
    }
}
