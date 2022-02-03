package com.github.l3nnartt.commands;

import com.github.l3nnartt.listener.PlayerListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Build implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            System.out.println("§cDer Befehl kann nicht von der Konsole ausgeführt werden");
            return true;
        }

        Player player = (Player) commandSender;

        if(!player.hasPermission("build")){
            player.sendMessage("Unzureichende Rechte!");
            return true;
        } else {
            PlayerListener.build = ! PlayerListener.build;
            player.sendMessage("Baumodus: " + PlayerListener.build);
        } return true;
    }

}