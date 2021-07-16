package me.sobibor.tntrun.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author Рейдж 17.07.2021
 * @project TNTRUN2
 */
public class PlayerMoveEvent implements Listener {

    @EventHandler
    public void onMove(org.bukkit.event.player.PlayerMoveEvent e) {
        Player player = e.getPlayer();

        //Выдаю gamemode 3 если игрок падает ниже заданной высоты
        if (player.getLocation().getY() <= 12 &&
                player.getGameMode().equals(GameMode.SPECTATOR))
            player.setGameMode(GameMode.SPECTATOR);
    }
}
