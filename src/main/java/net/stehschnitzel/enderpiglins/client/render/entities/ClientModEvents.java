package net.stehschnitzel.enderpiglins.client.render.entities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.stehschnitzel.enderpiglins.WarpedPiglinMain;
import net.stehschnitzel.enderpiglins.core.Init;

@Mod.EventBusSubscriber(modid = WarpedPiglinMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(Init.WARPED_PIGLIN.get(), ExtenedWarpedPiglinRenderer::new);
    }

}
