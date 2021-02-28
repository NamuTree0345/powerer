package xyz.namutree0345.powerer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class AbilityShopGui {

    public ItemStack blankItem(Material mat) {
        ItemStack stack = new ItemStack(mat);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.RED + " ");
        stack.setItemMeta(meta);
        return stack;
    }

    public ItemStack newItem(Material mat, String name, ArrayList<String> lore) {
        ItemStack stack = new ItemStack(mat);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    public ArrayList<String> listOf(String... e) {
        ArrayList<String> al = new ArrayList<>(Arrays.asList(e));
        return al;
    }

    public void open(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GOLD + "능력 상점");
        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, blankItem(Material.BLUE_STAINED_GLASS_PANE));
        }
        inventory.setItem(20, newItem(Material.RABBIT_FOOT, ChatColor.GOLD + "토끼 점프", listOf("더블 점프를 추가해줍니다. 더 높이 뛸 수 있습니다.")));
        inventory.setItem(22, newItem(Material.SPIDER_EYE, ChatColor.GOLD + "거미줄", listOf("벽을 탈 수 있습니다.")));
        inventory.setItem(24, newItem(Material.PACKED_ICE, ChatColor.GOLD + "차가운 얼음", listOf("몹을 얼릴 수 있습니다. (움직이지 못하게 하는것)")));
        inventory.setItem(30, newItem(Material.ZOMBIE_HEAD, ChatColor.GOLD + "불사의 좀비", listOf("연속 2번 살아날 수 있습니다.")));
        inventory.setItem(32, newItem(Material.REDSTONE, ChatColor.GOLD + "헐크", listOf("돌을 부술때 부순 돌의 양이 2배가 되고 공격력이 2배가 됩니다.")));
        for (int i = 45; i < 54; i++) {
            inventory.setItem(i, blankItem(Material.BLUE_STAINED_GLASS_PANE));
        }
        player.openInventory(inventory);
    }

}
