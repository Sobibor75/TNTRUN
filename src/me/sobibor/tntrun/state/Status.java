package me.sobibor.tntrun.state;

import me.sobibor.tntrun.App;
import me.sobibor.tntrun.player.User;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;

import java.util.function.Consumer;

public enum Status {
    WAITING("Ожидание", 10, null),
    GAME("Игра", 300, user -> {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(App.getInstance(), () ->
                Bukkit.getOnlinePlayers().stream()
                        .filter(player -> !player.getGameMode().equals(GameMode.SPECTATOR))
                        .forEach(player -> player.getLocation().subtract(0, 1, 0)
                                .getBlock().setType(Material.AIR)), 20, 20);
    }),
    END("Конец", 310, user -> {

    });

    private final String name;
    private final int time;
    private final Consumer<User> consumer;


    Status(String name, int time, Consumer<User> consumer) {
        this.name = name;
        this.time = time;
        this.consumer = consumer;
    }

    public Consumer<User> getConsumer() {
        return consumer;
    }

    public int getTime() {
        return time;
    }

    public Status getNext() {
        return ordinal() >= Status.values().length - 1 ? null : Status.values()[ordinal() + 1];
    }

    public String getName() {
        return name;
    }
}
