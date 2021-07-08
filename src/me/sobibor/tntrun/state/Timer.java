package me.sobibor.tntrun.state;

import me.sobibor.tntrun.App;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class Timer extends BukkitRunnable {

    private final AtomicInteger time = new AtomicInteger(0);
    private final App app;


    public Timer(App app) {
        this.app = app;
    }



    @Override
    public void run() {
        // Если игрок >= 1, то увеличиваем игровой таймер.
        if (Bukkit.getOnlinePlayers().size() >= 1)
            time.getAndIncrement();

        // Когда игровой таймер == таймеру со статуса, то переключаем режим.
        if (time.get() == app.getStatus().getTime()) {
            app.setStatus(app.getStatus().getNext());

            // Перебирает всех онлайн игроков и проводит действия с ними.
            Bukkit.getOnlinePlayers()
                    .forEach(player -> {
                        if (app.getStatus().getConsumer() != null)
                            app.getStatus().getConsumer().accept(app.getUser().get(player.getUniqueId()));
                    });
        }

        if(app.getLivePlayers().size() == 1) {
           app.getLivePlayers().stream().forEach(uuid ->{app.getUser().get(uuid);});
            {
                
            }

        }
    }

}

