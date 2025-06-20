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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

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
				random = Mth.nextDouble(RandomSource.create(), 0, 90);
				BiggerAndBetterMod.LOGGER.info(random);
				if (random <= 12) {
					if (random > 1) {
						if (BiggerAndBetterModVariables.MapVariables.get(world).Giantzombie == true) {
							t = 2;
							for (int index0 = 0; index0 < (int) Math.ceil(random * 2 - 2); index0++) {
								if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + t, entity.getZ()))) {
									a = true;
								} else {
									a = false;
									break;
								}
								t = t + 1;
							}
							if (a == true) {
								if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE))
									_livingEntity7.getAttribute(BiggerAndBetterModAttributes.SIZE).setBaseValue(random);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("scale set pehkui:base " + random + " @s"));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("scale set pehkui:attack " + (1 + random * 0.5) + " @s"));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("scale set pehkui:defense " + (1 + random * 0.5) + " @s"));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("scale set pehkui:health " + (1 + random * 0.5) + " @s"));
									}
								}
								if (random > 2) {
									if (entity instanceof LivingEntity _entity) {
										AttributeInstance _attrInst = _entity.getAttribute(Attributes.STEP_HEIGHT);
										if (_attrInst != null)
											_attrInst.setBaseValue((float) (0.6 + random * 0.3));
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"scale set pehkui:entity_reach 0.5 @s");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													("attribute @s minecraft:generic.knockback_resistance base set " + (random - 1) * 0.5));
										}
									}
								}
							}
						}
					}
					if (random < 1) {
						if (BiggerAndBetterModVariables.MapVariables.get(world).Shrinkzombies == true) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("scale set pehkui:base " + random + " @s"));
								}
							}
							if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE))
								_livingEntity16.getAttribute(BiggerAndBetterModAttributes.SIZE).setBaseValue(random);
						}
					}
				}
			}
		}
	}
}
