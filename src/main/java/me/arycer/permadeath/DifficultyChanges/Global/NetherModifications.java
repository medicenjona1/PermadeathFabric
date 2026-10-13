package me.arycer.permadeath.DifficultyChanges.Global;

import me.arycer.permadeath.Main;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class NetherModifications {
    private static final RegistryKey<PlacedFeature> LARGE_DEBRIS = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("minecraft", "ore_ancient_debris_large"));
    private static final RegistryKey<PlacedFeature> SMALL_DEBRIS = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("minecraft", "ore_debris_small"));

    private static void modifyWorldGen() {
        BiomeModifications.create(Identifier.of(Main.MOD_ID, "no_netherite"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.foundInTheNether(), ctx -> {
                    ctx.getGenerationSettings().removeFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, LARGE_DEBRIS);
                    ctx.getGenerationSettings().removeFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, SMALL_DEBRIS);
                    ctx.getGenerationSettings().removeFeature(GenerationStep.Feature.UNDERGROUND_ORES, LARGE_DEBRIS);
                    ctx.getGenerationSettings().removeFeature(GenerationStep.Feature.UNDERGROUND_ORES, SMALL_DEBRIS);
                });
    }

    private static final Identifier HOGLIN_STABLE = Identifier.of("minecraft", "chests/bastion_hoglin_stable");
    private static final Identifier BASTION_TREASURE = Identifier.of("minecraft", "chests/bastion_treasure");
    private static final Identifier BASTION_OTHER = Identifier.of("minecraft", "chests/bastion_other");

    private static final Identifier MODIFIED_HOGLIN_STABLE = Identifier.of(Main.MOD_ID, "nether_modifications/bastion_hoglin_stable");
    private static final Identifier MODIFIED_BASTION_TREASURE = Identifier.of(Main.MOD_ID, "nether_modifications/bastion_treasure");
    private static final Identifier MODIFIED_BASTION_OTHER = Identifier.of(Main.MOD_ID, "nether_modifications/bastion_other");

    
    private static void modifyLootTables() {
        LootTableEvents.REPLACE.register((key, original, source) -> {
            if (key.getValue().equals(HOGLIN_STABLE)) {
                return original;
            } else if (key.getValue().equals(BASTION_TREASURE)) {
                return original;
            } else if (key.getValue().equals(BASTION_OTHER)) {
                return original;
        }

        return null;
    });
}


    public static void register() {
        modifyWorldGen();
        modifyLootTables();
    }
}