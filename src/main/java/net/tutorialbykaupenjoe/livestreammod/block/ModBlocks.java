package net.tutorialbykaupenjoe.livestreammod.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.item.ModItemGroup;
import net.tutorialbykaupenjoe.livestreammod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LivestreamMod.MOD_ID);

    public static final RegistryObject<Block> KAUPEN_CORAL_DEAD = registerBlock("kaupencoral_dead",
            () -> new DeadCoralPlantBlock(AbstractBlock.Properties.create(Material.CORAL)));

    public static final RegistryObject<Block> KAUPEN_CORAL = registerBlock("kaupencoral",
            () -> new CoralPlantBlock(ModBlocks.KAUPEN_CORAL_DEAD.get(), AbstractBlock.Properties.create(Material.CORAL)));

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
