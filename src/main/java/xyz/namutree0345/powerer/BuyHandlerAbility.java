package xyz.namutree0345.powerer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BuyHandlerAbility implements Listener {

    @EventHandler
    public void buyHandler(InventoryClickEvent event) {
        if(event.getView().getTitle().equals(ChatColor.GOLD + "능력 상점")) {
            if(event.getCurrentItem() != null) {
                switch (event.getCurrentItem().getType()) {
                    case RABBIT_FOOT:
                        if(event.getView().getPlayer().getInventory().contains(Material.DIAMOND_BLOCK, 10)) {
                            ItemStack[] contents = event.getView().getPlayer().getInventory().getContents();
                            for (int i = 0; i < contents.length; i++) {
                                if(contents[i].getType() == Material.DIAMOND_BLOCK) {
                                    if(contents[i].getAmount() == 10) {
                                        event.getView().getPlayer().getInventory().remove(Material.DIAMOND_BLOCK);
                                        break;
                                    }
                                    if(contents[i].getAmount() > 10) {
                                        contents[i].setAmount(contents[i].getAmount() - 10);
                                        break;
                                    }
                                }
                            }
                            if(!Powerer.abilitiesHashMap.containsKey(event.getView().getPlayer().getUniqueId())) {
                                Abilities ab = new Abilities();
                                ab.abilities.add("doublejump");
                                Powerer.abilitiesHashMap.put(event.getView().getPlayer().getUniqueId(), ab);
                            } else {
                                if(Powerer.abilitiesHashMap.get(event.getView().getPlayer().getUniqueId()).abilities.contains("doublejump")) {
                                    event.getView().getPlayer().sendMessage(ChatColor.RED + "이미 스킬이 있습니다!");
                                    return;
                                }
                                Abilities ab = Powerer.abilitiesHashMap.get(event.getView().getPlayer().getUniqueId());
                                ab.abilities.add("doublejump");
                                Powerer.abilitiesHashMap.replace(event.getView().getPlayer().getUniqueId(), ab);
                            }
                            event.getView().getPlayer().sendMessage(ChatColor.GREEN + "구입되었습니다!");
                        }
                        break;
                }
                event.setCancelled(true);
            }
        }
    }

}
