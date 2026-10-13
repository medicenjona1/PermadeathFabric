package me.arycer.permadeath.Util;

import java.util.Map;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;


import net.minecraft.registry.RegistryKey;


public class NbtUtils {
    public static ItemStack makeUnbreakable(ItemStack stack) {
        stack.set(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true) );
        return stack;

        /*NbtCompound tag = stack.getOrCreateNbt();
        tag.putBoolean("Unbreakable", true);
        stack.setNbt(tag);
        return stack;*/
    }

    public static ItemStack dyeArmor(ItemStack stack, int color) {
        stack.set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(color, true));
        return stack;


       /* NbtCompound tag = stack.getOrCreateNbt();
        NbtCompound display = tag.getCompound("display");
        display.putInt("color", color);
        tag.put("display", display);
        stack.setNbt(tag);
        return stack; */
    }


public static ItemStack enchantItem(
        ItemStack stack,
        LivingEntity entity,
        Map<RegistryKey<Enchantment>, Integer> enchantments
) {
    var registry = entity.getWorld()
            .getRegistryManager()
            .get(RegistryKeys.ENCHANTMENT);

    enchantments.forEach((key, level) ->
            stack.addEnchantment(registry.entryOf(key), level)
    );

    return stack;
}




}
    


