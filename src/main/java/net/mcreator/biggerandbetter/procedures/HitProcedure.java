package net.mcreator.biggerandbetter.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.biggerandbetter.init.BiggerAndBetterModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HitProcedure {
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
		double z1 = 0;
		double y1 = 0;
		double x1 = 0;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity0.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0) >= 5) {
			x1 = Math.round(entity.getX()) - (Math.ceil(entity.getBbWidth()) / 2 + 1);
			z1 = Math.round(entity.getZ()) - (Math.ceil(entity.getBbWidth()) / 2 + 1);
			y1 = Math.round(entity.getY()) - 1;
			while (y1 <= Math.round(entity.getY()) + Math.ceil(entity.getBbHeight()) + 0) {
				while (z1 <= Math.round(entity.getZ()) + Math.ceil(entity.getBbWidth()) / 2 + 0) {
					while (x1 <= Math.round(entity.getX()) + Math.ceil(entity.getBbWidth()) / 2 + 0) {
						if ((world.getBlockState(BlockPos.containing(x1, y1, z1))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
							world.levelEvent(2001, BlockPos.containing(x1, y1, z1), Block.getId((world.getBlockState(BlockPos.containing(x1, y1, z1)))));
							{
								BlockPos _bp = BlockPos.containing(x1, y1, z1);
								BlockState _bs = Blocks.AIR.defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
						}
						x1 = x1 + 1;
					}
					x1 = Math.round(entity.getX()) - (Math.ceil(entity.getBbWidth()) / 2 + 1);
					z1 = z1 + 1;
				}
				z1 = Math.round(entity.getZ()) - (Math.ceil(entity.getBbWidth()) / 2 + 1);
				y1 = y1 + 1;
			}
		}
		if ((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE) ? _livingEntity21.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue() : 0) >= 10) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("scale set pehkui:hitbox_width " + (10 / (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(BiggerAndBetterModAttributes.SIZE)
									? _livingEntity22.getAttribute(BiggerAndBetterModAttributes.SIZE).getBaseValue()
									: 0)) + " @s"));
				}
			}
		}
	}
}
