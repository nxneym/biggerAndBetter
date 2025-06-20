
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.biggerandbetter.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.biggerandbetter.item.TestItem;
import net.mcreator.biggerandbetter.item.ShrinkAppleItem;
import net.mcreator.biggerandbetter.item.ImprovedShrinkingPotionItem;
import net.mcreator.biggerandbetter.item.ImprovedGiantPotionItem;
import net.mcreator.biggerandbetter.item.GiantPotionItem;
import net.mcreator.biggerandbetter.item.GiantAppleItem;
import net.mcreator.biggerandbetter.BiggerAndBetterMod;

public class BiggerAndBetterModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BiggerAndBetterMod.MODID);
	public static final DeferredItem<Item> GIANT_POTION = REGISTRY.register("giant_potion", GiantPotionItem::new);
	public static final DeferredItem<Item> IMPROVED_GIANT_POTION = REGISTRY.register("improved_giant_potion", ImprovedGiantPotionItem::new);
	public static final DeferredItem<Item> GIANT_APPLE = REGISTRY.register("giant_apple", GiantAppleItem::new);
	public static final DeferredItem<Item> TEST = REGISTRY.register("test", TestItem::new);
	public static final DeferredItem<Item> IMPROVED_SHRINKING_POTION = REGISTRY.register("improved_shrinking_potion", ImprovedShrinkingPotionItem::new);
	public static final DeferredItem<Item> SHRINK_APPLE = REGISTRY.register("shrink_apple", ShrinkAppleItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
