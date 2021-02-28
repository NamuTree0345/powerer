package xyz.namutree0345.powerer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BuyHandlerAbility implements Listener {

    @EventHandler
    public void buyHandler(InventoryClickEvent event) {
        if(event.getView().getTitle().equals(ChatColor.GOLD + "능력 상점")) {
            if(event.getCurrentItem() != null) {
                switch (event.getCurrentItem().getType()) {
                    case RABBIT_FOOT:
                        event.getView().getPlayer().sendMessage("RRRRR");
                }
                event.setCancelled(true);
            }
        }
    }

}
