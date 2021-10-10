package net.tutorialbykaupenjoe.livestreammod.item.custom;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.registry.Registry;

// Not quite what I expected. Do enable it in ModItems if you wanna see
// and try out a few things :)
public class MultiPotionItem extends PotionItem {
    public MultiPotionItem(Properties builder) {
        super(builder);
    }

    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
            for(Potion potion1 : Registry.POTION) {
                for(Potion potion2 : Registry.POTION) {
                    if (potion1 != Potions.EMPTY && potion2 != Potions.EMPTY && potion1 != potion2) {
                        items.add(PotionUtils.appendEffects(PotionUtils.addPotionToItemStack(new ItemStack(this),
                                        potion1), potion2.getEffects()));
                    }
                }
            }
        }
    }
}
