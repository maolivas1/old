package me.libraryaddict.Censorship;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MonitorListener implements Listener {
  SimpleCensor sc;
  
  public MonitorListener(SimpleCensor simpleCensor) {
    this.sc = simpleCensor;
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onChat(AsyncPlayerChatEvent event) {
    if (event.isCancelled()) return;
    if ((this.sc.enabled) /*&& (!event.getPlayer().hasPermission("censor.bypass.filter"))*/) {
      String[] message = this.sc.censorMessage(event.getMessage(), false);
      if ((!this.sc.showSenderReal) && (!message[1].equals(message[0])) && (event.getRecipients().contains(event.getPlayer()))) {
        event.getRecipients().remove(event.getPlayer());
        event.getPlayer().sendMessage(String.format(event.getFormat(), new Object[] {event.getPlayer().getDisplayName(), color(event.getPlayer(), message[1])}));
      }
      event.setMessage(message[0]);
    }
  }
  
  public static String color(Player player, String msg) {
	  if (!msg.contains("&")) return msg;
	  
	  if (msg.contains("&0"))
		  if (player.hasPermission("censor.color.black") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&0", "" + ChatColor.BLACK);
	  
	  if (msg.contains("&1"))
		  if (player.hasPermission("censor.color.darkblue") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&1", "" + ChatColor.DARK_BLUE);
	  
	  if (msg.contains("&2"))
		  if (player.hasPermission("censor.color.darkgreen") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&2", "" + ChatColor.DARK_GREEN);
	  
	  if (msg.contains("&3"))
		  if (player.hasPermission("censor.color.darkaqua") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&3", "" + ChatColor.DARK_AQUA);
	  
	  if (msg.contains("&4"))
		  if (player.hasPermission("censor.color.darkred") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&4", "" + ChatColor.DARK_RED);
	  
	  if (msg.contains("&5"))
		  if (player.hasPermission("censor.color.darkpurple") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&5", "" + ChatColor.DARK_PURPLE);
	  
	  if (msg.contains("&6"))
		  if (player.hasPermission("censor.color.gold") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&6", "" + ChatColor.GOLD);
	  
	  if (msg.contains("&7"))
		  if (player.hasPermission("censor.color.gray") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&7", "" + ChatColor.GRAY);
	  
	  if (msg.contains("&8"))
		  if (player.hasPermission("censor.color.darkgray") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&8", "" + ChatColor.DARK_GRAY);
	  
	  if (msg.contains("&9"))
		  if (player.hasPermission("censor.color.blue") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&9", "" + ChatColor.BLUE);
	  
	  if (msg.contains("&a"))
		  if (player.hasPermission("censor.color.green") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&a", "" + ChatColor.GREEN);
	  
	  if (msg.contains("&b"))
		  if (player.hasPermission("censor.color.aqua") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&b", "" + ChatColor.AQUA);
	  
	  if (msg.contains("&c"))
		  if (player.hasPermission("censor.color.red") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&c", "" + ChatColor.RED);
	  
	  if (msg.contains("&d"))
		  if (player.hasPermission("censor.color.lightpurple") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&d", "" + ChatColor.LIGHT_PURPLE);
	  
	  if (msg.contains("&e"))
		  if (player.hasPermission("censor.color.yellow") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&e", "" + ChatColor.YELLOW);
	  
	  if (msg.contains("&f"))
		  if (player.hasPermission("censor.color.white") || player.hasPermission("censor.color.*"))
			  msg = msg.replace("&f", "" + ChatColor.WHITE);
	  
	  if (msg.contains("&k"))
		  if (player.hasPermission("censor.format.magic") || player.hasPermission("censor.format.*"))
			  msg = msg.replace("&k", "" + ChatColor.MAGIC);
	  
	  if (msg.contains("&l"))
		  if (player.hasPermission("censor.format.bold") || player.hasPermission("censor.format.*"))
			  msg = msg.replace("&l", "" + ChatColor.BOLD);
	  
	  if (msg.contains("&m"))
		  if (player.hasPermission("censor.format.strike") || player.hasPermission("censor.format.*"))
			  msg = msg.replace("&m", "" + ChatColor.STRIKETHROUGH);
	  
	  if (msg.contains("&n"))
		  if (player.hasPermission("censor.format.underline") || player.hasPermission("censor.format.*"))
			  msg = msg.replace("&n", "" + ChatColor.UNDERLINE);
	  
	  if (msg.contains("&o"))
		  if (player.hasPermission("censor.format.italic") || player.hasPermission("censor.format.*"))
			  msg = msg.replace("&o", "" + ChatColor.ITALIC);
	  
	  if (msg.contains("&r"))
		  if (player.hasPermission("censor.format.reset") || player.hasPermission("censor.format.*"))
			  msg = msg.replace("&r", "" + ChatColor.RESET);
	  
	return msg;
  }
  
  
}