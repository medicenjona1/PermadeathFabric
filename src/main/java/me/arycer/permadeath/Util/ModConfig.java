package me.arycer.permadeath.Util;

import dev.isxander.yacl3.config.ConfigEntry;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.config.v2.impl.serializer.GsonConfigSerializer;
import me.arycer.permadeath.Main;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;


public class ModConfig {
    public static final ConfigClassHandler<ModConfig> HANDLER =
            ConfigClassHandler.createBuilder(ModConfig.class)
                    .id(Identifier.of("permadeath", "config"))
                    .serializer(config ->
                            GsonConfigSerializerBuilder.create(config)
                                    .setPath(FabricLoader.getInstance()
                                            .getConfigDir()
                                            .resolve("permadeath.json5"))
                                    .setJson5(true)
                                    .build())
                    .build();
        
  
  
    /* public ModConfig() {
        super(ConfigOptions
                .mod(Main.MOD_ID)
                .fileHeader("Permadeath Config")
        );
    }

    public static void reload () {
        Main.config.save();
        Main.config.load();
    } */ 
    public static ModConfig get() {
        return HANDLER.instance();
    }

    @SerialEntry 
    public long CREATION_TIME = System.currentTimeMillis();

    @SerialEntry 
    public boolean BAN_ON_DEATH = true;

    @SerialEntry 
    public boolean OP_BAN_IMMUNITY = true;

    public static void load() {
        HANDLER.load();
    }

    public static void save() {
        HANDLER.save();
    }


    public static int getServerDay() {
        long epoch = System.currentTimeMillis() - get().CREATION_TIME;
        int day = (int) (epoch / 86400000);
        return day + 1;
    }

    public static boolean getBanOnDeath () {
        return get().BAN_ON_DEATH;
    }

    public static boolean getOpBanImmunity () {
        return get().OP_BAN_IMMUNITY;
    }

    public static void setServerDay (int day) {
        get().CREATION_TIME = System.currentTimeMillis() - ((long) (day - 1) * 24 * 60 * 60 * 1000);
        save();
    }

    public static void setBanOnDeath (boolean ban) {
        get().BAN_ON_DEATH = ban;
        save();
    }

    public static void setOpBanImmunity (boolean opImmunity) {
        get().OP_BAN_IMMUNITY = opImmunity;
        save();
    }
}