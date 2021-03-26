package me.Meatie.myworld;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PerWorld implements Listener {
  
  @EventHandler
  public void list(PlayerChangedWorldEvent event) {
	  update(event.getPlayer());
  }
  
  @SuppressWarnings("deprecation")
public void update(Player player) {
	  for (Player p : Bukkit.getOnlinePlayers()) {
		  if (p.getWorld().equals(player.getWorld())) {
			  p.showPlayer(player);
	          player.showPlayer(p);  
		  } else {
			  p.hidePlayer(player);
	          player.hidePlayer(p);
		  }
	  }
  }
  
  @EventHandler()
  public void join(PlayerJoinEvent event) {
    event.setJoinMessage(null);
    Player player = event.getPlayer();
	  update(player);
      for (Player p : player.getWorld().getPlayers())
		if (p != player)
			Commands.sendmsg(player, Fix.login.replace("$player", player.getName()));
  }
  
  @EventHandler()
  public void leave(PlayerQuitEvent event) {
    event.setQuitMessage(null);
    Player player = event.getPlayer();
    for (Player p : player.getWorld().getPlayers())
		if (p != player)
			Commands.sendmsg(player, Fix.leave.replace("$player", player.getName()));
  }
  
  @EventHandler()
  public void death(PlayerDeathEvent event) {
	  for (Player p : event.getEntity().getWorld().getPlayers())
		  p.sendMessage(event.getDeathMessage());
    event.setDeathMessage(null);
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void chat(AsyncPlayerChatEvent event) {
	  Player player = event.getPlayer();
	  event.setFormat(player.getName() + ": " + event.getMessage());
	  for (Player p : Bukkit.getOnlinePlayers())
	  if (!p.getWorld().equals(player.getWorld()))
		  event.getRecipients().remove(p);
  }
  


}
