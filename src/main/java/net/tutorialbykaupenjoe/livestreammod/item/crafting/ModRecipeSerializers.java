package net.tutorialbykaupenjoe.livestreammod.item.crafting;

import net.minecraft.item.crafting.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;

public class ModRecipeSerializers {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LivestreamMod.MOD_ID);

    public static final RegistryObject<CookingRecipeSerializer<?>> KAUPEN_SMELTING
            = RECIPE_SERIALIZER.register("kaupenfurnace", () ->
            new CookingRecipeSerializer<>(KaupenFurnaceRecipe::new, 200));

    public static IRecipeType<KaupenFurnaceRecipe> KAUPEN_RECIPE = Registry.register(Registry.RECIPE_TYPE,
            new ResourceLocation(LivestreamMod.MOD_ID, "kaupenfurnace"), new IRecipeType<KaupenFurnaceRecipe>() {
                        public String toString() {
                            return LivestreamMod.MOD_ID + ":kaupenfurnace";
                        }});

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
    }
}
