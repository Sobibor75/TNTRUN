package me.sobibor.tntrun;

import com.google.common.collect.Maps;
import me.sobibor.tntrun.listener.PlayerJoinEvent;
import me.sobibor.tntrun.player.User;
import me.sobibor.tntrun.state.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;

public class App extends JavaPlugin {
    private static App instance;

    private final Map<UUID, User> user = Maps.newHashMap();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(),this);
        new Timer(this).runTaskTimer(this, 20, 20);

    }

    public static App getInstance() {
        return instance;
    }

    public Map<UUID, User> getUser() {
        return user;
    }
}
