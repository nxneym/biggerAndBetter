package net.mcreator.biggerandbetter.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.biggerandbetter.init.BiggerAndBetterModAttributes;
import net.mcreator.biggerandbetter.BiggerAndBetterMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DefaultIProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(BiggerAndBetterModAttributes.FIRST_ENTRY) ? _livingEntity0.getAttribute(BiggerAndBetterModAttributes.FIRST_ENTRY).getBaseValue() : 0) == 0) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(BiggerAndBetterModAttributes.FIRST_ENTRY))
				_livingEntity1.getAttribute(BiggerAndBetterModAttributes.FIRST_ENTRY).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_SIZE))
				_livingEntity3.getAttribute(BiggerAndBetterModAttributes.DEFAULT_SIZE)
						.setBaseValue((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity2.getAttribute(Attributes.SCALE).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_HEALTH))
				_livingEntity5.getAttribute(BiggerAndBetterModAttributes.DEFAULT_HEALTH)
						.setBaseValue((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity4.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_ATT))
				_livingEntity7.getAttribute(BiggerAndBetterModAttributes.DEFAULT_ATT)
						.setBaseValue((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity6.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_SPEED))
				_livingEntity9.getAttribute(BiggerAndBetterModAttributes.DEFAULT_SPEED)
						.setBaseValue((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity8.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_BREACH))
				_livingEntity11.getAttribute(BiggerAndBetterModAttributes.DEFAULT_BREACH).setBaseValue(
						(entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity10.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_EREACH))
				_livingEntity13.getAttribute(BiggerAndBetterModAttributes.DEFAULT_EREACH).setBaseValue(
						(entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE) ? _livingEntity12.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_KNOCK))
				_livingEntity15.getAttribute(BiggerAndBetterModAttributes.DEFAULT_KNOCK).setBaseValue(
						(entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity14.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue() : 0));
			if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(BiggerAndBetterModAttributes.DEFAULT_STEP))
				_livingEntity17.getAttribute(BiggerAndBetterModAttributes.DEFAULT_STEP)
						.setBaseValue((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity16.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0));
			BiggerAndBetterMod.LOGGER.info("player first entry");
		}
	}
}
