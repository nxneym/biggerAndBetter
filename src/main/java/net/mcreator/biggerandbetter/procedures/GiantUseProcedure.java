package net.mcreator.biggerandbetter.procedures;

import org.checkerframework.checker.units.qual.t;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.biggerandbetter.init.BiggerAndBetterModItems;
import net.mcreator.biggerandbetter.init.BiggerAndBetterModAttributes;
import net.mcreator.biggerandbetter.BiggerAndBetterMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiantUseProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		boolean a = false;
		double size = 0;
		double random = 0;
		double t = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BiggerAndBetterModItems.GIANT_APPLE.get()) {
			if ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity2.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0) >= 1) {
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE))
					_livingEntity4.getAttribute(BiggerAndBetterModAttributes.SIZE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity3.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0)
									+ 0.2));
				if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity6.getAttribute(Attributes.SCALE).setBaseValue(
							(entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity5.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0));
				if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity8.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 2));
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
					_livingEntity12.getAttribute(Attributes.ATTACK_DAMAGE)
							.setBaseValue(((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity11.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 0.2));
				BiggerAndBetterMod.LOGGER
						.info("attack damage:" + (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity13.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
				if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity15.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
							((entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity14.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) + 0.005));
				BiggerAndBetterMod.LOGGER.info(
						"movenment speed:" + (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity16.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0));
				if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
					_livingEntity18.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity17.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getBaseValue() : 0)
									+ 0.2));
				if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
					_livingEntity20.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE) ? _livingEntity19.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).getBaseValue() : 0)
									+ 0.2));
				if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
					_livingEntity22.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(
							((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity21.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) + 0.02));
				if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
					_livingEntity24.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity23.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0)
									+ 0.05));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.eat")), SoundSource.PLAYERS, 10, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.eat")), SoundSource.PLAYERS, 10, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 1);
				if (!(getEntityGameType(sourceentity) == GameType.CREATIVE)) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(BiggerAndBetterModItems.GIANT_APPLE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
			} else {
				if ((entity instanceof LivingEntity _livingEntity35 && _livingEntity35.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity35.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0) >= 0.1) {
					if (entity instanceof LivingEntity _livingEntity37 && _livingEntity37.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE))
						_livingEntity37.getAttribute(BiggerAndBetterModAttributes.SIZE).setBaseValue(
								((entity instanceof LivingEntity _livingEntity36 && _livingEntity36.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity36.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0)
										+ 0.1));
					if (entity instanceof LivingEntity _livingEntity39 && _livingEntity39.getAttributes().hasAttribute(Attributes.SCALE))
						_livingEntity39.getAttribute(Attributes.SCALE).setBaseValue(
								(entity instanceof LivingEntity _livingEntity38 && _livingEntity38.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity38.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0));
					if (entity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity41.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 1));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					if (entity instanceof LivingEntity _livingEntity45 && _livingEntity45.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
						_livingEntity45.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
								((entity instanceof LivingEntity _livingEntity44 && _livingEntity44.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity44.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 0.1));
					BiggerAndBetterMod.LOGGER.info(
							"attack damage:" + (entity instanceof LivingEntity _livingEntity46 && _livingEntity46.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity46.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
					if (entity instanceof LivingEntity _livingEntity48 && _livingEntity48.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
						_livingEntity48.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(
								((entity instanceof LivingEntity _livingEntity47 && _livingEntity47.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity47.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) + 0.0025));
					BiggerAndBetterMod.LOGGER.info("movenment speed:"
							+ (entity instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity49.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0));
					if (entity instanceof LivingEntity _livingEntity51 && _livingEntity51.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
						_livingEntity51.getAttribute(Attributes.BLOCK_INTERACTION_RANGE)
								.setBaseValue(((entity instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE)
										? _livingEntity50.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getBaseValue()
										: 0) + 0.1));
					if (entity instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
						_livingEntity53.getAttribute(Attributes.ENTITY_INTERACTION_RANGE)
								.setBaseValue(((entity instanceof LivingEntity _livingEntity52 && _livingEntity52.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE)
										? _livingEntity52.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).getBaseValue()
										: 0) + 0.1));
					if (entity instanceof LivingEntity _livingEntity55 && _livingEntity55.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
						_livingEntity55.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(
								((entity instanceof LivingEntity _livingEntity54 && _livingEntity54.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity54.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) + 0.01));
					if (entity instanceof LivingEntity _livingEntity57 && _livingEntity57.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
						_livingEntity57.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
								((entity instanceof LivingEntity _livingEntity56 && _livingEntity56.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity56.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0)
										+ 0.025));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.eat")), SoundSource.PLAYERS, 10, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.eat")), SoundSource.PLAYERS, 10, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 1);
					if (!(getEntityGameType(sourceentity) == GameType.CREATIVE)) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(BiggerAndBetterModItems.GIANT_APPLE.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
