package net.tutorialbykaupenjoe.livestreammod.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;
import net.tutorialbykaupenjoe.livestreammod.item.crafting.ModRecipeSerializers;

public class KaupenFurnaceContainer extends AbstractKaupenFurnaceContainer {
    public KaupenFurnaceContainer(int id, PlayerInventory playerInventoryIn) {
        super(ModContainers.KAUPEN_FURNACE_CONTAINER.get(), ModRecipeSerializers.KAUPEN_RECIPE,
                RecipeBookCategory.FURNACE, id, playerInventoryIn);
    }

    public KaupenFurnaceContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn,
                                  IIntArray furnaceData) {
        super(ModContainers.KAUPEN_FURNACE_CONTAINER.get(), ModRecipeSerializers.KAUPEN_RECIPE,
                RecipeBookCategory.FURNACE, id,
                playerInventoryIn, furnaceInventoryIn, furnaceData);
    }
}
