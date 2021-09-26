package net.tutorialbykaupenjoe.livestreammod.event;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;

@Mod.EventBusSubscriber(modid = LivestreamMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onArrowExplodeIntoParticles(LivingHurtEvent event) {

    }
}
