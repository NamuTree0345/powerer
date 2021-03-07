package xyz.namutree0345.powerer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class WorkAbility implements Listener {

    @EventHandler
    public void doubleJump(PlayerToggleSneakEvent event) {
        if(event.getPlayer().isSprinting() && event.getPlayer().isJumping()) {
            event.getPlayer().getLocation().setY(event.getPlayer().getLocation().getY() + 1);
        }
    }

}
