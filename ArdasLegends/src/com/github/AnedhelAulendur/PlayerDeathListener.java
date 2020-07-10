package com.github.AnedhelAulendur;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener{
	
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player rip = ((Player) event).getPlayer();
		//Start of the function for Command Hunt and Command Aid
		if (ArdasLegends.hunters.containsKey(rip)) {
			/**if (ArdasLegends.hunters.get(rip) == true) {
				Bukkit.broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + rip + " has died, he may no longer return to this hunt.");
			}
			else if(ArdasLegends.hunters.get(rip) == false) {
				Bukkit.broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + rip + " has died, he may not return to this hunt.");
			}**/
			Bukkit.broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + rip + " has died, he may not return to this hunt.");
			ArdasLegends.huntDeaths.put(rip, "Hunter");
			ArdasLegends.hunters.remove(rip);
		}
		else if(ArdasLegends.hunted.containsKey(rip)) {
			Bukkit.broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + " " + rip + " has died, he may not return to this hunt.");
			ArdasLegends.huntDeaths.put(rip, "Hunted");
			ArdasLegends.hunted.remove(rip);
		}
		if (ArdasLegends.hunted.size() == 0) {
			Bukkit.broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + "The hunt is over, the Hunters win.");
			ArdasLegends.hunters.clear();
			ArdasLegends.huntDeaths.clear();
		}
		else if (ArdasLegends.hunters.size() == 0) {
			Bukkit.broadcastMessage(ChatColor.GOLD + "[ArdasLegends]" + ChatColor.RESET + "The hunt is over the Hunted win.");
			ArdasLegends.hunted.clear();
			ArdasLegends.huntDeaths.clear();
		}
		//The end for the Hunt/Aid function
	}
}
