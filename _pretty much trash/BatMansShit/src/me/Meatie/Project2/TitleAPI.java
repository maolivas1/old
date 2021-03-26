package me.Meatie.Project2;

import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

//TitleAPI.sendTitle(player, 5, 40, 5, format("&9&lWelcome"), format("&9&lTo The Server"));

public class TitleAPI extends JavaPlugin implements Listener {
	
  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
    sendTitle(player, fadeIn, stay, fadeOut, message, null);
  }
  
  public static void sendSubtitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
    sendTitle(player, fadeIn, stay, fadeOut, null, message);
  }
  
  public static void sendFullTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
    sendTitle(player, fadeIn, stay, fadeOut, title, subtitle);
  }
  
  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
    
    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
    connection.sendPacket(packetPlayOutTimes);
    if (subtitle != null) {
      subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
      subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
      IChatBaseComponent titleSub = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
      PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, titleSub);
      connection.sendPacket(packetPlayOutSubTitle);
    }
    if (title != null) {
      title = title.replaceAll("%player%", player.getDisplayName());
      title = ChatColor.translateAlternateColorCodes('&', title);
      IChatBaseComponent titleMain = ChatSerializer.a("{\"text\": \"" + title + "\"}");
      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleMain);
      connection.sendPacket(packetPlayOutTitle);
    }
  }
  
  public static void sendTabTitle(Player player, String header, String footer) {
    if (header == null)
      header = "";
    header = ChatColor.translateAlternateColorCodes('&', header);
    if (footer == null) {
      footer = "";
    }
    footer = ChatColor.translateAlternateColorCodes('&', footer);
    
    header = header.replaceAll("%player%", player.getDisplayName());
    footer = footer.replaceAll("%player%", player.getDisplayName());
    
    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
    IChatBaseComponent tabTitle = ChatSerializer.a("{\"text\": \"" + header + "\"}");
    IChatBaseComponent tabFoot = ChatSerializer.a("{\"text\": \"" + footer + "\"}");
    PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabTitle);
    try {
      Field field = headerPacket.getClass().getDeclaredField("b");
      field.setAccessible(true);
      field.set(headerPacket, tabFoot);
    } catch (Exception e) {}
    finally {
      connection.sendPacket(headerPacket);
    }
  }
  
  boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
