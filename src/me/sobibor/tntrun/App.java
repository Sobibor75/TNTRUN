package me.sobibor.tntrun;

import me.sobibor.tntrun.state.Timer;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        new Timer(this).runTaskTimer(this, 20, 20);

    }
}
