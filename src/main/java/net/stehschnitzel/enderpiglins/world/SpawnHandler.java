package net.stehschnitzel.enderpiglins.world;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stehschnitzel.enderpiglins.WarpedPiglinMain;
import net.stehschnitzel.enderpiglins.core.Init;

@Mod.EventBusSubscriber(modid = WarpedPiglinMain.MOD_ID)
public class SpawnHandler {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        System.out.println("ja");
        if (event.getName() == null) return;
        if (event.getName().equals(Biomes.WARPED_FOREST)) {
            System.out.println("Added enderpiglin biome: ");
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(Init.WARPED_PIGLIN.get(), 2, 1, 3));
         }
    }
}
