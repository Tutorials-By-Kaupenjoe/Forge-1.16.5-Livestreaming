package net.tutorialbykaupenjoe.livestreammod.tile;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tutorialbykaupenjoe.livestreammod.container.KaupenFurnaceContainer;
import net.tutorialbykaupenjoe.livestreammod.item.crafting.ModRecipeSerializers;

public class KaupenFurnaceTileEntity extends AbstractFurnaceTileEntity {
    public KaupenFurnaceTileEntity() {
        this(ModTileEntities.KAUPENFURNACE_TILE.get(), ModRecipeSerializers.KAUPEN_RECIPE);
    }

    protected KaupenFurnaceTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
        super(tileTypeIn, recipeTypeIn);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("tile.livestreammod.kaupenfurnace");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new KaupenFurnaceContainer(id, player, this, this.furnaceData);
    }
}
