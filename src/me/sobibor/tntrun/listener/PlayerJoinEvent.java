package me.sobibor.tntrun.listener;

import me.sobibor.tntrun.App;
import me.sobibor.tntrun.player.User;
import me.sobibor.tntrun.player.UserInfo;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e){
        App.getInstance().getUser().put(
                e.getPlayer().getUniqueId(),
                new User(new UserInfo(0,0))
        );
    }
}
