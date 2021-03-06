package net.tutorialbykaupenjoe.livestreammod.block;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;
import net.minecraft.advancements.Criterion;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.advancements.AdvancementState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.ITag;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.item.ModItemGroup;
import net.tutorialbykaupenjoe.livestreammod.item.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LivestreamMod.MOD_ID);

    public static final RegistryObject<Block> KAUPEN_CORAL_DEAD = registerBlock("kaupencoral_dead",
            () -> new DeadCoralPlantBlock(AbstractBlock.Properties.create(Material.CORAL)), "tooltip.block.livestreammod.kaupencoral_dead");

    public static final RegistryObject<Block> KAUPEN_CORAL = registerBlock("kaupencoral",
            () -> new CoralPlantBlock(ModBlocks.KAUPEN_CORAL_DEAD.get(), AbstractBlock.Properties.create(Material.CORAL)));

    public static final RegistryObject<Block> KAUPEN_FURNACE = registerBlock("kaupen_furnace",
            () -> new KaupenFurnaceBlock(AbstractBlock.Properties.create(Material.ROCK)));

    public static final RegistryObject<Block> KAUPEN_ALTAR = registerBlock("altar",
            () -> new AltarBlock(AbstractBlock.Properties.create(Material.ROCK).notSolid()));

    public static final RegistryObject<Block> HEROBRINES_FURNACE = registerBlock("herobrinesfurnace",
            () -> new HerobrinesFurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).notSolid()));

    public static final RegistryObject<Block> KAUPEN_CRAFTING_TABLE = registerBlock("kaupen_crafting_table",
            () -> new KaupenCraftingTableBlock(AbstractBlock.Properties.create(Material.WOOD)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.LIVESTREAM_GROUP)) {
            @Override
            public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                tooltip.add(new TranslationTextComponent(tooltipKey));
                super.addInformation(stack, worldIn, tooltip, flagIn);
            }
        });
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.LIVESTREAM_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
