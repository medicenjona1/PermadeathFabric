package me.arycer.permadeath.Util;

import com.google.common.collect.Iterables;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.entry.RegistryEntry;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class EntityUtils {
    public static <T extends MobEntity> T notDropEquipment(T mob) {
        mob.setEquipmentDropChance(EquipmentSlot.HEAD, 0);
        mob.setEquipmentDropChance(EquipmentSlot.CHEST, 0);
        mob.setEquipmentDropChance(EquipmentSlot.LEGS, 0);
        mob.setEquipmentDropChance(EquipmentSlot.FEET, 0);

        mob.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0);
        mob.setEquipmentDropChance(EquipmentSlot.OFFHAND, 0);

        return mob;
    }

    public static <T extends MobEntity> void addListEffects(T mob, HashMap<RegistryEntry<StatusEffect>, Integer> effectList, int minEffects, int maxEffects) {
        List<RegistryEntry<StatusEffect>> avalaibleEffects = new ArrayList<>(effectList.keySet());
        int numEffects = mob.getRandom().nextInt(maxEffects - minEffects + 1) + minEffects;
        int max = Math.min(maxEffects, avalaibleEffects.size());
        int min = Math.min(minEffects, max);

        for (int i = 0; i < numEffects; i++) {
            int index = mob.getRandom().nextInt(avalaibleEffects.size());

            RegistryEntry<StatusEffect> effect = avalaibleEffects.remove(index);

            int duration = -1;
            int amplifier = effectList.get(effect);
            boolean ambient = false;
            boolean showParticles = true;
            boolean showIcon = true;

            mob.addStatusEffect(new StatusEffectInstance(effect, duration, amplifier, ambient, showParticles, showIcon));
        }
    }

    public static <T extends LivingEntity> void setMaxHealth(T entity, double maxHealth, boolean heal) {
        Objects.requireNonNull(entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
        if (heal) entity.setHealth(entity.getMaxHealth());
    }
}
