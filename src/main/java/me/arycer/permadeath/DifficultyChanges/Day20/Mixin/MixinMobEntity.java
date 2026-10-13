package me.arycer.permadeath.DifficultyChanges.Day20.Mixin;

import me.arycer.permadeath.DifficultyChanges.Day20.LootTables;
import me.arycer.permadeath.Util.ModConfig;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MixinMobEntity {
    @Inject(method = "getLootTable", at = @At("RETURN"), cancellable = true)
    private void getLootTable(
            CallbackInfoReturnable<RegistryKey<LootTable>> cir) {
        if (ModConfig.getServerDay() < 20) return;

        LootTables.register(cir, (MobEntity) (Object) this);
    }
}
