
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.biggerandbetter.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.biggerandbetter.BiggerAndBetterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BiggerAndBetterModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, BiggerAndBetterMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> SIZE = REGISTRY.register("size", () -> new RangedAttribute("attribute.bigger_and_better.size", 1, 0.1, 100).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, SIZE));
	}
}
