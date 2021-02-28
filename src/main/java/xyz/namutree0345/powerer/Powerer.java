package xyz.namutree0345.powerer;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.namutree0345.powerer.features.OreGenerator;
import xyz.namutree0345.powerer.features.VillagerHandler;

import java.util.HashMap;
import java.util.UUID;

public final class Powerer extends JavaPlugin {

    public static HashMap<UUID, Abilities> abilitiesHashMap = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OreGenerator(), this);
        getServer().getPluginManager().registerEvents(new VillagerHandler(this), this);
        System.out.println("Powerer Enabled!");
    }
}
