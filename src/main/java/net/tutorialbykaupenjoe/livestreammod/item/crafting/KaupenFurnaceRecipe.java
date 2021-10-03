package net.tutorialbykaupenjoe.livestreammod.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.tutorialbykaupenjoe.livestreammod.block.ModBlocks;


public class KaupenFurnaceRecipe extends AbstractCookingRecipe {
    public KaupenFurnaceRecipe(ResourceLocation id, String group, Ingredient ingredient,
                               ItemStack result, float experience, int cookTime) {
        super(ModRecipeSerializers.KAUPEN_RECIPE, id, group, ingredient, result, experience, cookTime);
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.KAUPEN_FURNACE.get());
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.KAUPEN_SMELTING.get();
    }
}
