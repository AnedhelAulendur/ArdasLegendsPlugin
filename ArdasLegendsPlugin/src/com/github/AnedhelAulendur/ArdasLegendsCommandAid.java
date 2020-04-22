package com.github.AnedhelAulendur;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ArdasLegendsCommandAid implements CommandExecutor {

	public ArdasLegendsCommandAid(ArdasLegendsPlugin plugin) {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player)) { //checking if the command sender is a player and not the console.
			sender.sendMessage(ChatColor.RED + "The command can only be run by players!");
			return true;
		}
		else {
			Player aidingPlayer = (Player) sender; //saving sender in huntingPlayer.
			if(aidingPlayer.hasPermission("ArdasLegendsPlugin.aid")) {
				if(cmd.getName().equalsIgnoreCase("aid")) {
					if (args.length <1) { //checking if there are arguments given
						sender.sendMessage(ChatColor.RED + "To few arguments, you must enter a players IGN!");
						return true;
					}
					else if (args.length >1) { //checking if there is no more then one player given.
						sender.sendMessage(ChatColor.RED + "To many arguments, you can not aid more then one player!");
					}
					else {
						Player aidedPlayer = Bukkit.getServer().getPlayer(args[0]);
						if (aidedPlayer.isOnline()) {
							if (aidedPlayer.getDisplayName() != aidingPlayer.getDisplayName()) {
								Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[ArdasLegends]"+ ChatColor.RESET + " " + ChatColor.ITALIC + aidingPlayer.getDisplayName() + " is hunting " + aidedPlayer.getDisplayName());
								return true;
							}
							else {
								sender.sendMessage(ChatColor.RED + "You can not aid yourself");
							}
						}
						else {
							sender.sendMessage(ChatColor.RED + "That person is not an Online Player");
						}
					}			
				}
			}
			else {
				sender.sendMessage(ChatColor.RED + "You do not have the permission to aid players!");
			}
		}
		return false;
	}
}