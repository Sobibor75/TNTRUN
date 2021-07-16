package me.sobibor.tntrun.listener;

import com.google.common.collect.Maps;
import me.sobibor.tntrun.App;
import me.sobibor.tntrun.player.User;
import me.sobibor.tntrun.player.UserInfo;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PlayerJoinEvent implements Listener {
    private final App app;

    public PlayerJoinEvent(App app) {
        this.app = app;
    }

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        // убрал сообщения при входе на сервер
        e.setJoinMessage(null);

        Player player = e.getPlayer();

        // Добавляю игрока в мапу
        app.getUser().put(
                player.getUniqueId(),
                new User(new UserInfo(0, 0))
        );

        app.getUser().get(player.getUniqueId()).setPlayer(player);

        //добавляю игрока в список живых
        app.getLivePlayers().add(player.getUniqueId());
    }

    @EventHandler
    public void onQuit(org.bukkit.event.player.PlayerQuitEvent e) {
        e.setQuitMessage(null);

        app.getLivePlayers().remove(e.getPlayer().getUniqueId());
    }
}



