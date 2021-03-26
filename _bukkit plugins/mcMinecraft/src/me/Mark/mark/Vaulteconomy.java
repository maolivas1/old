package me.Mark.mark;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.earth2me.essentials.Essentials;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;

public class Vaulteconomy {
	
	static Economy economy;
	public static Essentials ess;
	
	public static void load() {
	if(Bukkit.getServer().getPluginManager().getPlugin("Vault") instanceof Vault) {
	    RegisteredServiceProvider<Economy> service = Bukkit.getServicesManager().getRegistration(Economy.class);
	    if(service != null)
	    economy = service.getProvider();
	}
	
	Plugin plugin_es = Bukkit.getPluginManager().getPlugin("Essentials");
    if(plugin_es instanceof Essentials)
       ess = (Essentials) plugin_es;
	
	
	}
}
