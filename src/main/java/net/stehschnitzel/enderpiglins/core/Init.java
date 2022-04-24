package net.stehschnitzel.enderpiglins.core;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stehschnitzel.enderpiglins.WarpedPiglinMain;
import net.stehschnitzel.enderpiglins.common.entities.WarpedPiglin;

public class Init {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			 WarpedPiglinMain.MOD_ID);

	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, WarpedPiglinMain.MOD_ID);

	public static final RegistryObject<EntityType<WarpedPiglin>> WARPED_PIGLIN = ENTITIES.register("warped_piglin",
			() -> EntityType.Builder.of(WarpedPiglin::new, EntityClassification.MONSTER)
					.sized(0.75f, 2f)
					.build("warped_piglin"));

	public static final RegistryObject<Item> WARPED_PIGLIN_SPAWN_EGG = ITEMS.register("warped_piglin_spawn_egg",
			() -> new ForgeSpawnEggItem(WARPED_PIGLIN, 0x313131,0x9e719e, new SpawnEggItem.Properties().tab(ItemGroup.TAB_MISC)));

}
