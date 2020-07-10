package com.github.AnedhelAulendur;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemUtil {

	@SuppressWarnings("deprecation")
	public static ItemStack getItemStackFromID(String id, int amount, int damage) {
		return new ItemStack(getMaterial(id), amount, (short) damage);
	}
	
	public static ItemStack getItemStackFromID(String id, int amount) {
		return getItemStackFromID(id, amount, 0);
	}
	
	public static Material getMaterial(String id) {
    	String name = id.toUpperCase();
        name = name.replace(":", "_");
        name = name.replace(".", "");
      
        return Material.matchMaterial(name);
    }
}
