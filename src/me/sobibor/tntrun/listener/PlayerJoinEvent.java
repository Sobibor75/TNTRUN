package me.sobibor.tntrun.listener;

import me.sobibor.tntrun.App;
import me.sobibor.tntrun.player.User;
import me.sobibor.tntrun.player.UserInfo;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerJoinEvent implements Listener {



    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        // Добавляю игрока в мапу
        App.getInstance().getUser().put(
                e.getPlayer().getUniqueId(),
                new User(new UserInfo(0, 0))
        );
    }



    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().getLocation().getY() <= 12) {
                e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        if(e.getPlayer().getLocation().getY() <= 12 &&
                e.getPlayer().getGameMode().equals(GameMode.SPECTATOR)){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        }
        }



