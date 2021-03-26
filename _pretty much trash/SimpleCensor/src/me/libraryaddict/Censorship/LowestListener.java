package me.libraryaddict.Censorship;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LowestListener implements Listener {
  SimpleCensor sc;
  
  public LowestListener(SimpleCensor simpleCensor) {
    this.sc = simpleCensor;
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onChat(AsyncPlayerChatEvent event) {
    if (event.isCancelled())  return;
    if ((this.sc.enabled) /*&& (!event.getPlayer().hasPermission("censor.bypass.filter"))*/) {
      String[] message = this.sc.censorMessage(event.getMessage(), false);
      if (!this.sc.showSenderReal && !message[1].equals(message[0]) &&  event.getRecipients().contains(event.getPlayer())) {
        event.getRecipients().remove(event.getPlayer());
        event.getPlayer().sendMessage(String.format(event.getFormat(), new Object[] {event.getPlayer().getDisplayName(), MonitorListener.color(event.getPlayer(), message[1])}));
      }
      event.setMessage(message[0]);
    }
  }
}
