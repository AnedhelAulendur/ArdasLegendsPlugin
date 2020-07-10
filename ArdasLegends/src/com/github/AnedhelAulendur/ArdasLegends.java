/**
 * author Anedhel | Aulendur
 */

package com.github.AnedhelAulendur;



import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import lotr.common.item.*;

@SuppressWarnings("unused")
public class ArdasLegends extends JavaPlugin {

	public static final HashMap<Player, Boolean> hunters = new HashMap<Player, Boolean>();
	public static final HashMap<Player, Boolean> hunted = new HashMap<Player, Boolean>();
	public static final HashMap<Player, String> huntDeaths = new HashMap<Player, String>();
	public static final HashMap<Player, Boolean> buildMode = new HashMap<Player, Boolean>();
	
	@Override
	public void onEnable() { //This Method will always be run, when the plugin is being enabled.
		this.getLogger().info("The ArdasLegends Plugin is running Version 0.5.1.");
		this.getCommand("hunt").setExecutor(new CommandHunt());
		this.getCommand("aid").setExecutor(new CommandAid());
		this.getCommand("bm").setExecutor(new CommandBuildmode());
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
		
		//Add Lord of the Rings Pouch Crafting Recipe.
		/**ItemUtil spouch = new ItemUtil();
		NamespacedKey key =new NamespacedKey(this, "lotr:item.pouch");
		ShapedRecipe recipe = new ShapedRecipe (key, spouch);
		recipe.shape(" L ", " S ", "LLL");
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('S', Material.STRING);
		Bukkit.addRecipe(recipe);**/
		
	}
	@Override
	public void onDisable() { //This Method will always be run, when the plugin is being disabled.
		this.getLogger().info("The ArdasLegends Plugin is now disabled.");
	}
}