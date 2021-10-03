package net.tutorialbykaupenjoe.livestreammod.screen;

import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.container.KaupenFurnaceContainer;

public class KaupenFurnaceScreen extends AbstractKaupenFurnaceScreen<KaupenFurnaceContainer> {
    private static final ResourceLocation KAUPENFURNACE_GUI_TEXTURES
            = new ResourceLocation(LivestreamMod.MOD_ID, "textures/gui/container/kaupenfurnace.png");

    public KaupenFurnaceScreen(KaupenFurnaceContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, new FurnaceRecipeGui(), playerInventory, title, KAUPENFURNACE_GUI_TEXTURES);
    }
}
