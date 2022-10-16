package com.github.r2d2vaderbeef.regenplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class RegenPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RegenPlugin was enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RegenPlugin was disabled.");
    }
}
