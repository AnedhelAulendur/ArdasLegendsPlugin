package com.github.AnedhelAulendur;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandHunt implements CommandExecutor {

	public CommandHunt() {
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player)) { //checking if the command sender is a player and not the console.
			sender.sendMessage(ChatColor.RED + "The command can only be run by players!");
			return true;
		}
		else {
			Player huntingPlayer = (Player) sender; //saving sender in huntingPlayer.
			if(huntingPlayer.hasPermission("ArdasLegends.hunt")) {
				if(cmd.getName().equalsIgnoreCase("hunt")) {
					if (args[0] == "stop" && ArdasLegends.hunters.get(huntingPlayer) == true) {
						Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + huntingPlayer + " has surrendered the hunt. The hunted win.");
						ArdasLegends.huntDeaths.clear();
						ArdasLegends.hunters.clear();
						ArdasLegends.hunted.clear();
					}
					else if (args[0] == "stop" && sender.hasPermission("ArdasLegends.huntstop")) {
						Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + sender + " has stopped the hunt.");
						ArdasLegends.huntDeaths.clear();
						ArdasLegends.hunters.clear();
						ArdasLegends.hunted.clear();
					}
					else if (args.length <1) { //checking if there are arguments given
						sender.sendMessage(ChatColor.RED + "To few arguments, you must enter a players IGN!");
						return true;
					}
					else if (args.length >1) { //checking if there is no more then one player given.
						sender.sendMessage(ChatColor.RED + "To many arguments, you can not hunt more then one player!");
					}
					else {
						Player huntedPlayer = Bukkit.getServer().getPlayer(args[0]);
						if (huntedPlayer.isOnline()) { //check if the hunted player is online.
							if (huntedPlayer.getDisplayName() != huntingPlayer.getDisplayName()) { //check if you are hunting yourself.
								if (!ArdasLegends.huntDeaths.containsKey(huntingPlayer)) { //check if the player has already taken part in the running hunt.
									if (ArdasLegends.hunted.containsKey(huntingPlayer)) { //check if the player is taking part in the running hunted.
										sender.sendMessage(ChatColor.RED + "You already are part of the running hunt.");
									}
									else if (ArdasLegends.hunters.containsKey(huntingPlayer)) { //check if the player is taking part in the running hunt as hunter.
										sender.sendMessage(ChatColor.RED + "You already are part of the running hunt.");
									}
									else {
										if (ArdasLegends.hunted.containsKey(huntedPlayer)) { //check if the player is trying to hunt a participant of the hunt.
											sender.sendMessage(ChatColor.RED + "You can not hunt someone who is participating in a hunt.");
										}
										else if (ArdasLegends.hunters.containsKey(huntedPlayer)) { //check if the player is trying to hunt a participant of the hunt.
											sender.sendMessage(ChatColor.RED + "You can not hunt someone who is participating in a hunt.");
										}
										else {
											if (ArdasLegends.huntDeaths.containsKey(huntedPlayer)) { //check if the player wants to hunt someone, who has died during the hunt.
												sender.sendMessage(ChatColor.RED + "You can not hunt this player, he already has died during the running hunt.");
											}
											else {
												Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + huntingPlayer.getDisplayName() + " is hunting " + huntedPlayer.getDisplayName());
												ArdasLegends.hunters.put(huntingPlayer, true);
												ArdasLegends.hunted.put(huntedPlayer, true);
												return true;
											}
										}
									}
								}
								else {
									sender.sendMessage(ChatColor.RED + "You already died during this hunt, you can no longer participate in it.");
								}
							}
							else {
								sender.sendMessage(ChatColor.RED + "You can not hunt yourself");
							}
						}
						else {
							sender.sendMessage(ChatColor.RED + "That person is not an Online Player");
						}
					}			
				}
			}
			else {
				sender.sendMessage(ChatColor.RED + "You do not have the permission to hunt players!");
			}
		}
		return false;
	}
}