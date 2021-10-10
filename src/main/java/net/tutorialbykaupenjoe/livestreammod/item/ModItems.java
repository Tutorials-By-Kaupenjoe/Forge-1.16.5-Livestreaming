package net.tutorialbykaupenjoe.livestreammod.item;

import net.minecraft.item.Item;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.item.custom.MultiPotionItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LivestreamMod.MOD_ID);

    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new ModBowItem(new Item.Properties().group(ModItemGroup.LIVESTREAM_GROUP)));

    public static final RegistryObject<Item> KAUPENSTAFF = ITEMS.register("kaupenstaff",
            () -> new StaffItem(new Item.Properties().group(ModItemGroup.LIVESTREAM_GROUP)));

    // public static final RegistryObject<Item> MULTI_POTION = ITEMS.register("multi_potion",
    //        () -> new MultiPotionItem(new Item.Properties().group(ModItemGroup.LIVESTREAM_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
