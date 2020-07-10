package com.github.AnedhelAulendur;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBuildmode implements CommandExecutor {
	
	public CommandBuildmode() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command can only be run by players.");
			return true;
		}
		else {
			Player builder = (Player) sender;
			if(builder.hasPermission("ArdasLegends.buildmode")) {
				if(cmd.getName().equalsIgnoreCase("buildmode")) {
					if (!ArdasLegends.buildMode.containsKey(builder)) {
						ArdasLegends.buildMode.put(builder, true);
						builder.sendMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " You have entered buildmode.");
						return true;
					}
					else {
						ArdasLegends.buildMode.remove(builder);
						builder.sendMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " You have left buildmode.");
						return true;
					}
				}
				
			}
			else {
				builder.sendMessage(ChatColor.RED + "You do not have permissions to run this command.");
				return true;
			}
		}
		return false;
	}
}
