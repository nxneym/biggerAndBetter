
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.biggerandbetter.BiggerAndBetterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BiggerAndBetterModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, BiggerAndBetterMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> SIZE = REGISTRY.register("size", () -> new RangedAttribute("attribute.bigger_and_better.size", 1, 0.1, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_SIZE = REGISTRY.register("default_size", () -> new RangedAttribute("attribute.bigger_and_better.default_size", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_HEALTH = REGISTRY.register("default_health", () -> new RangedAttribute("attribute.bigger_and_better.default_health", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_ATT = REGISTRY.register("default_att", () -> new RangedAttribute("attribute.bigger_and_better.default_att", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_SPEED = REGISTRY.register("default_speed", () -> new RangedAttribute("attribute.bigger_and_better.default_speed", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_BREACH = REGISTRY.register("default_breach", () -> new RangedAttribute("attribute.bigger_and_better.default_breach", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_EREACH = REGISTRY.register("default_ereach", () -> new RangedAttribute("attribute.bigger_and_better.default_ereach", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_KNOCK = REGISTRY.register("default_knock", () -> new RangedAttribute("attribute.bigger_and_better.default_knock", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_STEP = REGISTRY.register("default_step", () -> new RangedAttribute("attribute.bigger_and_better.default_step", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> FIRST_ENTRY = REGISTRY.register("first_entry", () -> new RangedAttribute("attribute.bigger_and_better.first_entry", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFAULT_ARMOR = REGISTRY.register("default_armor", () -> new RangedAttribute("attribute.bigger_and_better.default_armor", 0, 0, 100).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, SIZE));
		event.add(EntityType.PLAYER, DEFAULT_SIZE);
		event.add(EntityType.PLAYER, DEFAULT_HEALTH);
		event.add(EntityType.PLAYER, DEFAULT_ATT);
		event.add(EntityType.PLAYER, DEFAULT_SPEED);
		event.add(EntityType.PLAYER, DEFAULT_BREACH);
		event.add(EntityType.PLAYER, DEFAULT_EREACH);
		event.add(EntityType.PLAYER, DEFAULT_KNOCK);
		event.add(EntityType.PLAYER, DEFAULT_STEP);
		event.add(EntityType.PLAYER, FIRST_ENTRY);
		event.add(EntityType.PLAYER, DEFAULT_ARMOR);
	}
}
