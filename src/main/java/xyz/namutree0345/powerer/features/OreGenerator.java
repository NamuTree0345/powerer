package xyz.namutree0345.powerer.features;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OreGenerator implements Listener {

    @EventHandler
    public void onBreakABlock(BlockBreakEvent event) {
        if(checkXyzBlock(event.getBlock().getLocation(), -30, 70, -1)) {
            pl(event, Material.LAPIS_LAZULI);
        }
        if(checkXyzBlock(event.getBlock().getLocation(), 0, 70, -14)) {
            pl(event, Material.COAL);
        }
        if(checkXyzBlock(event.getBlock().getLocation(), 23, 70, -14)) {
            pl(event, Material.IRON_ORE);
        }
        if(checkXyzBlock(event.getBlock().getLocation(), 73, 69, 3)) {
            pl(event, Material.DIAMOND);
        }
        if(checkXyzBlock(event.getBlock().getLocation(), 99, 69, 3)) {
            pl(event, Material.OBSIDIAN);
        }

    }

    private void pl(BlockBreakEvent event, Material material) {
        event.setCancelled(true);
        event.getPlayer().getInventory().addItem(new ItemStack(material));
    }

    private boolean checkXyzBlock(Location location, int x, int y, int z) {
        if(location.getBlockX() == x && location.getBlockY() == y && location.getBlockZ() == z) {
            return true;
        }
        return false;
    }

}
