package me.arycer.permadeath.DifficultyChanges.Day30;

import me.arycer.permadeath.Main;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;

public class LootTables {
    private static final HashMap<EntityType<?>, Identifier> MOBS_TO_MODIFY = new HashMap<>(){{
        put(EntityType.SLIME, Identifier.of(Main.MOD_ID, "empty"));
        put(EntityType.MAGMA_CUBE, Identifier.of(Main.MOD_ID, "empty"));
        put(EntityType.GHAST, Identifier.of(Main.MOD_ID, "empty"));
        put(EntityType.CAVE_SPIDER, Identifier.of("minecraft", "entities/cave_spider"));
        put(EntityType.SHULKER, Identifier.of(Main.MOD_ID, "day30/shulker"));
    }};

    public static void register(CallbackInfoReturnable<Identifier> cir, MobEntity entity) {
        EntityType<?> type = entity.getType();

        if (!MOBS_TO_MODIFY.containsKey(type)) return;

        cir.setReturnValue(MOBS_TO_MODIFY.get(type));
    }
}
