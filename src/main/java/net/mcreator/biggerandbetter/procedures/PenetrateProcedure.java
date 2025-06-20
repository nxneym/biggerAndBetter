package net.mcreator.biggerandbetter.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.biggerandbetter.init.BiggerAndBetterModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PenetrateProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean tes = false;
		double random = 0;
		double z1 = 0;
		double y1 = 0;
		double x1 = 0;
		for (Entity entityiterator : world.getEntities(entity, new AABB((Math.round(entity.getX()) - (Math.ceil(entity.getBbWidth()) / 2 + 0)), (Math.round(entity.getY()) - 1), (Math.round(entity.getZ()) - (Math.ceil(entity.getBbWidth()) / 2 + 0)),
				(Math.round(entity.getX()) + Math.ceil(entity.getBbWidth()) / 2 + 0), (Math.round(entity.getY()) + entity.getBbHeight() * 0.25), (Math.round(entity.getZ()) + Math.ceil(entity.getBbWidth()) / 2 + 0)))) {
			if ((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE)
					? _livingEntity11.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue()
					: 0) >= (entityiterator instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE)
							? _livingEntity12.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue()
							: 0) * 7) {
				x1 = Math.round(entity.getX()) - (Math.ceil(entity.getBbWidth()) / 2 + 0);
				z1 = Math.round(entity.getZ()) - (Math.ceil(entity.getBbWidth()) / 2 + 0);
				y1 = Math.round(entity.getY()) - 1;
				if (Mth.nextInt(RandomSource.create(), 0,
						49) <= (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity19.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0)) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("bigger_and_better:trample"))), entity),
							(float) ((entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE)
									? _livingEntity20.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue()
									: 0) / 10));
				}
			} else if ((entityiterator instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE)
					? _livingEntity23.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue()
					: 0) <= 0.5) {
				x1 = Math.round(entity.getX()) - (Math.ceil(entity.getBbWidth()) / 2 + 0);
				z1 = Math.round(entity.getZ()) - (Math.ceil(entity.getBbWidth()) / 2 + 0);
				y1 = Math.round(entity.getY()) - 0;
				if (Mth.nextInt(RandomSource.create(), 0,
						49) <= (entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity30.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0)) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("bigger_and_better:trample"))), entity),
							(float) ((entity instanceof LivingEntity _livingEntity31 && _livingEntity31.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE)
									? _livingEntity31.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue()
									: 0) / 10));
				}
			}
		}
	}
}
