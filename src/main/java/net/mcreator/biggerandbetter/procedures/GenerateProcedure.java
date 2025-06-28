package net.mcreator.biggerandbetter.procedures;

import org.checkerframework.checker.units.qual.t;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.biggerandbetter.network.BiggerAndBetterModVariables;
import net.mcreator.biggerandbetter.init.BiggerAndBetterModAttributes;
import net.mcreator.biggerandbetter.BiggerAndBetterMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GenerateProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean a = false;
		double random = 0;
		double t = 0;
		if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals("minecraft:zombie")) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.isBaby()) {
			} else {
				random = Mth.nextInt(RandomSource.create(), 1, 100);
				BiggerAndBetterMod.LOGGER.info(random);
				if (random <= 6) {
					if (BiggerAndBetterModVariables.MapVariables.get(world).Giantzombie == true) {
						t = 2;
						for (int index0 = 0; index0 < (int) Math.ceil(random * 2 - 2); index0++) {
							if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + t, entity.getZ()))) {
								a = true;
							} else {
								a = false;
								BiggerAndBetterMod.LOGGER.info("Having obstacles");
								break;
							}
							t = t + 1;
						}
						if (a == true) {
							BiggerAndBetterMod.LOGGER.info("No obstacles");
							if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE))
								_livingEntity7.getAttribute(BiggerAndBetterModAttributes.SIZE).setBaseValue(random);
							if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.SCALE))
								_livingEntity8.getAttribute(Attributes.SCALE).setBaseValue(random);
							if (random >= 2) {
								BiggerAndBetterMod.LOGGER.info("Size greater than 2");
								if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
									_livingEntity11.getAttribute(Attributes.MAX_HEALTH)
											.setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + (random - 1) * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8));
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
								if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
									_livingEntity16.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
											((entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity14.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0)
													+ (random - 1) * (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
															? _livingEntity15.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
															: 0) * 0.5));
								BiggerAndBetterMod.LOGGER.info("attack damage:"
										+ (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity17.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
								if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
									_livingEntity20.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(((entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
											? _livingEntity18.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue()
											: 0)
											+ (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity19.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
													* 0.5));
								BiggerAndBetterMod.LOGGER.info("movenment speed:"
										+ (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity21.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0));
								if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
									_livingEntity24.getAttribute(Attributes.BLOCK_INTERACTION_RANGE)
											.setBaseValue(((entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE)
													? _livingEntity22.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getBaseValue()
													: 0)
													+ (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE)
															? _livingEntity23.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getBaseValue()
															: 0) * 0.5));
								if (entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
									_livingEntity27.getAttribute(Attributes.ENTITY_INTERACTION_RANGE)
											.setBaseValue(((entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE)
													? _livingEntity25.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).getBaseValue()
													: 0)
													+ (entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE)
															? _livingEntity26.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).getBaseValue()
															: 0) * 0.5));
								if (entity instanceof LivingEntity _entity) {
									AttributeInstance _attrInst = _entity.getAttribute(Attributes.STEP_HEIGHT);
									if (_attrInst != null)
										_attrInst.setBaseValue((float) (0.6 + random * 0.3));
								}
								if (entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
									_livingEntity29.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue((random * 0.5));
							}
						}
					}
				}
			}
		}
	}
}
