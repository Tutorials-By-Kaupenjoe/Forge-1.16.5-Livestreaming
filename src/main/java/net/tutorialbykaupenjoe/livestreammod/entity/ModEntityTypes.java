package net.tutorialbykaupenjoe.livestreammod.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.entity.projectile.MagicSpellEntity;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, LivestreamMod.MOD_ID);

    public static final RegistryObject<EntityType<MagicSpellEntity>> MAGIC_SPELL =
            ENTITY_TYPES.register("magic_spell",
                    () -> EntityType.Builder.<MagicSpellEntity>create(MagicSpellEntity::new,
                                    EntityClassification.MISC).size(0.3f, 0.3f).trackingRange(3).updateInterval(20)
                            .build(new ResourceLocation(LivestreamMod.MOD_ID, "magic_spell").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
