package net.mcreator.biggerandbetter.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.biggerandbetter.network.BiggerAndBetterModVariables;

public class OffShrinkProcedure {
	public static void execute(LevelAccessor world) {
		BiggerAndBetterModVariables.MapVariables.get(world).Shrinkzombies = false;
		BiggerAndBetterModVariables.MapVariables.get(world).syncData(world);
	}
}
