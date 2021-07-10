package me.sobibor.tntrun.listener;

import me.sobibor.tntrun.App;
import me.sobibor.tntrun.player.User;
import me.sobibor.tntrun.player.UserInfo;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerJoinEvent implements Listener {
    private final App app;

    public PlayerJoinEvent(App app) {
        this.app = app;
    }

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        // Добавляю игрока в мапу
        app.getUser().put(
                e.getPlayer().getUniqueId(),
                new User(new UserInfo(0, 0))
        );

        //добавляю игрока на сервера
        app.getLivePlayers().add(e.getPlayer().getUniqueId());
        // убрал сообщения при входе нна сервер
        e.setJoinMessage(null);
    }

    //убрал урон от падения
    public void fallDamage(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
    }

    //убрал файты
    public void damageEntity(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    public void onQuit(org.bukkit.event.player.PlayerQuitEvent e) {
        app.getLivePlayers().remove(e.getPlayer().getUniqueId());
    }

    public void slimeJump(PlayerInteractEvent e) {
        if(e.getPlayer().getItemInHand().equals(Material.SLIME_BALL)) {
            e.getPlayer().getLocation().clone().add(0,4,0).multiply(1);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        //Выдаю gamemode 3 если игрок падает ниже заданной высоты
        if (e.getPlayer().getLocation().getY() <= 12 &&
                e.getPlayer().getGameMode().equals(GameMode.SPECTATOR)) {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }

    @EventHandler
    public void food(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }


}



