package me.Mark.BetterMobs;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	
	
	public void onEnable() {
	if (Config.get("player-drop-head") == null) Config.set("player-drop-head", "true");
	if (Config.get("zombie-wear-head") == null) Config.set("zombie-wear-head", "true");
	if (Config.get("skeleton-wear-head") == null) Config.set("skeleton-wear-head", "true");
	if (Config.get("PigZombie-wear-head") == null) Config.set("pigZombie-wear-head", "true");
	if (Config.get("online-only") == null) Config.set("online-only", "false");
	if (Config.get("color-sheep") == null) Config.set("color-sheep", "true");
	if (Config.get("pig-sattle.chance") == null) Config.set("pig-sattle.chance", "50");
	if (Config.get("horse-tamed-chance") == null) Config.set("horse-tamed-chance", "50");
	if (Config.get("horse-saddle-chance") == null) Config.set("horse-saddle-chance", "50");
	if (Config.get("horse-chest-chance") == null) Config.set("horse-chest-chance", "50");
	
	
	}
	
}
