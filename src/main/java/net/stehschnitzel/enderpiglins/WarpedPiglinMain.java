package net.stehschnitzel.enderpiglins;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.enderpiglins.core.Init;
import software.bernie.geckolib3.GeckoLib;

@Mod(WarpedPiglinMain.MOD_ID)
public class WarpedPiglinMain {
	public static final String MOD_ID = "warpedpiglin";

	public WarpedPiglinMain() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		Init.ENTITIES.register(bus);
		Init.ITEMS.register(bus);

		GeckoLib.initialize();

		MinecraftForge.EVENT_BUS.register(this);

	}
}
