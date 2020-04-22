/**
 * author Anedhel | Aulendur
 */

package com.github.AnedhelAulendur;



import org.bukkit.plugin.java.JavaPlugin;


public class ArdasLegendsPlugin extends JavaPlugin {
	
	private ArdasLegendsCommandHunt huntExecutor;
	private ArdasLegendsCommandAid aidExecutor;
	@Override
	public void onEnable() { //This Method will always be run, when the plugin is being enabled.
		this.getLogger().info("The ArdasLegends Plugin is running Version 0.3.");
		huntExecutor = new ArdasLegendsCommandHunt(this);
		getCommand("hunt").setExecutor(huntExecutor);
		aidExecutor = new ArdasLegendsCommandAid(this);
		getCommand("aid").setExecutor(aidExecutor);
	}
	@Override
	public void onDisable() { //This Method will always be run, when the plugin is being disabled.
		this.getLogger().info("The ArdasLegends Plugin is now disabled.");
	}
}