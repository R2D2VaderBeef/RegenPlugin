package com.github.r2d2vaderbeef.regenplugin;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RegenPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("RegenPlugin was enabled! Ree!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("RegenPlugin was disabled.");
    }

    @EventHandler
    public void onRegen(EntityRegainHealthEvent event) {
        String type = event.getEntityType().toString();
        if (Objects.equals(type, "PLAYER")) {
            HumanEntity player = (HumanEntity) event.getEntity();
            getLogger().info("Player " + player.getName() + " is trying to regen!");

            EntityRegainHealthEvent.RegainReason reason = event.getRegainReason();
            if (Objects.equals(reason.toString(), "EATING") || Objects.equals(reason.toString(), "SATIATED")) {

                float saturation = player.getFoodLevel();

                if (saturation >= 20) {
                    getLogger().info("Player " + player.getName() + " has full food, allowing regen.");
                } else if (player.isSleeping()) {
                    getLogger().info("Player " + player.getName() + " is sleeping in a bed, allowing regen.");
                } else {
                    getLogger().info("Player " + player.getName() + " has a food level of " + saturation + " and is not sleeping, cancelling regen.");
                    event.setCancelled(true);
                }
            }
        }
    }
}
