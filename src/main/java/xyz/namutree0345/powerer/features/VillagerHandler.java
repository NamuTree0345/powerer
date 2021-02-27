package xyz.namutree0345.powerer.features;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class VillagerHandler implements Listener {

    @EventHandler
    public void villagerDamage(EntityDamageByEntityEvent event) {
        if(event.getEntityType() == EntityType.VILLAGER) {
            event.setCancelled(true);
        }
    }

}
