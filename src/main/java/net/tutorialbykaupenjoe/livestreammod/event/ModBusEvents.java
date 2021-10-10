package net.tutorialbykaupenjoe.livestreammod.event;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.event.loot.AltarAdditionModifier;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = LivestreamMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().register(
                new AltarAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(LivestreamMod.MOD_ID,"altar_from_piston"))
        );
    }
}
