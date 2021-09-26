package net.tutorialbykaupenjoe.livestreammod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup LIVESTREAM_GROUP = new ItemGroup("livestreamModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.KAUPENBOW.get());
        }
    };
}
