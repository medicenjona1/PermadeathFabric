package me.arycer.permadeath.DifficultyChanges.Day20;

import me.arycer.permadeath.DifficultyChanges.Day25.NetheriteMobs;
import me.arycer.permadeath.Main;
import me.arycer.permadeath.Util.ModConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;

public class LootTables {
    private static final HashMap<EntityType<?>, RegistryKey<LootTable>> MOBS_TO_MODIFY = new HashMap<>() {{
        put(EntityType.IRON_GOLEM, lootTable("empty"));
        put(EntityType.MAGMA_CUBE, lootTable("empty"));
        put(EntityType.PHANTOM, lootTable("empty"));
        put(EntityType.ZOMBIFIED_PIGLIN, lootTable("empty"));
        put(EntityType.ENDERMAN, lootTable("empty"));
        put(EntityType.SLIME, lootTable("empty"));
        put(EntityType.GHAST, lootTable("empty"));
        put(EntityType.WITCH, lootTable("empty"));
        put(EntityType.DROWNED, lootTable("empty"));
        put(EntityType.GUARDIAN, lootTable("empty"));
        put(EntityType.WITHER_SKELETON, lootTable("empty"));
        put(EntityType.BLAZE, lootTable("empty"));
        put(EntityType.EVOKER, lootTable("empty"));
        put(EntityType.RAVAGER, lootTable("day20/ravager"));
    }};

    private static RegistryKey<LootTable> lootTable(String path) {
        return RegistryKey.of(
            RegistryKeys.LOOT_TABLE,
            Identifier.of(Main.MOD_ID, path)
        );
    }

    public static void register(
            CallbackInfoReturnable<RegistryKey<LootTable>> cir,
            MobEntity entity) {
        EntityType<?> type = entity.getType();

        if (!MOBS_TO_MODIFY.containsKey(type)
                || (ModConfig.getServerDay() >= 25
                && NetheriteMobs.MOBS_TO_MODIFY.containsKey(type))) {
            return;
        }

        cir.setReturnValue(MOBS_TO_MODIFY.get(type));
    }
}
