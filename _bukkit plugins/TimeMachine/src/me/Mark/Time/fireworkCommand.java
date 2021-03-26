package me.Mark.Time;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class fireworkCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
  		 if(sender instanceof Player) {
  			 Player player = (Player)sender;
  			SpawnFirework(player.getLocation());	 
  		 } else if (args.length == 1)
		for (Player p : Bukkit.getOnlinePlayers())
			if (args[0].equals(p.getName())) {
				SpawnFirework(p.getLocation());
	            return true;
	}
		return true;
	}
	
	public static void SpawnFirework(Location loc) {
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        Random r = new Random();
        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).flicker(r.nextBoolean()).flicker(r.nextBoolean()).flicker(r.nextBoolean()).flicker(r.nextBoolean()).withColor(getColor()).withFade(getColor()).withColor(getColor()).withFade(getColor()).withColor(getColor()).withFade(getColor()).withColor(getColor()).withFade(getColor()).with(getType()).trail(r.nextBoolean()).with(getType()).trail(r.nextBoolean()).with(getType()).trail(r.nextBoolean()).with(getType()).trail(r.nextBoolean()).with(getType()).trail(r.nextBoolean()).build();
        fwm.addEffect(effect);
        fwm.setPower(1);
        fw.setFireworkMeta(fwm);	
	}
	
	private static Type getType() {
        int i = new Random().nextInt(5) + 1;
        if (i == 1) return Type.BALL;
        if (i == 2) return Type.BALL_LARGE;
        if (i == 3) return Type.BURST;
        if (i == 4) return Type.CREEPER;
        return Type.STAR;
	}
	
	private static Color getColor() {
		int i = new Random().nextInt(16);
		if(i==1) return Color.AQUA;
		if(i==2) return Color.BLACK;
		if(i==3)return Color.BLUE;
		if(i==4) return Color.FUCHSIA;
		if(i==5) return Color.GRAY;
		if(i==6)return Color.GREEN;
		if(i==7)return Color.LIME;
		if(i==8)return Color.MAROON;
		if(i==9)return Color.NAVY;
		if(i==10)return Color.OLIVE;
		if(i==11)return Color.ORANGE;
		if(i==12)return Color.PURPLE;
		if(i==13)return Color.RED;
		if(i==14)return Color.SILVER;
		if(i==15)return Color.TEAL;
		if(i==16)return Color.WHITE;
		return Color.YELLOW;
		}
	
	
}
