package xyz.namutree0345.powerer;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.namutree0345.powerer.features.OreGenerator;
import xyz.namutree0345.powerer.features.VillagerHandler;

public final class Powerer extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OreGenerator(), this);
        getServer().getPluginManager().registerEvents(new VillagerHandler(), this);
        System.out.println("Powerer Enabled!");
    }
}
