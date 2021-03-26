package me.Meatie.Project2;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(null);
		String msg = ConfigData.getMsg();
		String msg2 = ConfigData.getMsg2();
		if (!msg.equals(""))
		TitleAPI.sendTabTitle(player, format(msg), null);	
		if (!msg2.equals(""))
        	send(player, format(msg));
	}
	public static String format(String input) {
		return ChatColor.translateAlternateColorCodes('&', 
				   input.replace("(heart)", "❤").replace("(check)", "✔").replace("(music)", "♪").replace("(tempc)", "℃")
					.replace("(plane)", "✈").replace("(x)", "✘").replace("(pencil)", "✎").replace("(mail)", "✉")
					.replace("(right)", "➡").replace("(music2)", "♫").replace("(snowflake)", "❄").replace("(tempf)", "℉"));
	}
	  public static void send(Player p, String msg) {
		    String s = ChatColor.translateAlternateColorCodes('&', msg);
		    IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s + "\"}");
		    PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
		    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
		  }

}