package xyz.namutree0345.powerer.features;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.awt.print.Book;
import java.util.ArrayList;

public class VillagerHandler implements Listener {

    public boolean hanulsumjumin1 = false;
    public JavaPlugin plugin;

    @EventHandler
    public void villagerDamage(EntityDamageByEntityEvent event) {
        if(event.getEntityType() == EntityType.VILLAGER) {
            event.setCancelled(true);
        }
    }

    public VillagerHandler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void boat(org.bukkit.event.vehicle.VehicleCreateEvent event) {
        if(event.getVehicle().getType() == EntityType.BOAT) {
            event.setCancelled(true);
        }
        if(event.getVehicle().getType() == EntityType.MINECART) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void entityInteract(PlayerInteractAtEntityEvent event) {
        if(!hanulsumjumin1) {
            if(event.getRightClicked().getCustomName().equals("하늘섬 주민")) {
                event.setCancelled(true);
                hanulsumjumin1 = true;
                for (Player plr :
                        Bukkit.getOnlinePlayers()) {
                    plr.sendMessage(ChatColor.GOLD + "<하늘섬 주민> " + ChatColor.RESET + "오홍홍. 안녕하세요.");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                            BookMeta bm = (BookMeta) book.getItemMeta();
                            bm.setAuthor("하늘섬 이장");
                            bm.setTitle("하늘섬에서 살아남기");
                            bm.addPages(Component.text("일단 조약돌 생성기를 만드세요.\n그 다음에 여러 광물을 캐세요.\n광물은 무제한으로 계속 생성됩니다.\n광물을 캐서 엔드 요새에 가세요."),
                                    Component.text("엔드 주민에게 바치라는것을 바치세요.\n상점에서 사야되는것도 있습니다.\n그다음에 엔드 주민에게 받은 엔드 진주와\n블레이즈 막대를 조합해 엔더 월드에 가세요.\n엔더드래곤을 잡은 사람은"),
                                    Component.text("매우 좋은 일이 있을거에요!\n그러면 희망을 빕니다."));
                            book.setItemMeta(bm);

                            plr.getInventory().addItem(book);

                            plr.sendMessage(ChatColor.GOLD + "<하늘섬 주민> " + ChatColor.RESET + "처음 오신것 같은데, 가이드 북을 드릴게용. 안받으신분은 저를 우클릭해서 받으세용.");
                            hanulsumjumin1 = false;
                        }
                    }, 1000);
                }
            }
        }
    }

}
