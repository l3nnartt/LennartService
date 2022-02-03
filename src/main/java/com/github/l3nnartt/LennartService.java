package com.github.l3nnartt;

import com.github.l3nnartt.commands.Build;
import com.github.l3nnartt.commands.Fly;
import com.github.l3nnartt.listener.PlayerJoin;
import com.github.l3nnartt.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LennartService extends JavaPlugin {

    private PlayerListener playerListener;

    @Override
    public void onEnable() {
        playerListener = new PlayerListener();
        System.out.println("Plugin enabled");
        Bukkit.getPluginManager().registerEvents(playerListener, this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        getCommand("build").setExecutor(new Build(this));
        getCommand("fly").setExecutor(new Fly(this));
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onDisable() {

    }

    public PlayerListener getPlayerListener() {
        return playerListener;
    }

}