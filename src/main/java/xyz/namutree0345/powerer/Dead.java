package xyz.namutree0345.powerer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class Dead implements Listener {
    @EventHandler
    public void onDead(PlayerDeathEvent event) {
        event.getEntity().setGameMode(GameMode.SPECTATOR);
        event.getEntity().sendTitle(ChatColor.RED + "죽었습니다!", "3초 뒤 리스폰됩니다.", 5, 60, 5);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Powerer.getPlugin(Powerer.class), new Runnable() {
                    @Override
                    public void run() {
                        event.getEntity().teleport(Objects.requireNonNull(event.getEntity().getBedSpawnLocation()));
                        event.getEntity().sendTitle(ChatColor.GOLD + "리스폰!", "", 5, 60, 5);
                    }
                }, 60L);
    }
}
