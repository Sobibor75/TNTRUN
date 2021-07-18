package me.sobibor.tntrun.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author Рейдж 17.07.2021
 * @project TNTRUN2
 */
public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getItemInHand().getType().equals(Material.SLIME_BALL))
            player.getLocation().clone().add(0, 4, 0).multiply(1);

        if (DelaUtil.hasCountdown(Material.SLIME_BALL)) {
            player.sendMessage("до следующего использавания осталось ") +
                    DelaUtil.getSecondsLeft(Material.SLIME_BALL) + "секундю";
        }
    }
    }

