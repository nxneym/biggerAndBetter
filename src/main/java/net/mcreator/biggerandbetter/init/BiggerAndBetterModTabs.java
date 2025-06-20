
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.biggerandbetter.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.biggerandbetter.BiggerAndBetterMod;

public class BiggerAndBetterModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BiggerAndBetterMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BIGGER_AND_BETTER = REGISTRY.register("bigger_and_better",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.bigger_and_better.bigger_and_better")).icon(() -> new ItemStack(BiggerAndBetterModItems.GIANT_POTION.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BiggerAndBetterModItems.GIANT_POTION.get());
				tabData.accept(BiggerAndBetterModItems.IMPROVED_GIANT_POTION.get());
				tabData.accept(BiggerAndBetterModItems.GIANT_APPLE.get());
				tabData.accept(BiggerAndBetterModItems.TEST.get());
				tabData.accept(BiggerAndBetterModItems.IMPROVED_SHRINKING_POTION.get());
				tabData.accept(BiggerAndBetterModItems.SHRINK_APPLE.get());
			}).build());
}
