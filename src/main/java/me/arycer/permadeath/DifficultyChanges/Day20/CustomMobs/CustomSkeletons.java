package me.arycer.permadeath.DifficultyChanges.Day20.CustomMobs;

import me.arycer.permadeath.Util.EntityUtils;
import me.arycer.permadeath.Util.NbtUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import java.awt.*;

public class CustomSkeletons {
    public static WitherSkeletonEntity chainWitherSkeleton (WitherSkeletonEntity skeleton) {
        skeleton.equipStack(EquipmentSlot.HEAD, NbtUtils.makeUnbreakable(new ItemStack(Items.CHAINMAIL_HELMET)));
        skeleton.equipStack(EquipmentSlot.CHEST, NbtUtils.makeUnbreakable(new ItemStack(Items.CHAINMAIL_CHESTPLATE)));
        skeleton.equipStack(EquipmentSlot.LEGS, NbtUtils.makeUnbreakable(new ItemStack(Items.CHAINMAIL_LEGGINGS)));
        skeleton.equipStack(EquipmentSlot.FEET, NbtUtils.makeUnbreakable(new ItemStack(Items.CHAINMAIL_BOOTS)));
    ItemStack bow = new ItemStack(Items.BOW);

    RegistryEntry<Enchantment> punch = skeleton.getWorld()
        .getRegistryManager()
        .get(RegistryKeys.ENCHANTMENT)
        .entryOf(Enchantments.PUNCH);

    bow.addEnchantment(punch, 20);

    skeleton.equipStack(
        EquipmentSlot.MAINHAND,
        NbtUtils.makeUnbreakable(bow)

);
        EntityUtils.setMaxHealth(skeleton, skeleton.getMaxHealth() * 2, true);
        return EntityUtils.notDropEquipment(skeleton);

    }

    public static SkeletonEntity diamondSkeleton (SkeletonEntity skeleton) {
        skeleton.equipStack(EquipmentSlot.HEAD, NbtUtils.makeUnbreakable(new ItemStack(Items.DIAMOND_HELMET)));
        skeleton.equipStack(EquipmentSlot.CHEST, NbtUtils.makeUnbreakable(new ItemStack(Items.DIAMOND_CHESTPLATE)));
        skeleton.equipStack(EquipmentSlot.LEGS, NbtUtils.makeUnbreakable(new ItemStack(Items.DIAMOND_LEGGINGS)));
        skeleton.equipStack(EquipmentSlot.FEET, NbtUtils.makeUnbreakable(new ItemStack(Items.DIAMOND_BOOTS)));
        skeleton.equipStack(EquipmentSlot.MAINHAND, NbtUtils.makeUnbreakable(new ItemStack(Items.BOW)));

        return EntityUtils.notDropEquipment(skeleton);
    }

    public static SkeletonEntity goldSkeleton (SkeletonEntity skeleton) {
        skeleton.equipStack(EquipmentSlot.HEAD, NbtUtils.makeUnbreakable(new ItemStack(Items.GOLDEN_HELMET)));
        skeleton.equipStack(EquipmentSlot.CHEST, NbtUtils.makeUnbreakable(new ItemStack(Items.GOLDEN_CHESTPLATE)));
        skeleton.equipStack(EquipmentSlot.LEGS, NbtUtils.makeUnbreakable(new ItemStack(Items.GOLDEN_LEGGINGS)));
        skeleton.equipStack(EquipmentSlot.FEET, NbtUtils.makeUnbreakable(new ItemStack(Items.GOLDEN_BOOTS)));
    ItemStack crossbow = new ItemStack(Items.CROSSBOW);

    RegistryEntry<Enchantment> sharp = skeleton.getWorld()
        .getRegistryManager()
        .get(RegistryKeys.ENCHANTMENT)
        .entryOf(Enchantments.SHARPNESS);

    crossbow.addEnchantment(sharp, 20);

    skeleton.equipStack(
        EquipmentSlot.MAINHAND,
        NbtUtils.makeUnbreakable(crossbow)
);

        EntityUtils.setMaxHealth(skeleton, skeleton.getMaxHealth() * 2, true);
        return EntityUtils.notDropEquipment(skeleton);
    }

    public static SkeletonEntity ironSkeleton (SkeletonEntity skeleton) {
        skeleton.equipStack(EquipmentSlot.HEAD, NbtUtils.makeUnbreakable(new ItemStack(Items.IRON_HELMET)));
        skeleton.equipStack(EquipmentSlot.CHEST, NbtUtils.makeUnbreakable(new ItemStack(Items.IRON_CHESTPLATE)));
        skeleton.equipStack(EquipmentSlot.LEGS, NbtUtils.makeUnbreakable(new ItemStack(Items.IRON_LEGGINGS)));
        skeleton.equipStack(EquipmentSlot.FEET, NbtUtils.makeUnbreakable(new ItemStack(Items.IRON_BOOTS)));

    ItemStack axe = new ItemStack(Items.IRON_AXE);

    RegistryEntry<Enchantment> fire = skeleton.getWorld()
        .getRegistryManager()
        .get(RegistryKeys.ENCHANTMENT)
        .entryOf(Enchantments.FIRE_ASPECT);

    axe.addEnchantment(fire, 2);

    skeleton.equipStack(
        EquipmentSlot.MAINHAND,
        NbtUtils.makeUnbreakable(axe)
        

);  return EntityUtils.notDropEquipment(skeleton);

    }

    public static WitherSkeletonEntity leatherWitherSkeleton (WitherSkeletonEntity skeleton) {
        skeleton.equipStack(EquipmentSlot.HEAD, NbtUtils.makeUnbreakable(NbtUtils.dyeArmor(new ItemStack(Items.LEATHER_HELMET), Color.RED.getRGB())));
        skeleton.equipStack(EquipmentSlot.CHEST, NbtUtils.makeUnbreakable(NbtUtils.dyeArmor(new ItemStack(Items.LEATHER_CHESTPLATE), Color.RED.getRGB())));
        skeleton.equipStack(EquipmentSlot.LEGS, NbtUtils.makeUnbreakable(NbtUtils.dyeArmor(new ItemStack(Items.LEATHER_LEGGINGS), Color.RED.getRGB())));
        skeleton.equipStack(EquipmentSlot.FEET, NbtUtils.makeUnbreakable(NbtUtils.dyeArmor(new ItemStack(Items.LEATHER_BOOTS), Color.RED.getRGB())));
    
    
    ItemStack bow = new ItemStack(Items.BOW);

    RegistryEntry<Enchantment> fire = skeleton.getWorld()
        .getRegistryManager()
        .get(RegistryKeys.ENCHANTMENT)
        .entryOf(Enchantments.POWER);

    bow.addEnchantment(fire, 20);

    skeleton.equipStack(
        EquipmentSlot.MAINHAND,
        NbtUtils.makeUnbreakable(bow)
        

);  
        EntityUtils.setMaxHealth(skeleton, skeleton.getMaxHealth() * 2, true);
        return EntityUtils.notDropEquipment(skeleton);
    }
}