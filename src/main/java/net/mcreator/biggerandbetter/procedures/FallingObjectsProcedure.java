package net.mcreator.biggerandbetter.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.biggerandbetter.init.BiggerAndBetterModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FallingObjectsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double percentage = 0;
		double two = 0;
		if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals("minecraft:zombie")) {
			if (entity.getBbHeight() >= 3) {
				percentage = 7.5;
				for (int index0 = 0; index0 < (int) (Math.round(entity.getBbHeight() * 0.5) - 1); index0++) {
					percentage = percentage + 18.5;
				}
				if (Mth.nextDouble(RandomSource.create(), 0, 100) <= percentage) {
					two = Mth.nextInt(RandomSource.create(), 1, 2);
					for (int index1 = 0; index1 < (int) two; index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(BiggerAndBetterModItems.GIANT_POTION.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
