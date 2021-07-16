package me.sobibor.tntrun.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * @author Рейдж 17.07.2021
 * @project TNTRUN2
 */
public class UnusedEventListener {

    // Отключил урон
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
    }

    // Отключил урон от падения
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        e.setCancelled(e.getCause() == EntityDamageEvent.DamageCause.FALL);
    }

    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
}
