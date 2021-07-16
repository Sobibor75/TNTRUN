package me.sobibor.tntrun;

import com.google.common.collect.Maps;
import me.sobibor.tntrun.listener.PlayerInteractEvent;
import me.sobibor.tntrun.listener.PlayerJoinEvent;
import me.sobibor.tntrun.listener.PlayerMoveEvent;
import me.sobibor.tntrun.listener.UnusedEventListener;
import me.sobibor.tntrun.player.User;
import me.sobibor.tntrun.state.Status;
import me.sobibor.tntrun.state.Timer;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class App extends JavaPlugin {
    private static App instance;

    private final Map<UUID, User> user = Maps.newHashMap();
    private final ArrayList<UUID> livePlayers = new ArrayList<>();
    private Status status;

    @Override
    public void onEnable() {
        instance = this;

        // Регистрация листенеров
        Arrays.asList(
                new PlayerJoinEvent(this),
                new PlayerInteractEvent(),
                new PlayerMoveEvent(),
                new UnusedEventListener()
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents((Listener) listener, this));

        // Ставлю статус ожидания игры
        setStatus(Status.WAITING);

        // Регистрация игрового таймера
        new Timer(this).runTaskTimer(this, 20, 20);
    }

    public static App getInstance() {
        return instance;
    }

    public Map<UUID, User> getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<UUID> getLivePlayers() {
        return livePlayers;
    }
}
