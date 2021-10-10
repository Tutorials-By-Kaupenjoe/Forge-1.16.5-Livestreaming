package net.tutorialbykaupenjoe.livestreammod;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tutorialbykaupenjoe.livestreammod.block.ModBlocks;
import net.tutorialbykaupenjoe.livestreammod.container.ModContainers;
import net.tutorialbykaupenjoe.livestreammod.entity.MagicSpellRenderer;
import net.tutorialbykaupenjoe.livestreammod.entity.ModEntityTypes;
import net.tutorialbykaupenjoe.livestreammod.item.ModItems;
import net.tutorialbykaupenjoe.livestreammod.item.crafting.ModRecipeSerializers;
import net.tutorialbykaupenjoe.livestreammod.screen.KaupenCraftingScreen;
import net.tutorialbykaupenjoe.livestreammod.screen.KaupenFurnaceScreen;
import net.tutorialbykaupenjoe.livestreammod.tile.ModTileEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LivestreamMod.MOD_ID)
public class LivestreamMod
{
    public static final String MOD_ID = "livestreammod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public LivestreamMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);

        ModRecipeSerializers.register(eventBus);

        ModEntityTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            ShapedRecipe.setCraftingSize(5, 5);
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        makeBow(ModItems.KAUPENBOW.get());
        RenderTypeLookup.setRenderLayer(ModBlocks.KAUPEN_CORAL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.KAUPEN_CORAL_DEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.KAUPEN_ALTAR.get(), RenderType.getCutout());

        ScreenManager.registerFactory(ModContainers.KAUPEN_FURNACE_CONTAINER.get(), KaupenFurnaceScreen::new);
        ScreenManager.registerFactory(ModContainers.KAUPEN_CRAFTING_CONTAINER.get(), KaupenCraftingScreen::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MAGIC_SPELL.get(), MagicSpellRenderer::new);

        ItemModelsProperties.registerProperty(ModItems.KAUPENSTAFF.get(), new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {
            if (p_239429_2_ == null) {
                return 0.0F;
            } else {
                return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)(p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
            }
        });
    }

    private void makeBow(Item item) {
        ItemModelsProperties.registerProperty(item, new ResourceLocation("pull"),
                (p_239429_0_, p_239429_1_, p_239429_2_) -> {
            if (p_239429_2_ == null) {
                return 0.0F;
            } else {
                return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F :
                        (float)(p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
            }
        });

        ItemModelsProperties.registerProperty(item, new ResourceLocation("pulling"),
                (p_239428_0_, p_239428_1_, p_239428_2_) -> {
            return p_239428_2_ != null && p_239428_2_.isHandActive() &&
                    p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
        });
    }
}
