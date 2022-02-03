package com.github.l3nnartt.commands;

import com.github.l3nnartt.LennartService;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class Fly implements CommandExecutor {

    private LennartService plugin;
    public Fly(LennartService plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            System.out.println("§cDer Befehl kann nicht von der Konsole ausgeführt werden");
            return true;
        }

        Player player = (Player) commandSender;

        if (strings.length == 0) {
            setFly(player, player);
            return true;
        } else {
            Player target = Bukkit.getPlayer(strings[0]);
            if (target == null) {
                player.sendMessage("Der Spieler §6" + strings[0] + "§r ist nicht Online oder existiert nicht!");
                return true;
            }
            setFly(player, target);
        } return true;
    }

    private void setFly(Player player, Player who){
        if (player.hasMetadata("fly")) {
            if (player.getGameMode() != GameMode.CREATIVE) {
                player.removeMetadata("fly", plugin);
                if (player == who) {
                    player.sendMessage("Fly wurde §cdeaktiviert");
                } else {
                    who.sendMessage("Fly für §6" + player.getName()  + "§r wurde §cdeaktiviert");
                    player.sendMessage("Dein Fly wurde §cdeaktiviert");
                }
                player.setAllowFlight(false);
            } else {
                player.sendMessage("Fly konnte nicht deaktiviert werden");
            }
        } else {
            player.setMetadata("fly", new FixedMetadataValue(plugin, true));
            if (player == who) {
                player.sendMessage("Fly wurde §aaktiviert");
            } else {
                who.sendMessage("Fly für §6" + player.getName() + "§r wurde §aaktiviert");
                player.sendMessage("Dein Fly wurde §aaktiviert");
            }
            player.setAllowFlight(true);
        }
    }

}