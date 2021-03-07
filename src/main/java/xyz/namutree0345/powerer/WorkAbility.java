package xyz.namutree0345.powerer;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class WorkAbility implements Listener {

    @EventHandler
    public void doubleJump(PlayerJumpEvent event) {
        if(event.getPlayer().isJumping()) {
            event.getPlayer().getLocation().setY(event.getPlayer().getLocation().getY() + 1);
        }
    }

}
