package net.tutorialbykaupenjoe.livestreammod.event;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;

@Mod.EventBusSubscriber(modid = LivestreamMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onAchievingAdvancement(AdvancementEvent event) {
        if(event.getPlayer().world.isRemote) {
            System.out.println("CLIENT: " + event.getAdvancement().toString());
        }

        if(!event.getPlayer().world.isRemote) {
            System.out.println("SERVER: " + event.getAdvancement().toString());
        }
    }
}
