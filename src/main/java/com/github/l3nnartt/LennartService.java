package com.github.l3nnartt;

import com.github.l3nnartt.commands.Build;
import com.github.l3nnartt.commands.Fly;
import com.github.l3nnartt.listener.PlayerJoin;
import com.github.l3nnartt.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LennartService extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin enabled");
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        getCommand("build").setExecutor(new Build());
        getCommand("fly").setExecutor(new Fly(this));
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {

    }

}