package me.sobibor.tntrun.state;

import me.sobibor.tntrun.App;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer extends BukkitRunnable {

    private AtomicInteger time = new AtomicInteger(0);
    private Status gameStatus;

    public Timer(App app){
        this.gameStatus = Status.WAITING;
    }

    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() >= 1)
            time.getAndIncrement();

        System.out.println(gameStatus);

       if(time.get() == gameStatus.getTime()) {
           Bukkit.getOnlinePlayers(
                   .forEach(player -> gameStatus.getConsumer().accept(App.getInstance().getUser().get(player.getUniqueId())));
;
       }
    }
}
