package net.mcreator.biggerandbetter.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.biggerandbetter.network.BiggerAndBetterModVariables;

public class OnGiantProcedure {
	public static void execute(LevelAccessor world) {
		BiggerAndBetterModVariables.MapVariables.get(world).Giantzombie = true;
		BiggerAndBetterModVariables.MapVariables.get(world).syncData(world);
	}
}
