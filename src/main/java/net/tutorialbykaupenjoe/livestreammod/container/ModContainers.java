package net.tutorialbykaupenjoe.livestreammod.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;

public class ModContainers {
    public static DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, LivestreamMod.MOD_ID);

    public static final RegistryObject<ContainerType<KaupenFurnaceContainer>> KAUPEN_FURNACE_CONTAINER
            = CONTAINERS.register("kaupen_furnace_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                return new KaupenFurnaceContainer(windowId, inv);
            })));

    public static final RegistryObject<ContainerType<KaupenWorkbenchContainer>> KAUPEN_CRAFTING_CONTAINER
            = CONTAINERS.register("kaupen_crafting_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                return new KaupenWorkbenchContainer(windowId, inv);
            })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
