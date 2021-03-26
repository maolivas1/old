package me.Meatie.Project4.Unused;

import me.Meatie.Data.EcoData;
import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Pay {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length >= 3) {
			for (OfflinePlayer p : Bukkit.getOfflinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
			double send = Double.parseDouble(args[2]);
		if (EcoData.getMoney(player.getName()) >= send) {
			EcoData.payMoney(player.getName(), p.getName(), send);
			Commands.send(player, "&2&lSent $&7&l" + String.valueOf(send).replace(".0", "") + "&2&l To &7&l" + p.getName()); 
			for (Player pl : Bukkit.getOnlinePlayers())
				if (pl.getName().equals(p.getName()))
					Commands.send(pl, "&2&lReceved $&7&l" + String.valueOf(send).replace(".0", "") + "&2&l From &7&l" + player.getName()); 
			
		} else Commands.send(player, "&c&lInsufishent Funds"); 
	}
		} else Commands.send(player, "&c&l/pay &7&lplayer"); 
	}
}
