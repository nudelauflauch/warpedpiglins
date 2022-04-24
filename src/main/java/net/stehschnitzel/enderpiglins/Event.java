package net.stehschnitzel.enderpiglins;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stehschnitzel.enderpiglins.common.entities.WarpedPiglin;
import net.stehschnitzel.enderpiglins.core.Init;

@Mod.EventBusSubscriber(modid = WarpedPiglinMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Event {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        event.put(Init.WARPED_PIGLIN.get(), WarpedPiglin.createAttributes().build());
    }
}